package com.upsam.apuestas.batch.rest;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.upsam.apuestas.batch.bean.InfoUsuarios;

// TODO: Auto-generated Javadoc
/**
 * The Class RestClient.
 */
@Component
public class RestClient implements IRestClient {

	/** The Constant URL. */
	private static final String URL = "http://localhost:8080/apuestas.view/mail/info";

	/** The rest template. */
	@Inject
	private RestTemplate restTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.batch.rest.IRestClient#getInfoUsuarios()
	 */
	@Override
	public InfoUsuarios getInfoUsuarios() {
		InfoUsuarios result;
		try {
			result = restTemplate.getForObject(URL, InfoUsuarios.class);
		} catch (Exception e) {
			throw new RestClientException(e.getMessage());
		}
		return result;
	}

}
