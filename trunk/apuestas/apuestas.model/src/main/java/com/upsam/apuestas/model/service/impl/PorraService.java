package com.upsam.apuestas.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.repository.IPartidoRellenadoRepository;
import com.upsam.apuestas.model.repository.IPartidoRepository;
import com.upsam.apuestas.model.repository.IPorraRellenadaRepository;
import com.upsam.apuestas.model.repository.IPorraRepository;
import com.upsam.apuestas.model.service.IPorraService;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraService.
 */
@Service
class PorraService implements IPorraService {

	/** The porra repository. */
	@Inject
	private IPorraRepository porraRepository;

	/** The partido repository. */
	@Inject
	private IPartidoRepository partidoRepository;

	/** The porra rellenada repository. */
	@Inject
	private IPorraRellenadaRepository porraRellenadaRepository;

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
	public Integer save(Porra porra) throws AppException {
		try {
			return porraRepository.save(porra);
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
	public void update(Porra porra) throws AppException {
		try {
			porraRepository.update(porra);
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
	public void delete(Porra porra) throws AppException {
		try {
			Porra porraABorrar = porraRepository.findOne(porra.getId());
			if (porraABorrar.getPartidos() != null) {
				for (Partido partido : porraABorrar.getPartidos()) {
					partidoRepository.delete(partido);
				}
			}
			if (porraABorrar.getPorraRellenada() != null) {
				for (PorraRellenada porraRellenada : porraABorrar
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
			porraRepository.delete(porraABorrar);
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
	public Porra findOne(Integer pId) throws AppException {
		try {
			return porraRepository.findOne(pId);
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
	public List<Porra> findAll() throws AppException {
		try {
			return porraRepository.findAll();
		} catch (SQLException e) {
			throw new AppException(e);
		}
	}

}
