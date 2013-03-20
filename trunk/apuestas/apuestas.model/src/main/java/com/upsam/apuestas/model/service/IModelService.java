package com.upsam.apuestas.model.service;

import java.util.List;

import com.upsam.apuestas.model.bean.IModelTable;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IModelService.
 * 
 * @param <T>
 *            the generic type
 */
public interface IModelService<T extends IModelTable> {

	/**
	 * Save.
	 * 
	 * @param t
	 *            the t
	 */
	Integer save(T t) throws AppException;

	/**
	 * Update.
	 * 
	 * @param t
	 *            the t
	 */
	void update(T t) throws AppException;

	/**
	 * Delete.
	 * 
	 * @param t
	 *            the t
	 */
	void delete(T t) throws AppException;

	/**
	 * Find one.
	 * 
	 * @param pId
	 *            the id
	 * @return the t
	 */
	T findOne(Integer pId) throws AppException;

	/**
	 * Find all.
	 * 
	 * @return the list
	 */
	List<T> findAll() throws AppException;
}
