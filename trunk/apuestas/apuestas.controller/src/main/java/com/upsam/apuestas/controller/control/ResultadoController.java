package com.upsam.apuestas.controller.control;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upsam.apuestas.controller.dto.EstadisticaResultadoDTO;
import com.upsam.apuestas.controller.dto.PartidoRellenadoEstadisticaDTO;
import com.upsam.apuestas.controller.dto.PorraRellenadaEstadisticaDTO;
import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.service.IUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultadoController.
 */
@Controller
@RequestMapping("/resultado")
public class ResultadoController {

	/** The Constant ACERTADO. */
	private static final String ACERTADO = "Acertado";

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"EEEE, d 'de' MMMM 'de' yyyy 'a las' HH:mm", new Locale("es", "ES"));

	/** The Constant DECIMAL_FORMATTER. */
	private static final String DECIMAL_FORMATTER = "##.##";

	/** The Constant EN_ESPERA. */
	private static final String EN_ESPERA = "En espera";

	/** The Constant FALLADO. */
	private static final String FALLADO = "Fallado";

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(ResultadoController.class);

	/** The Constant NO_PRONOSTICADO. */
	private static final String NO_PRONOSTICADO = "No pronosticado";

	/** The Constant TANTO_POR_CIENTO. */
	private static final String TANTO_POR_CIENTO = "%";

	/** The usuario service. */
	@Inject
	private IUsuarioService usuarioService;

	/**
	 * Calcular denominador aciertos.
	 * 
	 * @param partidosRellenadosEstadisticaDTO
	 *            the partidos rellenados estadistica dto
	 * @return the double
	 */
	private Double calcularDenominadorAciertos(
			List<PartidoRellenadoEstadisticaDTO> partidosRellenadosEstadisticaDTO) {
		Double result = 0.0;
		for (PartidoRellenadoEstadisticaDTO partidoRellenadoEstadistica : partidosRellenadosEstadisticaDTO) {
			if (partidoRellenadoEstadistica.getSolucion().equals(FALLADO)
					|| partidoRellenadoEstadistica.getSolucion().equals(
							ACERTADO)) {
				result++;
			}
		}
		return result;
	}

	/**
	 * Calcular indice aciertos.
	 * 
	 * @param partidosRellenadosEstadisticaDTO
	 *            the partidos rellenados estadistica dto
	 * @return the string
	 */
	private String calcularIndiceAciertos(
			List<PartidoRellenadoEstadisticaDTO> partidosRellenadosEstadisticaDTO) {
		DecimalFormat df = new DecimalFormat(DECIMAL_FORMATTER);
		Double indiceAciertos = 0.0;
		Double denominador = new Double(
				calcularDenominadorAciertos(partidosRellenadosEstadisticaDTO));
		Double numerador = 0.0;
		for (PartidoRellenadoEstadisticaDTO partidoRellenadoEstadisticaDTO : partidosRellenadosEstadisticaDTO) {
			if (partidoRellenadoEstadisticaDTO.getSolucion().equals(ACERTADO)) {
				numerador++;
			}
		}
		indiceAciertos = numerador / denominador;
		if (indiceAciertos.isNaN()) {
			indiceAciertos = 0.0;
		} else {
			indiceAciertos = indiceAciertos * 100;
		}

		return new StringBuffer(df.format(indiceAciertos)).append(
				TANTO_POR_CIENTO).toString();
	}

	/**
	 * Calcular promedio total.
	 * 
	 * @param porrasRellenadasEstadisticaDTO
	 *            the porras rellenadas estadistica dto
	 * @return the string
	 */
	private String calcularPromedioTotal(
			List<PorraRellenadaEstadisticaDTO> porrasRellenadasEstadisticaDTO) {
		DecimalFormat df = new DecimalFormat(DECIMAL_FORMATTER);
		Double denominador = 0.0;
		Double numerador = 0.0;
		Double indiceAciertos = 0.0;

		for (PorraRellenadaEstadisticaDTO porraRellenadaEstadisticaDTO : porrasRellenadasEstadisticaDTO) {
			denominador += calcularDenominadorAciertos(porraRellenadaEstadisticaDTO
					.getPartidosRellenadosEstadisticaDTO());
			for (PartidoRellenadoEstadisticaDTO partidoRellenadoEstadisticaDTO : porraRellenadaEstadisticaDTO
					.getPartidosRellenadosEstadisticaDTO()) {
				if (partidoRellenadoEstadisticaDTO.getSolucion().equals(
						ACERTADO)) {
					numerador++;
				}
			}
		}
		indiceAciertos = numerador / denominador;
		if (indiceAciertos.isNaN()) {
			indiceAciertos = 0.0;
		} else {
			indiceAciertos = indiceAciertos * 100;
		}

		return new StringBuffer(df.format(indiceAciertos)).append(
				TANTO_POR_CIENTO).toString();
	}

	/**
	 * Conversor de porra.
	 * 
	 * @param porraRellenada
	 *            the porra rellenada
	 * @return the porra rellenada estadistica dto
	 */
	private PorraRellenadaEstadisticaDTO conversorDePorra(
			PorraRellenada porraRellenada) {
		PorraRellenadaEstadisticaDTO result = new PorraRellenadaEstadisticaDTO();

		result.setCompeticion(porraRellenada.getPorra().getCompeticion());
		result.setFechaLimite(DATE_FORMATTER.format(porraRellenada.getPorra()
				.getFechaLimite()));
		result.setFechaRelleno(DATE_FORMATTER.format(porraRellenada
				.getFechaRelleno()));

		PartidoRellenadoEstadisticaDTO partidoRellenadoEstadisticaDTO;
		List<PartidoRellenadoEstadisticaDTO> partidosRellenadosEstadisticaDTO = new ArrayList<PartidoRellenadoEstadisticaDTO>();
		for (PartidoRellenado partidoRellenado : porraRellenada
				.getPartidosRellenados()) {
			for (Partido partido : porraRellenada.getPorra().getPartidos()) {
				if (partido.getOrdinal().equals(partidoRellenado.getOrdinal())) {
					partidoRellenadoEstadisticaDTO = new PartidoRellenadoEstadisticaDTO();
					partidoRellenadoEstadisticaDTO.setLocal(partidoRellenado
							.getLocal());
					partidoRellenadoEstadisticaDTO
							.setVisitante(partidoRellenado.getVisitante());
					partidoRellenadoEstadisticaDTO.setOrdinal(partidoRellenado
							.getOrdinal());
					if (partidoRellenado.getResultado() != null) {
						partidoRellenadoEstadisticaDTO
								.setResultadoPronosticado(partidoRellenado
										.getResultado().getNameId());
					} else {
						partidoRellenadoEstadisticaDTO
								.setResultadoPronosticado(NO_PRONOSTICADO);
					}
					if (partido.getResultado() != null) {
						partidoRellenadoEstadisticaDTO.setResultadoReal(partido
								.getResultado().getNameId());
					} else {
						partidoRellenadoEstadisticaDTO
								.setResultadoReal("Partido no resulto a&uacute;n");
					}
					if (partido.getResultado() == null) {
						partidoRellenadoEstadisticaDTO.setSolucion(EN_ESPERA);
					} else {
						if (partidoRellenado.getResultado() != null
								&& partido.getResultado().equals(
										partidoRellenado.getResultado())) {
							partidoRellenadoEstadisticaDTO
									.setSolucion(ACERTADO);
						} else {
							partidoRellenadoEstadisticaDTO.setSolucion(FALLADO);
						}
					}
					partidosRellenadosEstadisticaDTO
							.add(partidoRellenadoEstadisticaDTO);
				}
			}
		}
		result.setPartidosRellenadosEstadisticaDTO(partidosRellenadosEstadisticaDTO);
		String indiceAciertos = calcularIndiceAciertos(partidosRellenadosEstadisticaDTO);
		result.setIndiceAciertos(indiceAciertos);

		return result;
	}

	/**
	 * Creates the form.
	 * 
	 * @param operacion
	 *            the operacion
	 * @param uiModel
	 *            the ui model
	 * @return the string
	 */
	@RequestMapping(value = "/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(@PathVariable("operacion") String operacion,
			final Model uiModel) {
		uiModel.addAttribute("operacion", operacion);
		if (!operacion.equals("list")) {
			operacion = "form";
		}
		return new StringBuffer("resultado/").append(operacion).toString();
	}

	/**
	 * List all.
	 * 
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	EstadisticaResultadoDTO retrieveResultados() {
		EstadisticaResultadoDTO result = new EstadisticaResultadoDTO();
		List<PorraRellenadaEstadisticaDTO> porrasRellenadasEstadisticaDTO = new ArrayList<PorraRellenadaEstadisticaDTO>();
		PorraRellenadaEstadisticaDTO porraRellenadaEstadisticaDTO;

		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			Usuario user = (Usuario) auth.getPrincipal();
			List<PorraRellenada> porrasRellenadas;
			porrasRellenadas = usuarioService.findOne(user.getId())
					.getPorraRellenada();

			for (PorraRellenada porraRellenada : porrasRellenadas) {
				porraRellenadaEstadisticaDTO = conversorDePorra(porraRellenada);
				porrasRellenadasEstadisticaDTO
						.add(porraRellenadaEstadisticaDTO);
			}
			result.setPorrasRellenadasEstadisticaDTO(porrasRellenadasEstadisticaDTO);
			String promedioTotal = calcularPromedioTotal(porrasRellenadasEstadisticaDTO);
			result.setPromedioAciertos(new StringBuffer(
					"SU PROMEDIO TOTAL DE ACIERTOS ES DEL ").append(
					promedioTotal).toString());
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}

		return result;
	}
}
