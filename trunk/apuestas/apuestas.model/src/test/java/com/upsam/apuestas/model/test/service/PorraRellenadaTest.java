package com.upsam.apuestas.model.test.service;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.service.IPorraRellenadaService;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRellenadaTest.
 */
public class PorraRellenadaTest extends
		AbstractTest<PorraRellenada, IPorraRellenadaService> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PorraRellenadaTest.class);

	/** The porra rellenada service. */
	@Inject
	private IPorraRellenadaService porraRellenadaService;

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
	public PorraRellenada getObject() {
		PorraRellenada porraRellenada = new PorraRellenada();
		return porraRellenada;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getService()
	 */
	@Override
	public IPorraRellenadaService getService() {
		return porraRellenadaService;
	}

}
