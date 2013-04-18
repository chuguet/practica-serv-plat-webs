package com.upsam.apuestas.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class BusquedaDTO.
 */
public class BusquedaDTO {

	/** The competicion. */
	private String competicion;

	/** The equipo. */
	private String equipo;

	/**
	 * Instantiates a new busqueda dto.
	 */
	public BusquedaDTO() {
	}

	/**
	 * Instantiates a new busqueda dto.
	 * 
	 * @param competicion
	 *            the competicion
	 * @param equipo
	 *            the equipo
	 */
	public BusquedaDTO(String competicion, String equipo) {
		this.competicion = competicion;
		this.equipo = equipo;
	}

	/**
	 * Gets the competicion.
	 * 
	 * @return the competicion
	 */
	public String getCompeticion() {
		return competicion;
	}

	/**
	 * Gets the equipo.
	 * 
	 * @return the equipo
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * Sets the competicion.
	 * 
	 * @param competicion
	 *            the new competicion
	 */
	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}

	/**
	 * Sets the equipo.
	 * 
	 * @param equipo
	 *            the new equipo
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
}
