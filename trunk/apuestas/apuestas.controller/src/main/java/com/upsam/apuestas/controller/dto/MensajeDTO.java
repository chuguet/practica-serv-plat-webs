package com.upsam.apuestas.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeDTO.
 */
public class MensajeDTO {

	/** The correcto. */
	private Boolean correcto;

	/** The mensaje. */
	private String mensaje;

	/** The parameter. */
	private Object parameter;

	/**
	 * Instantiates a new mensaje dto.
	 * 
	 * @param mensaje
	 *            the mensaje
	 * @param correcto
	 *            the correcto
	 */
	public MensajeDTO(String mensaje, boolean correcto) {
		this.correcto = correcto;
		this.mensaje = mensaje;
	}

	/**
	 * Instantiates a new mensaje dto.
	 * 
	 * @param mensaje
	 *            the mensaje
	 * @param correcto
	 *            the correcto
	 * @param parameter
	 *            the parameter
	 */
	public MensajeDTO(String mensaje, boolean correcto, Object parameter) {
		this.correcto = correcto;
		this.mensaje = mensaje;
		this.parameter = parameter;
	}

	/**
	 * Gets the correcto.
	 * 
	 * @return the correcto
	 */
	public Boolean getCorrecto() {
		return correcto;
	}

	/**
	 * Gets the mensaje.
	 * 
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Gets the parameter.
	 * 
	 * @return the parameter
	 */
	public Object getParameter() {
		return parameter;
	}

	/**
	 * Sets the correcto.
	 * 
	 * @param correcto
	 *            the new correcto
	 */
	public void setCorrecto(Boolean correcto) {
		this.correcto = correcto;
	}

	/**
	 * Sets the mensaje.
	 * 
	 * @param mensaje
	 *            the new mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Sets the parameter.
	 * 
	 * @param parameter
	 *            the new parameter
	 */
	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}
}