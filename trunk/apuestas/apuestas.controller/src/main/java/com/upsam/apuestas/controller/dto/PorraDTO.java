package com.upsam.apuestas.controller.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraDTO.
 */
public class PorraDTO extends AbstractDTO {

	/** The fecha limite. */
	private String fechaLimite;

	/** The competicion. */
	private String competicion;

	/** The partidos dto. */
	private List<PartidoDTO> partidosDTO;

	/** The porra rellenada dto. */
	private List<PorraRellenadaDTO> porraRellenadaDTO;

	/**
	 * Gets the fecha limite.
	 * 
	 * @return the fecha limite
	 */
	public String getFechaLimite() {
		return fechaLimite;
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
	 * Gets the competicion.
	 * 
	 * @return the competicion
	 */
	public String getCompeticion() {
		return competicion;
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
	 * Gets the partidos dto.
	 * 
	 * @return the partidos dto
	 */
	public List<PartidoDTO> getPartidosDTO() {
		return partidosDTO;
	}

	/**
	 * Sets the partidos dto.
	 * 
	 * @param partidosDTO
	 *            the new partidos dto
	 */
	public void setPartidosDTO(List<PartidoDTO> partidosDTO) {
		this.partidosDTO = partidosDTO;
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
