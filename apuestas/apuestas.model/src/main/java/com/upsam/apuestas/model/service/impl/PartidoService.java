package com.upsam.apuestas.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.repository.IPartidoRepository;
import com.upsam.apuestas.model.service.IPartidoService;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoService.
 */
@Service
class PartidoService implements IPartidoService {

	/** The partido repository. */
	@Inject
	private IPartidoRepository partidoRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#save(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public Integer save(Partido partido) throws AppException {
		try {
			return partidoRepository.save(partido);
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
	 * com.upsam.apuestas.model.service.IModelService#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void update(Partido partido) throws AppException {
		try {
			partidoRepository.update(partido);
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
	 * com.upsam.apuestas.model.service.IModelService#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void delete(Partido partido) throws AppException {
		try {
			partidoRepository.delete(partido);
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
	@Override
	public Partido findOne(Integer pId) throws AppException {
		try {
			return partidoRepository.findOne(pId);
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.service.IModelService#findAll()
	 */
	@Override
	public List<Partido> findAll() throws AppException {
		try {
			return partidoRepository.findAll();
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

}
