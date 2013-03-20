package com.upsam.apuestas.model.test.repository;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.repository.IPartidoRellenadoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoRellenadoTest.
 */
public class PartidoRellenadoTest extends
		AbstractTest<PartidoRellenado, IPartidoRellenadoRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(PartidoRellenadoTest.class);

	/** The partido rellenado repository. */
	@Inject
	private IPartidoRellenadoRepository partidoRellenadoRepository;

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
	public PartidoRellenado getObject() {
		PartidoRellenado partidoRellenado = new PartidoRellenado();
		return partidoRellenado;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.test.repository.AbstractTest#getRepository()
	 */
	@Override
	public IPartidoRellenadoRepository getRepository() {
		return partidoRellenadoRepository;
	}

}
