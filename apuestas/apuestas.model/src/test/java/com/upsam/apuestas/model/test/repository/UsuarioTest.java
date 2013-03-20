package com.upsam.apuestas.model.test.repository;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.repository.IUsuarioRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioTest.
 */
public class UsuarioTest extends AbstractTest<Usuario, IUsuarioRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(UsuarioTest.class);

	/** The usuario repository. */
	@Inject
	private IUsuarioRepository usuarioRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.repository.AbstractTest#getObject()
	 */
	@Override
	public Usuario getObject() {
		Usuario usuario = new Usuario();
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.test.repository.AbstractTest#getRepository()
	 */
	@Override
	public IUsuarioRepository getRepository() {
		return usuarioRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.test.repository.AbstractTest#getLog()
	 */
	@Override
	public Log getLog() {
		return LOG;
	}
}
