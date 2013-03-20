package com.upsam.apuestas.controller.control;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upsam.apuestas.model.bean.Rol;
import com.upsam.apuestas.model.bean.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/** The Constant sdf. */
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));

	/**
	 * Contiene algun rol de acceso.
	 * 
	 * @param authorities
	 *            the authorities
	 * @return true, if successful
	 */
	private boolean contieneAlgunRolDeAcceso(
			Collection<GrantedAuthority> authorities) {
		return authorities.contains(new SimpleGrantedAuthority(Rol.ROLE_ADMIN
				.getRoleName()))
				|| authorities.contains(new SimpleGrantedAuthority(
						Rol.ROLE_USER.getRoleName()));
	}

	/**
	 * Petición REST para comprobar que el logueo se hace desde un dispositivo
	 * movil.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	/**
	 * Petición REST que tras realizar un logueo fallido nos lleva a la pantalla
	 * de login de nuevo.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	/**
	 * Peticion REST que nos realiza el logout de la aplicación y nos lleva a la
	 * pagina de login.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}

	/**
	 * Principal.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String principal(ModelMap model) {
		return "redirect:/home";
	}

	/**
	 * Prints the welcome.
	 * 
	 * @param model
	 *            the model
	 * @param principal
	 *            the principal
	 * @return the string
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {
		UsernamePasswordAuthenticationToken u = (UsernamePasswordAuthenticationToken) principal;
		if (u != null && contieneAlgunRolDeAcceso(u.getAuthorities())) {
			Usuario usuario = (Usuario) u.getPrincipal();
			model.addAttribute("nombre", usuario.getNombre());
			model.addAttribute("apellidos", usuario.getApellidos());
			model.addAttribute("fecha",
					sdf.format(Calendar.getInstance().getTime()));
			return "home";
		} else {
			model.addAttribute("noAccess", true);
			return "login";
		}
	}

}
