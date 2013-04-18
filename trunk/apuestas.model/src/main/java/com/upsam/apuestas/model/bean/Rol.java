package com.upsam.apuestas.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Rol.
 */
public enum Rol {

	/** The role admin. */
	ROLE_ADMIN("Administrador", "ROLE_ADMIN"),
	/** The role user. */
	ROLE_USER("Usuario", "ROLE_USER");

	/** The role. */
	private String role;

	/** The name id. */
	private String nameId;

	/**
	 * Instantiates a new rol.
	 * 
	 * @param pNameId
	 *            the name id
	 * @param pRole
	 *            the role
	 */
	private Rol(String pNameId, String pRole) {
		this.nameId = pNameId;
		this.role = pRole;
	}

	/**
	 * Gets the name id.
	 * 
	 * @return the name id
	 */
	public String getNameId() {
		return nameId;
	}

	/**
	 * Gets the role name.
	 * 
	 * @return the role name
	 */
	public String getRoleName() {
		return role;
	}
}
