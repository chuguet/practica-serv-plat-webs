package com.upsam.apuestas.batch.rest;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.upsam.apuestas.batch.bean.DataProperties;
import com.upsam.apuestas.batch.bean.InfoUsuarios;

// TODO: Auto-generated Javadoc
/**
 * The Class RestClient.
 */
@Component
public class RestClient implements IRestClient {

	/** The rest template. */
	@Inject
	private RestTemplate restTemplate;

	/** The data properties. */
	@Inject
	private DataProperties dataProperties;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.batch.rest.IRestClient#getInfoUsuarios()
	 */
	@Override
	public InfoUsuarios getInfoUsuarios() {
		InfoUsuarios result;
		try {
			result = restTemplate.getForObject(dataProperties.getUrl(),
					InfoUsuarios.class);
		} catch (Exception e) {
			throw new RestClientException(e.getMessage());
		}
		return result;
	}

}
