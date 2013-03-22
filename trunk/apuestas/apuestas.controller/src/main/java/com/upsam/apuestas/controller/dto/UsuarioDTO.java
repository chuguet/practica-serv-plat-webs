package com.upsam.apuestas.controller.dto;

import java.util.List;

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

	/** The porra rellenada dto. */
	private List<PorraRellenadaDTO> porraRellenadaDTO;

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
	 * @param pRol
	 *            the new rol
	 */
	public void setRol(String pRol) {
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

	/**
	 * Gets the porra rellenada dto.
	 * 
	 * @return the porra rellenada dto
	 */
	public List<PorraRellenadaDTO> getPorraRellenadaDTO() {
		return porraRellenadaDTO;
	}

	/**
	 * Sets the porra rellenada dto.
	 * 
	 * @param porraRellenadaDTO
	 *            the new porra rellenada dto
	 */
	public void setPorraRellenadaDTO(List<PorraRellenadaDTO> porraRellenadaDTO) {
		this.porraRellenadaDTO = porraRellenadaDTO;
	}

}
