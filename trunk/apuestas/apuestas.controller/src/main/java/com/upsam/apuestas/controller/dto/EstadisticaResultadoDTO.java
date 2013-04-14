package com.upsam.apuestas.controller.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaResultadoDTO.
 */
public class EstadisticaResultadoDTO {
	
	/** The porras rellenadas estadistica dto. */
	private List<PorraRellenadaEstadisticaDTO> porrasRellenadasEstadisticaDTO;
	
	/** The promedio aciertos. */
	private String promedioAciertos;
	
	/**
	 * Gets the porras rellenadas estadistica dto.
	 *
	 * @return the porras rellenadas estadistica dto
	 */
	public List<PorraRellenadaEstadisticaDTO> getPorrasRellenadasEstadisticaDTO() {
		return porrasRellenadasEstadisticaDTO;
	}
	
	/**
	 * Sets the porras rellenadas estadistica dto.
	 *
	 * @param porrasRellenadasEstadisticaDTO the new porras rellenadas estadistica dto
	 */
	public void setPorrasRellenadasEstadisticaDTO(
			List<PorraRellenadaEstadisticaDTO> porrasRellenadasEstadisticaDTO) {
		this.porrasRellenadasEstadisticaDTO = porrasRellenadasEstadisticaDTO;
	}
	
	/**
	 * Gets the promedio aciertos.
	 *
	 * @return the promedio aciertos
	 */
	public String getPromedioAciertos() {
		return promedioAciertos;
	}
	
	/**
	 * Sets the promedio aciertos.
	 *
	 * @param promedioAciertos the new promedio aciertos
	 */
	public void setPromedioAciertos(String promedioAciertos) {
		this.promedioAciertos = promedioAciertos;
	}
}
