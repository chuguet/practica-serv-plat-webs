package com.upsam.apuestas.controller.control;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upsam.apuestas.batch.bean.InfoUsuario;
import com.upsam.apuestas.batch.bean.InfoUsuarios;
import com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.service.IUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class MailController.
 */
@Controller
@RequestMapping("/mail")
public class MailController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(MailController.class);

	/** The user service. */
	@Inject
	private IUsuarioService userService;

	/** The usuario util dto. */
	@Inject
	private IUsuarioUtilDTO usuarioUtilDTO;

	/**
	 * Gets the info usuarios.
	 * 
	 * @return the info usuarios
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public @ResponseBody
	InfoUsuarios getInfoUsuarios() {
		InfoUsuarios result = new InfoUsuarios();
		List<InfoUsuario> infoUsuarios = new ArrayList<InfoUsuario>();
		InfoUsuario infoUsuario;
		try {
			List<Usuario> usuarios = userService.findAll();
			for (Usuario usuario : usuarios) {
				infoUsuario = usuarioUtilDTO.toInfoUsuario(usuario);
				infoUsuarios.add(infoUsuario);
			}
			result.setUsuarios(infoUsuarios);
		} catch (AppException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}
}
