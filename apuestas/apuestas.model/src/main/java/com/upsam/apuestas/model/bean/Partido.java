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
 * The Class Partido.
 */
@Entity
@Table(name = "PARTIDO")
public class Partido implements IModelTable {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARTIDO")
	private Integer id;

	/** The local. */
	@Basic
	@Column(name = "LOCAL")
	private String local;

	/** The ordinal. */
	@Basic
	@Column(name = "ORDINAL")
	private Integer ordinal;

	/** The resultado. */
	@Basic
	@Column(name = "RESULTADO")
	private Resultado resultado;

	/** The visitante. */
	@Basic
	@Column(name = "VISITANTE")
	private String visitante;

	/** The porra. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PORRA")
	private Porra porra;

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
	public Porra getPorra() {
		return porra;
	}

	/**
	 * Sets the porra.
	 * 
	 * @param porra
	 *            the new porra
	 */
	public void setPorra(Porra porra) {
		this.porra = porra;
	}

}
