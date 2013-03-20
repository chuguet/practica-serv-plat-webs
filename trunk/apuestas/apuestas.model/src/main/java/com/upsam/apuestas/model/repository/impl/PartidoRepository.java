package com.upsam.apuestas.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.repository.IPartidoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoRepository.
 */
@Repository
class PartidoRepository implements IPartidoRepository {

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
	public Integer save(Partido partido) throws SQLException {
		return (Integer) hibernateTemplate.save(partido);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void update(Partido partido) throws SQLException {
		hibernateTemplate.update(partido);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void delete(Partido partido) throws SQLException {
		hibernateTemplate.delete(partido);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public Partido findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Partido.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Partido> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Partido.class);
	}

}
