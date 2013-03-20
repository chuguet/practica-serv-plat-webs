package com.upsam.apuestas.model.test.service;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.service.IPartidoRellenadoService;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoRellenadoTest.
 */
public class PartidoRellenadoTest extends
		AbstractTest<PartidoRellenado, IPartidoRellenadoService> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(PartidoRellenadoTest.class);

	/** The partido rellenado service. */
	@Inject
	IPartidoRellenadoService partidoRellenadoService;

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
	public PartidoRellenado getObject() {
		PartidoRellenado partidoRellenado = new PartidoRellenado();
		return partidoRellenado;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getService()
	 */
	@Override
	public IPartidoRellenadoService getService() {
		return partidoRellenadoService;
	}

}
