package com.upsam.apuestas.model.bean;

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
 * The Class Usuario.
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements IModelTable {

	/** The admin. */
	@Basic
	@Column(name = "ROL")
	private Rol rol;

	/** The apellidos. */
	@Basic
	@Column(name = "APELLIDOS")
	private String apellidos;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Integer id;

	/** The nombre. */
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;

	/** The password. */
	@Basic
	@Column(name = "PASSWORD")
	private String password;

	/** The user. */
	@Basic
	@Column(name = "USER", unique = true)
	private String user;

	/** The porra rellenada. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PorraRellenada> porraRellenada;

	/**
	 * Gets the rol.
	 * 
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 * 
	 * @param rol
	 *            the new rol
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * Gets the apellidos.
	 * 
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 * 
	 * @param apellidos
	 *            the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(String user) {
		this.user = user;
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
