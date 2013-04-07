package com.upsam.apuestas.controller.control;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upsam.apuestas.controller.dto.BusquedaDTO;
import com.upsam.apuestas.controller.dto.MensajeDTO;
import com.upsam.apuestas.controller.dto.PorraDTO;
import com.upsam.apuestas.controller.dto.util.IPorraUtilDTO;
import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.service.IPorraService;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraController.
 */
@Controller
@RequestMapping("/porra")
public class PorraController {

	private final static Log LOG = LogFactory.getLog(PorraController.class);

	/** The porra service. */
	@Inject
	private IPorraService porraService;

	/** The porra util dto. */
	@Inject
	private IPorraUtilDTO porraUtilDTO;

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the porra dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	PorraDTO retrieve(@PathVariable("id") Integer id) {
		PorraDTO porraDTO = new PorraDTO();
		try {
			Porra porra = porraService.findOne(id);
			porraDTO = porraUtilDTO.toRest(porra);
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}
		return porraDTO;
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

			for (Porra porra : porras) {
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
	 * @param busquedaDTO
	 *            the busqueda dto
	 * @return the list
	 */
	@RequestMapping(value = "/busqueda", method = RequestMethod.POST)
	public @ResponseBody
	List<PorraDTO> listAllFilter(@RequestBody BusquedaDTO busquedaDTO) {
		List<PorraDTO> result = new ArrayList<PorraDTO>();

		try {
			List<Porra> porras = porraService.findAll();
			if (isEmpty(busquedaDTO)) {
				for (Porra porra : porras) {
					PorraDTO porraDTO = new PorraDTO();
					porraDTO = this.porraUtilDTO.toRest(porra);
					result.add(porraDTO);
				}
			} else {
				List<Porra> porrasFiltradas = filtrarPorras(porras, busquedaDTO);
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
			if (busqueda.getCompeticion() != null
					&& !busqueda.getCompeticion().isEmpty()) {
				if (porra.getCompeticion().toUpperCase()
						.contains(busqueda.getCompeticion().toUpperCase())
						&& !result.contains(porra)) {
					result.add(porra);
				}
			}
			if (busqueda.getEquipo() != null && !busqueda.getEquipo().isEmpty()) {
				if (existeEquipo(porra.getPartidos(), busqueda.getEquipo())
						&& !result.contains(porra)) {
					result.add(porra);
				}
			}
		}
		return result;
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
	 * Insert.
	 * 
	 * @param porraDTO
	 *            the porra dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody PorraDTO porraDTO) {
		if (porraDTO == null) {
			return new MensajeDTO("Una porra es requerida", false);
		}
		try {
			Porra porra = porraUtilDTO.toBusiness(porraDTO);
			porra.setPublicada(Boolean.FALSE);
			porraService.save(porra);
			return new MensajeDTO("Porra creada correctamente", true);
		} catch (AppException e) {
			return new MensajeDTO(new StringBuffer(
					"Ya existe una porra de la competición ")
					.append(porraDTO.getCompeticion())
					.append(" en base de datos.").toString(), false);
		}
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
		if (!operacion.equals("list") && !operacion.equals("busqueda")) {
			operacion = "form";
		}
		return new StringBuffer("porra/").append(operacion).toString();
	}

	/**
	 * Update.
	 * 
	 * @param porraDTO
	 *            the porra dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody PorraDTO porraDTO) {
		if (porraDTO == null) {
			return new MensajeDTO("Una porra es requerida", false);
		}
		try {
			Porra porra = porraUtilDTO.toBusiness(porraDTO);
			porraService.update(porra);
			return new MensajeDTO("Porra modificada correctamente", true);
		} catch (AppException e) {
			return new MensajeDTO(new StringBuffer(
					"Ya existe una porra de la competición ")
					.append(porraDTO.getCompeticion())
					.append(" en base de datos.").toString(), false);
		}
	}

	@RequestMapping(value = "/publicar/{id}", method = RequestMethod.GET)
	public @ResponseBody
	MensajeDTO publicar(@PathVariable("id") Integer idPorra) {
		try {
			Porra porra = porraService.findOne(idPorra);
			porra.setPublicada(Boolean.TRUE);
			porraService.update(porra);
			return new MensajeDTO("Porra publicada correctamente", true);
		} catch (AppException e) {
			return new MensajeDTO("La porra no se ha podido publicar.", false);
		}
	}

	/**
	 * Removes the.
	 * 
	 * @param id
	 *            the id
	 * @param uiModel
	 *            the ui model
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	MensajeDTO remove(@PathVariable Integer id, Model uiModel) {
		if (id == null) {
			return new MensajeDTO("Una porra es requerida", false);
		}
		try {
			Porra porra = this.porraService.findOne(id);
			if (porra.getPublicada()) {
				return new MensajeDTO("No se puede borrar una porra publicada", true);
			} else {
				this.porraService.delete(porra);
				return new MensajeDTO("Porra eliminada correctamente", true);
			}
		} catch (AppException e) {
			return new MensajeDTO("La porra no se ha podido borrar.", false);
		}
	}
}
