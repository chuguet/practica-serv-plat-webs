package com.upsam.apuestas.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.upsam.apuestas.model.bean.IModelTable;

// TODO: Auto-generated Javadoc
/**
 * The Interface IRepositoryDAO.
 * 
 * @param <T>
 *            the generic type
 */
public interface IRepositoryDAO<T extends IModelTable> {

	/**
	 * Save.
	 * 
	 * @param t
	 *            the t
	 */
	Integer save(T t) throws SQLException;

	/**
	 * Update.
	 * 
	 * @param t
	 *            the t
	 */
	void update(T t) throws SQLException;

	/**
	 * Delete.
	 * 
	 * @param t
	 *            the t
	 */
	void delete(T t) throws SQLException;

	/**
	 * Find one.
	 * 
	 * @param pId
	 *            the id
	 * @return the t
	 */
	T findOne(Integer pId) throws SQLException;

	/**
	 * Find all.
	 * 
	 * @return the list
	 */
	List<T> findAll() throws SQLException;
}
