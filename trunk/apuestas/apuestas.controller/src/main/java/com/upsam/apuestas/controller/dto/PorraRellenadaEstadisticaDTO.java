package com.upsam.apuestas.controller.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRellenadaEstadisticaDTO.
 */
public class PorraRellenadaEstadisticaDTO {

	/** The competicion. */
	private String competicion;

	/** The fecha limite. */
	private String fechaLimite;

	/** The fecha relleno. */
	private String fechaRelleno;

	/** The indice aciertos. */
	private String indiceAciertos;

	/** The partidos rellenados estadistica dto. */
	private List<PartidoRellenadoEstadisticaDTO> partidosRellenadosEstadisticaDTO;

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
	 * Gets the indice aciertos.
	 * 
	 * @return the indice aciertos
	 */
	public String getIndiceAciertos() {
		return indiceAciertos;
	}

	/**
	 * Gets the partidos rellenados estadistica dto.
	 * 
	 * @return the partidos rellenados estadistica dto
	 */
	public List<PartidoRellenadoEstadisticaDTO> getPartidosRellenadosEstadisticaDTO() {
		return partidosRellenadosEstadisticaDTO;
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
	 * Sets the indice aciertos.
	 * 
	 * @param indiceAciertos
	 *            the new indice aciertos
	 */
	public void setIndiceAciertos(String indiceAciertos) {
		this.indiceAciertos = indiceAciertos;
	}

	/**
	 * Sets the partidos rellenados estadistica dto.
	 * 
	 * @param partidosRellenadosDTO
	 *            the new partidos rellenados estadistica dto
	 */
	public void setPartidosRellenadosEstadisticaDTO(
			List<PartidoRellenadoEstadisticaDTO> partidosRellenadosDTO) {
		this.partidosRellenadosEstadisticaDTO = partidosRellenadosDTO;
	}
}
