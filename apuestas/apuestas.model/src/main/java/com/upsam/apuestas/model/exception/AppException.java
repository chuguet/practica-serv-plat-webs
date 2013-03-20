package com.upsam.apuestas.model.exception;

/**
 * The Class AppException.
 */
public class AppException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new app exception.
	 */
	public AppException() {
		super();
	}

	public AppException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new app exception.
	 * 
	 * @param message
	 *            the message
	 */
	public AppException(String message) {
		super(message);
	}
}