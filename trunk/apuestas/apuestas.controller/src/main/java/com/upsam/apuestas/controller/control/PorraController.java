package com.upsam.apuestas.controller.control;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upsam.apuestas.controller.dto.MensajeDTO;
import com.upsam.apuestas.controller.dto.PorraDTO;
import com.upsam.apuestas.controller.dto.util.IPorraUtilDTO;
import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.service.IPorraService;

@Controller
@RequestMapping("/porra")
public class PorraController {

	@Inject
	private IPorraService porraService;

	@Inject
	private IPorraUtilDTO porraUtilDTO;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	PorraDTO retrieve(@PathVariable("id") Integer id) {
		PorraDTO porraDTO = new PorraDTO();
		try {
			Porra porra = porraService.findOne(id);
			porraDTO = porraUtilDTO.toRest(porra);
		} catch (AppException e) {

		}
		return porraDTO;
	}

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

		}
		return porrasDTO;
	}

	// @RequestMapping(value = "/busqueda", method = RequestMethod.POST)
	// public @ResponseBody
	// List<PorraDTO> listAllFilter(@RequestBody BusquedaDTO busquedaDTO) {
	// List<PorraDTO> result = new ArrayList<PorraDTO>();
	//
	// try {
	// List<Cliente> clientes = clienteService.findAll();
	// if (isEmpty(busquedaDTO)) {
	// for (Cliente cliente : clientes) {
	// ClienteDTO e = new ClienteDTO();
	// e.toRest(cliente);
	// result.add(e);
	// }
	// } else {
	// List<Cliente> clientesFiltrados = filtrarClientes(clientes,
	// busquedaDTO);
	//
	// for (Cliente cliente : clientesFiltrados) {
	// ClienteDTO e = new ClienteDTO();
	// e.toRest(cliente);
	// result.add(e);
	// }
	// }
	// } catch (AppException e) {
	//
	// }
	// return result;
	// }
	//
	// private boolean isEmpty(BusquedaDTO busquedaDTO) {
	// return busquedaDTO.getApellidos().isEmpty()
	// && busquedaDTO.getMatricula().isEmpty()
	// && busquedaDTO.getNombre().isEmpty();
	// }
	//
	// private List<Cliente> filtrarClientes(List<Cliente> clientes,
	// BusquedaDTO busqueda) {
	// List<Cliente> result = new ArrayList<Cliente>();
	// for (Cliente cliente : clientes) {
	// if (busqueda.getApellidos() != null
	// && !busqueda.getApellidos().isEmpty()) {
	// if (cliente.getApellidos().toUpperCase()
	// .contains(busqueda.getApellidos().toUpperCase())
	// && !result.contains(cliente)) {
	// result.add(cliente);
	// }
	// }
	// if (busqueda.getMatricula() != null
	// && !busqueda.getMatricula().isEmpty()) {
	// if (existeCoche(cliente.getCoches(), busqueda.getMatricula())
	// && !result.contains(cliente)) {
	// result.add(cliente);
	// }
	// }
	// if (busqueda.getNombre() != null && !busqueda.getNombre().isEmpty()) {
	// if (cliente.getNombre().toUpperCase()
	// .contains(busqueda.getNombre().toUpperCase())
	// && !result.contains(cliente)) {
	// result.add(cliente);
	// }
	// }
	// }
	// return result;
	// }
	//
	// private boolean existeCoche(Set<Coche> coches, String matricula) {
	// boolean result = false;
	// if (coches != null && !coches.isEmpty()) {
	// for (Coche coche : coches) {
	// if (coche.getMatricula().toUpperCase()
	// .contains(matricula.toUpperCase())) {
	// result = true;
	// break;
	// }
	// }
	// }
	// return result;
	// }

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody PorraDTO porraDTO) {
		if (porraDTO == null) {
			return new MensajeDTO("Una porra es requerida", false);
		}
		try {
			Porra porra = porraUtilDTO.toBusiness(porraDTO);
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

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	MensajeDTO remove(@PathVariable Integer id, Model uiModel) {
		if (id == null) {
			return new MensajeDTO("Una porra es requerida", false);
		}
		try {
			Porra porra = new Porra();
			porra.setId(id);
			this.porraService.delete(porra);
			return new MensajeDTO("Porra eliminada correctamente", true);
		} catch (AppException e) {
			return new MensajeDTO("La porra no se ha podido borrar.", false);
		}
	}
}
