package com.upsam.apuestas.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.repository.IPartidoRellenadoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoRellenadoRepository.
 */
@Repository
class PartidoRellenadoRepository implements IPartidoRellenadoRepository {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#save(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public Integer save(PartidoRellenado partidoRellenado) throws SQLException {
		return (Integer) hibernateTemplate.save(partidoRellenado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void update(PartidoRellenado partidoRellenado) throws SQLException {
		hibernateTemplate.update(partidoRellenado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void delete(PartidoRellenado partidoRellenado) throws SQLException {
		hibernateTemplate.delete(partidoRellenado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public PartidoRellenado findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(PartidoRellenado.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<PartidoRellenado> findAll() throws SQLException {
		return hibernateTemplate.loadAll(PartidoRellenado.class);
	}

}
