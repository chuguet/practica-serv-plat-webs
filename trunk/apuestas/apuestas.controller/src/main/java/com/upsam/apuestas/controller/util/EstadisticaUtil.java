package com.upsam.apuestas.controller.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.batch.bean.EstadisticaCompeticion;
import com.upsam.apuestas.controller.dto.PartidoRellenadoEstadisticaDTO;
import com.upsam.apuestas.controller.dto.PorraRellenadaEstadisticaDTO;
import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.bean.PorraRellenada;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaUtil.
 */
@Component
public class EstadisticaUtil implements IEstadisticaUtil {

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

	/** The Constant NO_PRONOSTICADO. */
	private static final String NO_PRONOSTICADO = "No pronosticado";

	/** The Constant TANTO_POR_CIENTO. */
	private static final String TANTO_POR_CIENTO = "%";

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.controller.util.IEstadisticaUtil#
	 * calcularEstadisticaCompeticion(java.util.List)
	 */
	@Override
	public List<EstadisticaCompeticion> calcularEstadisticaCompeticion(
			List<PorraRellenada> porrasRellenadas) {
		List<EstadisticaCompeticion> result = new ArrayList<EstadisticaCompeticion>();
		EstadisticaCompeticion estadisticaCompeticion;
		PorraRellenadaEstadisticaDTO porraRellenadaEstadisticaDTO;
		for (PorraRellenada porraRellenada : porrasRellenadas) {
			porraRellenadaEstadisticaDTO = conversorDePorra(porraRellenada);
			estadisticaCompeticion = new EstadisticaCompeticion();
			estadisticaCompeticion.setCompeticion(porraRellenadaEstadisticaDTO
					.getCompeticion());
			estadisticaCompeticion.setFechaLimite(porraRellenadaEstadisticaDTO
					.getFechaLimite());
			estadisticaCompeticion.setFechaRelleno(porraRellenadaEstadisticaDTO
					.getFechaRelleno());
			estadisticaCompeticion
					.setPromedioParcial(porraRellenadaEstadisticaDTO
							.getIndiceAciertos());
			result.add(estadisticaCompeticion);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.util.IEstadisticaUtil#calcularEstadisticaTotal
	 * (java.util.List)
	 */
	@Override
	public String calcularEstadisticaTotal(List<PorraRellenada> porrasRellenadas) {
		List<PorraRellenadaEstadisticaDTO> porrasRellenadasEstadisticaDTO = new ArrayList<PorraRellenadaEstadisticaDTO>();
		PorraRellenadaEstadisticaDTO porraRellenadaEstadisticaDTO;
		for (PorraRellenada porraRellenada : porrasRellenadas) {
			porraRellenadaEstadisticaDTO = conversorDePorra(porraRellenada);
			porrasRellenadasEstadisticaDTO.add(porraRellenadaEstadisticaDTO);
		}
		String promedioTotal = calcularPromedioTotal(porrasRellenadasEstadisticaDTO);
		return promedioTotal;
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
	@Override
	public String calcularPromedioTotal(
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.util.IEstadisticaUtil#conversorDePorra(
	 * com.upsam.apuestas.model.bean.PorraRellenada)
	 */
	@Override
	public PorraRellenadaEstadisticaDTO conversorDePorra(
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

}
