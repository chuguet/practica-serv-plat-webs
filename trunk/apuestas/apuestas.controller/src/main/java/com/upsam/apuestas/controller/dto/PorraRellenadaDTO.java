package com.upsam.apuestas.controller.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRellenadaDTO.
 */
public class PorraRellenadaDTO extends AbstractDTO {

	/** The fecha relleno. */
	private String fechaRelleno;

	/** The partidos rellenados dto. */
	private List<PartidoRellenadoDTO> partidosRellenadosDTO;

	/** The porra dto. */
	private PorraDTO porraDTO;

	/** The usuario dto. */
	private UsuarioDTO usuarioDTO;

	/**
	 * Gets the fecha relleno.
	 * 
	 * @return the fecha relleno
	 */
	public String getFechaRelleno() {
		return fechaRelleno;
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
	 * Gets the partidos rellenados dto.
	 * 
	 * @return the partidos rellenados dto
	 */
	public List<PartidoRellenadoDTO> getPartidosRellenadosDTO() {
		return partidosRellenadosDTO;
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

	/**
	 * Gets the porra dto.
	 * 
	 * @return the porra dto
	 */
	public PorraDTO getPorraDTO() {
		return porraDTO;
	}

	/**
	 * Sets the porra dto.
	 * 
	 * @param porraDTO
	 *            the new porra dto
	 */
	public void setPorraDTO(PorraDTO porraDTO) {
		this.porraDTO = porraDTO;
	}

	/**
	 * Gets the usuario dto.
	 * 
	 * @return the usuario dto
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * Sets the usuario dto.
	 * 
	 * @param usuarioDTO
	 *            the new usuario dto
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
}
