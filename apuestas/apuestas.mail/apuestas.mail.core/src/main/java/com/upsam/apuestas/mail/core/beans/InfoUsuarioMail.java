package com.upsam.apuestas.mail.core.beans;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class InfoUsuarioMail.
 */
public class InfoUsuarioMail {

	/** The apellidos. */
	private String apellidos;

	/** The email. */
	private String email;

	/** The estadistica competicion. */
	private List<EstadisticaCompeticionMail> estadisticaCompeticionMail;

	/** The nombre. */
	private String nombre;

	/** The promedio total. */
	private String promedioTotal;

	/**
	 * Gets the apellidos.
	 * 
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the estadistica competicion mail.
	 * 
	 * @return the estadistica competicion mail
	 */
	public List<EstadisticaCompeticionMail> getEstadisticaCompeticionMail() {
		return estadisticaCompeticionMail;
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
	 * Gets the promedio total.
	 * 
	 * @return the promedio total
	 */
	public String getPromedioTotal() {
		return promedioTotal;
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
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the estadistica competicion mail.
	 * 
	 * @param estadisticaCompeticionMail
	 *            the new estadistica competicion mail
	 */
	public void setEstadisticaCompeticionMail(
			List<EstadisticaCompeticionMail> estadisticaCompeticionMail) {
		this.estadisticaCompeticionMail = estadisticaCompeticionMail;
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
	 * Sets the promedio total.
	 * 
	 * @param promedioTotal
	 *            the new promedio total
	 */
	public void setPromedioTotal(String promedioTotal) {
		this.promedioTotal = promedioTotal;
	}
}
