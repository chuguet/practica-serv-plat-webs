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

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARTIDO_RELLENADO")
	private Integer id;

	/** The local. */
	@Basic
	@Column(name = "LOCAL")
	private String local;

	/** The ordinal. */
	@Basic
	@Column(name = "ORDINAL")
	private Integer ordinal;

	/** The porra rellenada. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PORRA_RELLENADA")
	private PorraRellenada porraRellenada;

	/** The resultado. */
	@Basic
	@Column(name = "RESULTADO")
	private Resultado resultado;

	/** The visitante. */
	@Basic
	@Column(name = "VISITANTE")
	private String visitante;
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * Gets the ordinal.
	 * 
	 * @return the ordinal
	 */
	public Integer getOrdinal() {
		return ordinal;
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
	 * Gets the resultado.
	 * 
	 * @return the resultado
	 */
	public Resultado getResultado() {
		return resultado;
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
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the local.
	 *
	 * @param local the new local
	 */
	public void setLocal(String local) {
		this.local = local;
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
	 * Sets the porra rellenada.
	 * 
	 * @param porraRellenada
	 *            the new porra rellenada
	 */
	public void setPorraRellenada(PorraRellenada porraRellenada) {
		this.porraRellenada = porraRellenada;
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
	 * Sets the visitante.
	 *
	 * @param visitante the new visitante
	 */
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
}
