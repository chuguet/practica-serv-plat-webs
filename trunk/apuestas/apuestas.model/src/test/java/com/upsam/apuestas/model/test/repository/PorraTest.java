package com.upsam.apuestas.model.test.repository;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.repository.IPorraRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraTest.
 */
public class PorraTest extends AbstractTest<Porra, IPorraRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PorraTest.class);

	/** The porra repository. */
	@Inject
	private IPorraRepository porraRepository;

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
	public Porra getObject() {
		Porra porra = new Porra();
		return porra;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.test.repository.AbstractTest#getRepository()
	 */
	@Override
	public IPorraRepository getRepository() {
		return porraRepository;
	}

}
