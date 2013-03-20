package com.upsam.apuestas.controller.dto;

import com.upsam.apuestas.model.bean.Rol;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDTO.
 */
public class UsuarioDTO extends AbstractDTO {

	/** The admin. */
	private String rol;

	/** The apellidos. */
	private String apellidos;

	/** The nombre. */
	private String nombre;

	/** The password. */
	private String password;

	/** The user. */
	private String user;

	/**
	 * Gets the admin.
	 * 
	 * @return the admin
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Gets the apellidos.
	 * 
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the admin.
	 * 
	 * @param admin
	 *            the new admin
	 */
	public void setAdmin(String pRol) {
		this.rol = pRol;
	}

	/**
	 * Sets the apellidos.
	 * 
	 * @param apellidos
	 *            the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gestaller.contabilidad.controller.dto.AbstractDTO#toBusiness(java
	 * .lang.Object)
	 */
	@Override
	public void toBusiness(Object object) throws AppException {
		Usuario usuario = (Usuario) object;
		usuario.setId(this.getId());
		usuario.setNombre(this.nombre);
		usuario.setApellidos(this.apellidos);
		if (this.rol.equals("Administrador")) {
			usuario.setRol(Rol.ROLE_ADMIN);
		} else if (this.rol.equals("Usuario")) {
			usuario.setRol(Rol.ROLE_USER);
		}
		usuario.setUser(this.user);
		usuario.setPassword(this.password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gestaller.contabilidad.controller.dto.AbstractDTO#toRest(java.lang
	 * .Object)
	 */
	@Override
	public void toRest(Object object) throws AppException {
		Usuario usuario = (Usuario) object;
		this.setId(usuario.getId());
		this.nombre = usuario.getNombre();
		this.apellidos = usuario.getApellidos();
		this.rol = usuario.getRol().getNameId();
		this.user = usuario.getUser();
		this.password = usuario.getPassword();
	}

}
