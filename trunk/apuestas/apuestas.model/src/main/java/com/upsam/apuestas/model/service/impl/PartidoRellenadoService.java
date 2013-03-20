package com.upsam.apuestas.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.repository.IPartidoRellenadoRepository;
import com.upsam.apuestas.model.service.IPartidoRellenadoService;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoRellenadoService.
 */
@Service
class PartidoRellenadoService implements IPartidoRellenadoService {

	/** The partido rellenado repository. */
	@Inject
	private IPartidoRellenadoRepository partidoRellenadoRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#save(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public Integer save(PartidoRellenado partidoRellenado) throws AppException {
		try {
			return partidoRellenadoRepository.save(partidoRellenado);
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
	public void update(PartidoRellenado partidoRellenado) throws AppException {
		try {
			partidoRellenadoRepository.update(partidoRellenado);
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
	public void delete(PartidoRellenado partidoRellenado) throws AppException {
		try {
			partidoRellenadoRepository.delete(partidoRellenado);
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
	public PartidoRellenado findOne(Integer pId) throws AppException {
		try {
			return partidoRellenadoRepository.findOne(pId);
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
	public List<PartidoRellenado> findAll() throws AppException {
		try {
			return partidoRellenadoRepository.findAll();
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

}
