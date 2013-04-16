package com.upsam.porras.beans;

// TODO: Auto-generated Javadoc
/**
 * The Class Mail.
 */
public class Mail {

	/** The to. */
	private String to;

	/** The text. */
	private String text;

	/**
	 * Instantiates a new mail.
	 * 
	 * @param to
	 *            the to
	 * @param subject
	 *            the subject
	 * @param text
	 *            the text
	 */
	public Mail(String to, String text) {
		this.to = to;
		this.text = text;
	}

	/**
	 * Instantiates a new mail.
	 */
	public Mail() {
	}

	/**
	 * Gets the to.
	 * 
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the to.
	 * 
	 * @param to
	 *            the new to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
