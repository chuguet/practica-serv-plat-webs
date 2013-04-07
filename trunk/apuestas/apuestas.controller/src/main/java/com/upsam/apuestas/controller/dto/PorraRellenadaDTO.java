package com.upsam.apuestas.controller.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRellenadaDTO.
 */
public class PorraRellenadaDTO extends AbstractDTO {

	/** The competicion. */
	private String competicion;

	/** The fecha limite. */
	private String fechaLimite;

	/** The fecha relleno. */
	private String fechaRelleno;

	/** The id porra. */
	private Integer idPorra;

	/** The partidos rellenados dto. */
	private List<PartidoRellenadoDTO> partidosRellenadosDTO;

	/**
	 * Gets the competicion.
	 * 
	 * @return the competicion
	 */
	public String getCompeticion() {
		return competicion;
	}

	/**
	 * Gets the fecha limite.
	 * 
	 * @return the fecha limite
	 */
	public String getFechaLimite() {
		return fechaLimite;
	}

	/**
	 * Gets the fecha relleno.
	 * 
	 * @return the fecha relleno
	 */
	public String getFechaRelleno() {
		return fechaRelleno;
	}

	/**
	 * Gets the id porra.
	 * 
	 * @return the id porra
	 */
	public Integer getIdPorra() {
		return idPorra;
	}

	/**
	 * Gets the partidos rellenados dto.
	 * 
	 * @return the partidos rellenados dto
	 */
	public List<PartidoRellenadoDTO> getPartidosRellenadosDTO() {
		return partidosRellenadosDTO;
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
	 * Sets the fecha limite.
	 * 
	 * @param fechaLimite
	 *            the new fecha limite
	 */
	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	/**
	 * Sets the fecha relleno.
	 * 
	 * @param fechaRelleno
	 *            the new fecha relleno
	 */
	public void setFechaRelleno(String fechaRelleno) {
		this.fechaRelleno = fechaRelleno;
	}

	/**
	 * Sets the id porra.
	 * 
	 * @param idPorra
	 *            the new id porra
	 */
	public void setIdPorra(Integer idPorra) {
		this.idPorra = idPorra;
	}

	/**
	 * Sets the partidos rellenados dto.
	 * 
	 * @param partidosRellenadosDTO
	 *            the new partidos rellenados dto
	 */
	public void setPartidosRellenadosDTO(
			List<PartidoRellenadoDTO> partidosRellenadosDTO) {
		this.partidosRellenadosDTO = partidosRellenadosDTO;
	}

}
