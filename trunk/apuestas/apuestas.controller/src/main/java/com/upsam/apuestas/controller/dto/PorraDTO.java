package com.upsam.apuestas.controller.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraDTO.
 */
public class PorraDTO extends AbstractDTO {

	/** The competicion. */
	private String competicion;

	/** The fecha limite. */
	private String fechaLimite;

	/** The partidos dto. */
	private List<PartidoDTO> partidosDTO;

	/** The porra rellenada dto. */
	private List<PorraRellenadaDTO> porraRellenadaDTO;

	/** The publicada. */
	private String publicada;

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
	 * Gets the partidos dto.
	 * 
	 * @return the partidos dto
	 */
	public List<PartidoDTO> getPartidosDTO() {
		return partidosDTO;
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
	 * Gets the publicada.
	 * 
	 * @return the publicada
	 */
	public String getPublicada() {
		return publicada;
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
	 * Sets the partidos dto.
	 * 
	 * @param partidosDTO
	 *            the new partidos dto
	 */
	public void setPartidosDTO(List<PartidoDTO> partidosDTO) {
		this.partidosDTO = partidosDTO;
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

	/**
	 * Sets the publicada.
	 * 
	 * @param publicada
	 *            the new publicada
	 */
	public void setPublicada(String publicada) {
		this.publicada = publicada;
	}
}
