package com.upsam.apuestas.controller.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.upsam.apuestas.model.bean.Rol;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.service.IUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * A custom authentication manager that allows access if the user details exist
 * in the database and if the username and password are not the same. Otherwise,
 * throw a {@link BadCredentialsException}
 */
@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	/** The usuario service. */
	@Inject
	private IUsuarioService usuarioService;

	/** The logger. */
	protected static Log LOG = LogFactory
			.getLog(CustomAuthenticationProvider.class);

	// We need an Md5 encoder since our passwords in the database are Md5
	// encoded.
	/** The password encoder. */
	private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.AuthenticationProvider#
	 * authenticate(org.springframework.security.core.Authentication)
	 */
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {

		LOG.debug("Performing custom authentication");

		// Init a database user object
		Usuario usuario = null;

		try {
			// Retrieve user details from database
			usuario = usuarioService.selectByUser(auth.getName());
		} catch (Exception e) {
			// logger.error("User does not exists!");
			throw new BadCredentialsException("El usuario no existe");
		}

		if (usuario == null) {
			LOG.error("Usuario incorrecto!");
			throw new BadCredentialsException("Acceso incorrecto");
		}
		// Compare passwords
		// Make sure to encode the password first before comparing
		if (passwordEncoder.isPasswordValid(usuario.getPassword(),
				(String) auth.getCredentials(), null) == false) {
			LOG.error("Contraseña incorrecta!");
			throw new BadCredentialsException("Contraseña incorrecta");
		}

		LOG.debug("Los detalles del usuario son correctos");
		return new UsernamePasswordAuthenticationToken(usuario,
				auth.getCredentials(), getAuthorities(usuario.getRol()));
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where
	 * access level is an Integer. Basically, this interprets the access value
	 * whether it's for a regular user or admin.
	 * 
	 * @param access
	 *            an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	public Collection<GrantedAuthority> getAuthorities(Rol rol) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);

		// All users are granted with ROLE_USER access
		// Therefore this user gets a ROLE_USER by default
		// logger.debug("Grant ROLE_USER to this user");
		// Only permiss for his ROLE
		authList.add(new SimpleGrantedAuthority(rol.getRoleName()));

		// Return list of granted authorities
		return authList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.authentication.AuthenticationProvider#supports
	 * (java.lang.Class)
	 */
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(authentication));
	}
}
