package com.upsam.apuestas.model.test.service;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.service.IPorraService;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraTest.
 */
public class PorraTest extends AbstractTest<Porra, IPorraService> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PorraTest.class);

	/** The porra service. */
	@Inject
	private IPorraService porraService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getLog()
	 */
	@Override
	public Log getLog() {
		return LOG;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getObject()
	 */
	@Override
	public Porra getObject() {
		Porra porra = new Porra();
		return porra;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getService()
	 */
	@Override
	public IPorraService getService() {
		return porraService;
	}

}
