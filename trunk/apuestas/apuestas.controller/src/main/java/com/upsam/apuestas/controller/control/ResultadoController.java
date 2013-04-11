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

import com.upsam.apuestas.controller.dto.PorraRellenadaDTO;
import com.upsam.apuestas.controller.dto.util.IPorraRellenadaUtilDTO;
import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;

@Controller
@RequestMapping("/resultado")
public class ResultadoController {
	private final static Log LOG = LogFactory.getLog(ResultadoController.class);
	@Inject
	private IPorraRellenadaUtilDTO porraRellenadaUtil;

	@RequestMapping(value = "/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(@PathVariable("operacion") String operacion,
			final Model uiModel) {
		uiModel.addAttribute("operacion", operacion);
		if (!operacion.equals("list") && !operacion.equals("busqueda")) {
			operacion = "form";
		}
		return new StringBuffer("resultado/").append(operacion).toString();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<PorraRellenadaDTO> listAll() {
		List<PorraRellenadaDTO> result = new ArrayList<PorraRellenadaDTO>();

		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			Usuario user = (Usuario) auth.getPrincipal();
			for (PorraRellenada porraRellenada : user.getPorraRellenada()) {
				result.add(porraRellenadaUtil.toRest(porraRellenada));
			}
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

}
