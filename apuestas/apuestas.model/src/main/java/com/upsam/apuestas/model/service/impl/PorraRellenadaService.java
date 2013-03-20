package com.upsam.apuestas.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.repository.IPorraRellenadaRepository;
import com.upsam.apuestas.model.service.IPorraRellenadaService;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRellenadaService.
 */
@Service
class PorraRellenadaService implements IPorraRellenadaService {

	/** The porra rellenada repository. */
	@Inject
	private IPorraRellenadaRepository porraRellenadaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#save(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public Integer save(PorraRellenada porraRellenada) throws AppException {
		try {
			return porraRellenadaRepository.save(porraRellenada);
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
	public void update(PorraRellenada porraRellenada) throws AppException {
		try {
			porraRellenadaRepository.update(porraRellenada);
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
	public void delete(PorraRellenada porraRellenada) throws AppException {
		try {
			porraRellenadaRepository.delete(porraRellenada);
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
	public PorraRellenada findOne(Integer pId) throws AppException {
		try {
			return porraRellenadaRepository.findOne(pId);
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
	public List<PorraRellenada> findAll() throws AppException {
		try {
			return porraRellenadaRepository.findAll();
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

}
