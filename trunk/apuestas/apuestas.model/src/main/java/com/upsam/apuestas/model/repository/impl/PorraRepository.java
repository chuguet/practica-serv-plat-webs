package com.upsam.apuestas.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.repository.IPorraRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraRepository.
 */
@Repository
class PorraRepository implements IPorraRepository {

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
	public Integer save(Porra porra) throws SQLException {
		return (Integer) hibernateTemplate.save(porra);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void update(Porra porra) throws SQLException {
		hibernateTemplate.update(porra);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void delete(Porra porra) throws SQLException {
		hibernateTemplate.delete(porra);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public Porra findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Porra.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Porra> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Porra.class);
	}

}
