package com.upsam.apuestas.batch.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class DataProperties.
 */
@Component
public class DataProperties {

	/** The url. */
	@Value("${url}")
	private String url;

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
