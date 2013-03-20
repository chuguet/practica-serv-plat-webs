package com.upsam.apuestas.model.bean;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoRellenado.
 */
@Entity
@Table(name = "PARTIDO_RELLENADO")
public class PartidoRellenado implements IModelTable {

	/** The ordinal. */
	@Basic
	@Column(name = "ORDINAL")
	private Integer ordinal;

	/** The resultado. */
	@Basic
	@Column(name = "RESULTADO")
	private Resultado resultado;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARTIDO_RELLENADO")
	private Integer id;

	/** The porra rellenada. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PORRA_RELLENADA")
	private PorraRellenada porraRellenada;

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
	public Resultado getResultado() {
		return resultado;
	}

	/**
	 * Sets the resultado.
	 * 
	 * @param resultado
	 *            the new resultado
	 */
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the porra rellenada.
	 * 
	 * @return the porra rellenada
	 */
	public PorraRellenada getPorraRellenada() {
		return porraRellenada;
	}

	/**
	 * Sets the porra rellenada.
	 * 
	 * @param porraRellenada
	 *            the new porra rellenada
	 */
	public void setPorraRellenada(PorraRellenada porraRellenada) {
		this.porraRellenada = porraRellenada;
	}
}
