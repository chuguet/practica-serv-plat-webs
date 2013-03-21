package com.upsam.apuestas.model.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class Porra.
 */
@Entity
@Table(name = "PORRA")
public class Porra implements IModelTable {

	/** The fecha limite. */
	@Basic
	@Column(name = "FECHA_LIMITE")
	private Date fechaLimite;

	/** The competicion. */
	@Basic
	@Column(name = "COMPETICION")
	private String competicion;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PORRA")
	private Integer id;

	/** The partidos. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "porra")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Partido> partidos;

	/** The porra rellenada. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "porra")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PorraRellenada> porraRellenada;

	/**
	 * Gets the fecha limite.
	 * 
	 * @return the fecha limite
	 */
	public Date getFechaLimite() {
		return fechaLimite;
	}

	/**
	 * Sets the fecha limite.
	 * 
	 * @param fechaLimite
	 *            the new fecha limite
	 */
	public void setFechaLimite(Date fechaLimite) {
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
	 * Gets the partidos.
	 * 
	 * @return the partidos
	 */
	public List<Partido> getPartidos() {
		return partidos;
	}

	/**
	 * Sets the partidos.
	 * 
	 * @param partidos
	 *            the new partidos
	 */
	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	/**
	 * Gets the porra rellenada.
	 * 
	 * @return the porra rellenada
	 */
	public List<PorraRellenada> getPorraRellenada() {
		return porraRellenada;
	}

	/**
	 * Sets the porra rellenada.
	 * 
	 * @param porraRellenada
	 *            the new porra rellenada
	 */
	public void setPorraRellenada(List<PorraRellenada> porraRellenada) {
		this.porraRellenada = porraRellenada;
	}

}
