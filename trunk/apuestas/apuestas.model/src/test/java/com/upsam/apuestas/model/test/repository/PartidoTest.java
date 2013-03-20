package com.upsam.apuestas.model.test.repository;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.repository.IPartidoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoTest.
 */
public class PartidoTest extends AbstractTest<Partido, IPartidoRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PartidoTest.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.repository.AbstractTest#getLog()
	 */
	@Override
	public Log getLog() {
		return LOG;
	}

	/** The partido repository. */
	@Inject
	private IPartidoRepository partidoRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.repository.AbstractTest#getObject()
	 */
	@Override
	public Partido getObject() {
		Partido partido = new Partido();
		return partido;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.test.repository.AbstractTest#getRepository()
	 */
	@Override
	public IPartidoRepository getRepository() {
		return partidoRepository;
	}

}
