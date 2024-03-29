package com.upsam.apuestas.controller.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upsam.apuestas.controller.dto.BusquedaDTO;
import com.upsam.apuestas.controller.dto.MensajeDTO;
import com.upsam.apuestas.controller.dto.PorraDTO;
import com.upsam.apuestas.controller.dto.PorraRellenadaDTO;
import com.upsam.apuestas.controller.dto.util.IPorraRellenadaUtilDTO;
import com.upsam.apuestas.controller.dto.util.IPorraUtilDTO;
import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.service.IPartidoRellenadoService;
import com.upsam.apuestas.model.service.IPorraRellenadaService;
import com.upsam.apuestas.model.service.IPorraService;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRellenadaController.
 */
@Controller
@RequestMapping("/porraRellenada")
public class PorraRellenadaController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory
			.getLog(PorraRellenadaController.class);

	/** The partido rellenado service. */
	@Inject
	private IPartidoRellenadoService partidoRellenadoService;

	/** The porra rellenada service. */
	@Inject
	private IPorraRellenadaService porraRellenadaService;

	/** The porra rellenada util dto. */
	@Inject
	private IPorraRellenadaUtilDTO porraRellenadaUtilDTO;

	/** The porra service. */
	@Inject
	private IPorraService porraService;

	/** The porra util dto. */
	@Inject
	private IPorraUtilDTO porraUtilDTO;

	/**
	 * Convertir porra a porra rellenada.
	 * 
	 * @param porra
	 *            the porra
	 * @return the porra rellenada
	 */
	private PorraRellenada convertirPorraAPorraRellenada(Porra porra) {
		PorraRellenada result = new PorraRellenada();
		result.setPorra(porra);
		PartidoRellenado partidoRellenado;
		List<PartidoRellenado> partidosRellenados = new ArrayList<PartidoRellenado>();
		for (Partido partido : porra.getPartidos()) {
			partidoRellenado = new PartidoRellenado();
			partidoRellenado.setLocal(partido.getLocal());
			partidoRellenado.setOrdinal(partido.getOrdinal());
			partidoRellenado.setVisitante(partido.getVisitante());
			partidosRellenados.add(partidoRellenado);
		}
		result.setPartidosRellenados(partidosRellenados);
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
		return new StringBuffer("porraRellenada/").append(operacion).toString();
	}

	/**
	 * Existe equipo.
	 * 
	 * @param partidos
	 *            the partidos
	 * @param equipo
	 *            the equipo
	 * @return true, if successful
	 */
	private boolean existeEquipo(List<Partido> partidos, String equipo) {
		for (Partido partido : partidos) {
			if (partido.getLocal().toUpperCase().contains(equipo.toUpperCase())
					|| partido.getVisitante().toUpperCase()
							.contains(equipo.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Filtrar porras.
	 * 
	 * @param porras
	 *            the porras
	 * @param busqueda
	 *            the busqueda
	 * @return the list
	 */
	private List<Porra> filtrarPorras(List<Porra> porras, BusquedaDTO busqueda) {
		List<Porra> result = new ArrayList<Porra>();
		for (Porra porra : porras) {
			if (porra.getCompeticion().toUpperCase()
					.contains(busqueda.getCompeticion().toUpperCase())
					&& !result.contains(porra)
					&& busqueda.getEquipo() != null
					&& existeEquipo(porra.getPartidos(), busqueda.getEquipo())) {
				result.add(porra);
			}
		}
		return result;
	}

	/**
	 * Filtrar porras por fecha.
	 * 
	 * @param porras
	 *            the porras
	 * @return the list
	 */
	private List<Porra> filtrarPorrasPorFechaYPublicadas(List<Porra> porras) {
		List<Porra> result = new ArrayList<Porra>();
		for (Porra porra : porras) {
			if (new Date().before(porra.getFechaLimite())
					&& porra.getPublicada()) {
				result.add(porra);
			}
		}
		return result;
	}

	/**
	 * Insert.
	 * 
	 * @param porraRellenadaDTO
	 *            the porra rellenada dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody PorraRellenadaDTO porraRellenadaDTO) {
		if (porraRellenadaDTO == null) {
			return new MensajeDTO("Una porra rellenada es requerida", false);
		}
		try {
			PorraRellenada porraRellenada = porraRellenadaUtilDTO
					.toBusiness(porraRellenadaDTO);
			porraRellenadaService.save(porraRellenada);
			return new MensajeDTO("Porra rellenada correctamente", true);
		} catch (AppException e) {
			return new MensajeDTO("La operaci&oacute;n no se pudo completar",
					false);
		}
	}

	/**
	 * Checks if is empty.
	 * 
	 * @param busquedaDTO
	 *            the busqueda dto
	 * @return true, if is empty
	 */
	private boolean isEmpty(BusquedaDTO busquedaDTO) {
		return busquedaDTO.getCompeticion().isEmpty()
				&& busquedaDTO.getEquipo().isEmpty();
	}

	/**
	 * List all.
	 * 
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<PorraDTO> listAll() {
		List<PorraDTO> porrasDTO = new ArrayList<PorraDTO>();

		try {
			List<Porra> porras = porraService.findAll();
			List<Porra> porrasFiltradasPorFecha = filtrarPorrasPorFechaYPublicadas(porras);
			for (Porra porra : porrasFiltradasPorFecha) {
				PorraDTO porraDTO = new PorraDTO();
				porraDTO = porraUtilDTO.toRest(porra);
				porrasDTO.add(porraDTO);
			}
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}
		return porrasDTO;
	}

	/**
	 * List all filter.
	 * 
	 * @param competicion
	 *            the competicion
	 * @param equipo
	 *            the equipo
	 * @return the list
	 */
	@RequestMapping(value = "/busqueda", method = RequestMethod.GET)
	public @ResponseBody
	List<PorraDTO> listAllFilter(
			@RequestParam(value = "competicion") String competicion,
			@RequestParam(value = "equipo") String equipo) {
		List<PorraDTO> result = new ArrayList<PorraDTO>();
		BusquedaDTO busquedaDTO = new BusquedaDTO(competicion, equipo);

		try {
			List<Porra> porras = porraService.findAll();
			List<Porra> porrasFiltradasPorFecha = filtrarPorrasPorFechaYPublicadas(porras);
			if (isEmpty(busquedaDTO)) {
				for (Porra porra : porrasFiltradasPorFecha) {
					PorraDTO porraDTO = new PorraDTO();
					porraDTO = this.porraUtilDTO.toRest(porra);
					result.add(porraDTO);
				}
			} else {
				List<Porra> porrasFiltradas = filtrarPorras(
						porrasFiltradasPorFecha, busquedaDTO);
				for (Porra porra : porrasFiltradas) {
					PorraDTO porraDTO = new PorraDTO();
					porraDTO = this.porraUtilDTO.toRest(porra);
					result.add(porraDTO);
				}
			}
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Recuperar porra rellenada por competicion y usuario.
	 * 
	 * @param competicion
	 *            the competicion
	 * @param user
	 *            the user
	 * @return the porra rellenada
	 */
	private PorraRellenada recuperarPorraRellenadaPorCompeticionYUsuario(
			String competicion, String user) {
		PorraRellenada result = null;
		try {

			List<PorraRellenada> porrasRellenadas = porraRellenadaService
					.findAll();
			for (PorraRellenada porraRellenada : porrasRellenadas) {
				if (porraRellenada.getPorra().getCompeticion()
						.equals(competicion)
						&& porraRellenada.getUsuario().getUser().equals(user)) {
					result = porraRellenada;
					break;
				}
			}
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the porra dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	PorraRellenadaDTO retrieve(@PathVariable("id") Integer id) {
		PorraRellenadaDTO porraRellenadaDTO = new PorraRellenadaDTO();
		try {
			Porra porra = porraService.findOne(id);
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			Usuario user = (Usuario) auth.getPrincipal();
			PorraRellenada porraRellenada = recuperarPorraRellenadaPorCompeticionYUsuario(
					porra.getCompeticion(), user.getUser());
			if (porraRellenada == null) {
				porraRellenada = convertirPorraAPorraRellenada(porra);
			}
			porraRellenadaDTO = porraRellenadaUtilDTO.toRest(porraRellenada);
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}
		return porraRellenadaDTO;
	}

	/**
	 * Update.
	 * 
	 * @param porraRellenadaDTO
	 *            the porra rellenada dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody PorraRellenadaDTO porraRellenadaDTO) {
		if (porraRellenadaDTO == null) {
			return new MensajeDTO("Una porra es requerida", false);
		}
		try {
			PorraRellenada porraRellenada = porraRellenadaUtilDTO
					.toBusiness(porraRellenadaDTO);
			porraRellenadaService.update(porraRellenada);
			return new MensajeDTO(
					"Modificaci&oacute;n de resultados de porra correcta", true);
		} catch (AppException e) {
			return new MensajeDTO("No se ha podido actualizar la porra", false);
		}
	}

}
