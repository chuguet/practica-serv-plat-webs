package com.upsam.apuestas.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Resultado.
 */
public enum Resultado {

	/** The uno. */
	UNO("1"),
	/** The x. */
	X("X"),
	/** The dos. */
	DOS("2");

	/** The name id. */
	private String nameId;

	/**
	 * Instantiates a new resultado.
	 * 
	 * @param pNameId
	 *            the name id
	 */
	private Resultado(String pNameId) {
		this.nameId = pNameId;
	}

	/**
	 * Gets the name id.
	 * 
	 * @return the name id
	 */
	public String getNameId() {
		return nameId;
	}

}
