package com.upsam.apuestas.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoDTO.
 */
public class PartidoDTO extends AbstractDTO {

	/** The local. */
	private String local;

	/** The ordinal. */
	private Integer ordinal;

	/** The resultado. */
	private String resultado;

	/** The visitante. */
	private String visitante;

	/** The porra. */
	private PorraDTO porraDTO;

	/**
	 * Gets the local.
	 * 
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Sets the local.
	 * 
	 * @param local
	 *            the new local
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * Gets the ordinal.
	 * 
	 * @return the ordinal
	 */
	public Integer getOrdinal() {
		return ordinal;
	}

	/**
	 * Sets the ordinal.
	 * 
	 * @param ordinal
	 *            the new ordinal
	 */
	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	/**
	 * Gets the resultado.
	 * 
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * Sets the resultado.
	 * 
	 * @param resultado
	 *            the new resultado
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Gets the visitante.
	 * 
	 * @return the visitante
	 */
	public String getVisitante() {
		return visitante;
	}

	/**
	 * Sets the visitante.
	 * 
	 * @param visitante
	 *            the new visitante
	 */
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	/**
	 * Gets the porra.
	 * 
	 * @return the porra
	 */
	public PorraDTO getPorra() {
		return porraDTO;
	}

	/**
	 * Sets the porra.
	 * 
	 * @param porra
	 *            the new porra
	 */
	public void setPorra(PorraDTO porra) {
		this.porraDTO = porra;
	}
}
