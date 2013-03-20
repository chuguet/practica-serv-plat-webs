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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class Producto.
 */
@Entity
@Table(name = "PORRA_RELLENADA")
public class PorraRellenada implements IModelTable {

	/** The fecha relleno. */
	@Basic
	@Column(name = "FECHA_RELLENO")
	private Date fechaRelleno;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PORRA_RELLENADA")
	private Integer id;

	/** The partidos rellenados. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "porraRellenada")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PartidoRellenado> partidosRellenados;

	/** The usuario. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PORRA")
	private Porra porra;

	/** The usuario. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	/**
	 * Gets the fecha relleno.
	 * 
	 * @return the fecha relleno
	 */
	public Date getFechaRelleno() {
		return fechaRelleno;
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
	 * Gets the partidos rellenados.
	 * 
	 * @return the partidos rellenados
	 */
	public List<PartidoRellenado> getPartidosRellenados() {
		return partidosRellenados;
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
	 * Gets the usuario.
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the fecha relleno.
	 * 
	 * @param fechaRelleno
	 *            the new fecha relleno
	 */
	public void setFechaRelleno(Date fechaRelleno) {
		this.fechaRelleno = fechaRelleno;
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
	 * Sets the partidos rellenados.
	 * 
	 * @param partidosRellenados
	 *            the new partidos rellenados
	 */
	public void setPartidosRellenados(List<PartidoRellenado> partidosRellenados) {
		this.partidosRellenados = partidosRellenados;
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

	/**
	 * Sets the usuario.
	 * 
	 * @param usuario
	 *            the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
