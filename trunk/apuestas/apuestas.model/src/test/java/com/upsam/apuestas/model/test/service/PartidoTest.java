package com.upsam.apuestas.model.test.service;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.service.IPartidoService;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoTest.
 */
public class PartidoTest extends AbstractTest<Partido, IPartidoService> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PartidoTest.class);

	/** The partido service. */
	@Inject
	private IPartidoService partidoService;

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
	public Partido getObject() {
		Partido partido = new Partido();
		return partido;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getService()
	 */
	@Override
	public IPartidoService getService() {
		return partidoService;
	}

}
