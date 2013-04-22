package com.upsam.apuestas.controller.control;

import java.util.ArrayList;
import java.util.List;

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
import com.upsam.apuestas.controller.dto.PorraRellenadaEstadisticaDTO;
import com.upsam.apuestas.controller.util.IEstadisticaUtil;
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

	@Inject
	private IEstadisticaUtil estadisticaUtil;

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(ResultadoController.class);

	/** The usuario service. */
	@Inject
	private IUsuarioService usuarioService;

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
				porraRellenadaEstadisticaDTO = estadisticaUtil
						.conversorDePorra(porraRellenada);
				porrasRellenadasEstadisticaDTO
						.add(porraRellenadaEstadisticaDTO);
			}
			result.setPorrasRellenadasEstadisticaDTO(porrasRellenadasEstadisticaDTO);
			String promedioTotal = estadisticaUtil
					.calcularPromedioTotal(porrasRellenadasEstadisticaDTO);
			result.setPromedioAciertos(new StringBuffer(
					"SU PROMEDIO TOTAL DE ACIERTOS ES DEL ").append(
					promedioTotal).toString());
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}

		return result;
	}
}
