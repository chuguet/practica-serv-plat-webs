package com.upsam.apuestas.model.test.service;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.service.IUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioTest.
 */
public class UsuarioTest extends AbstractTest<Usuario, IUsuarioService> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(UsuarioTest.class);

	/** The usuario service. */
	@Inject
	private IUsuarioService usuarioService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getObject()
	 */
	@Override
	public Usuario getObject() {
		Usuario usuario = new Usuario();
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getService()
	 */
	@Override
	public IUsuarioService getService() {
		return usuarioService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.service.AbstractTest#getLog()
	 */
	@Override
	public Log getLog() {
		return LOG;
	}

}
