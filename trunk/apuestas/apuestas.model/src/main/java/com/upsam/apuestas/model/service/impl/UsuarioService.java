package com.upsam.apuestas.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.repository.IPartidoRellenadoRepository;
import com.upsam.apuestas.model.repository.IPorraRellenadaRepository;
import com.upsam.apuestas.model.repository.IUsuarioRepository;
import com.upsam.apuestas.model.service.IUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioService.
 */
@Service
class UsuarioService implements IUsuarioService {

	/** The usuario repository. */
	@Inject
	private IUsuarioRepository usuarioRepository;

	/** The partido rellenado repository. */
	@Inject
	private IPartidoRellenadoRepository partidoRellenadoRepository;

	/** The porra rellenada repository. */
	@Inject
	private IPorraRellenadaRepository porraRellenadaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	public void delete(Usuario usuario) throws AppException {
		try {
			Usuario usuarioABorrar = usuarioRepository.findOne(usuario.getId());
			if (usuarioABorrar.getPorraRellenada() != null) {
				for (PorraRellenada porraRellenada : usuarioABorrar
						.getPorraRellenada()) {
					if (porraRellenada.getPartidosRellenados() != null) {
						for (PartidoRellenado partidoRellenado : porraRellenada
								.getPartidosRellenados()) {
							partidoRellenadoRepository.delete(partidoRellenado);
						}
					}
					porraRellenadaRepository.delete(porraRellenada);
				}
			}
			usuarioRepository.delete(usuarioABorrar);
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

	/**
	 * Encript user.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	private Usuario encriptUser(Usuario usuario) {
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String pwd = passwordEncoder
				.encodePassword(usuario.getPassword(), null);
		usuario.setPassword(pwd);
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.service.IModelService#findAll()
	 */
	public List<Usuario> findAll() throws AppException {
		try {
			return usuarioRepository.findAll();
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#findOne(java.lang.Integer)
	 */
	public Usuario findOne(Integer pId) throws AppException {
		try {
			return usuarioRepository.findOne(pId);
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#save(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	public Integer save(Usuario usuario) throws AppException {
		try {
			return usuarioRepository.save(encriptUser(usuario));
		} catch (SQLException e1) {
			throw new AppException(e1);
		} catch (DataIntegrityViolationException e2) {
			throw new AppException(e2);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IUsuarioService#selectByUser(java.lang
	 * .String)
	 */
	public Usuario selectByUser(String user) throws AppException {
		try {
			return usuarioRepository.selectByUser(user);
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	public void update(Usuario usuario) throws AppException {
		try {
			usuarioRepository.update(encriptUser(usuario));
		} catch (SQLException e1) {
			throw new AppException(e1);
		} catch (DataIntegrityViolationException e2) {
			throw new AppException(e2);
		}
	}

}
