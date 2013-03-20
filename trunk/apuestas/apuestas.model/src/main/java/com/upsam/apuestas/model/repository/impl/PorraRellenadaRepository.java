package com.upsam.apuestas.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.repository.IPorraRellenadaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRellenadaRepository.
 */
@Repository
class PorraRellenadaRepository implements IPorraRellenadaRepository {

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
	public Integer save(PorraRellenada porraRellenada) throws SQLException {
		return (Integer) hibernateTemplate.save(porraRellenada);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void update(PorraRellenada porraRellenada) throws SQLException {
		hibernateTemplate.update(porraRellenada);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void delete(PorraRellenada porraRellenada) throws SQLException {
		hibernateTemplate.delete(porraRellenada);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public PorraRellenada findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(PorraRellenada.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<PorraRellenada> findAll() throws SQLException {
		return hibernateTemplate.loadAll(PorraRellenada.class);
	}

}
