package com.upsam.apuestas.model.test.repository;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.repository.IPorraRellenadaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRellenadaTest.
 */
public class PorraRellenadaTest extends
		AbstractTest<PorraRellenada, IPorraRellenadaRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PorraRellenada.class);

	/** The porra rellenada repository. */
	@Inject
	private IPorraRellenadaRepository porraRellenadaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.repository.AbstractTest#getLog()
	 */
	@Override
	public Log getLog() {
		return LOG;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.repository.AbstractTest#getObject()
	 */
	@Override
	public PorraRellenada getObject() {
		PorraRellenada porraRellenada = new PorraRellenada();
		return porraRellenada;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.test.repository.AbstractTest#getRepository()
	 */
	@Override
	public IPorraRellenadaRepository getRepository() {
		return porraRellenadaRepository;
	}

}
