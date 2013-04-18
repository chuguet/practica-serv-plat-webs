package com.upsam.apuestas.batch.test;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.upsam.apuestas.batch.bean.InfoUsuarios;
import com.upsam.apuestas.batch.rest.IRestClient;

public class RestClientTest extends AbstractTest {

	@Inject
	private IRestClient restClient;

	@Test
	public void restClientTest() {
		InfoUsuarios infoUsuarios = restClient.getInfoUsuarios();
		assertTrue(infoUsuarios.getUsuarios().size() > 0);
	}
}
