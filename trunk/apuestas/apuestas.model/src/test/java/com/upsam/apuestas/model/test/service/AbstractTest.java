package com.upsam.apuestas.model.test.service;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.upsam.apuestas.model.bean.IModelTable;
import com.upsam.apuestas.model.config.SpringModelConfiguration;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.service.IModelService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringModelConfiguration.class, loader = AnnotationConfigContextLoader.class)
public abstract class AbstractTest<I extends IModelTable, T extends IModelService<I>> {

	public abstract Log getLog();

	/**
	 * Gets the object.
	 * 
	 * @return the object
	 */
	public abstract I getObject();

	/**
	 * Gets the dao.
	 * 
	 * @return the dao
	 */
	public abstract T getService();

	/**
	 * Creates the test.
	 */
	@Test
	public final void createTest() {
		try {
			getService().save(getObject());
		} catch (AppException e) {
			getLog().error(e.getMessage());
		}
	}

	/**
	 * Delete test.
	 */
	@Test
	public final void deleteTest() {
		try {
			getService().save(getObject());
			getService().delete(getObject());
		} catch (AppException e) {
			getLog().error(e.getMessage());
		}
	}

	/**
	 * Find one test.
	 */
	@Test
	public final void findOneTest() {
		try {
			Integer id = getService().save(getObject());
			assertNotNull(getService().findOne(id));
		} catch (AppException e) {
			getLog().error(e.getMessage());
		}
	}

	/**
	 * Find all test.
	 */
	@Test
	public final void findAllTest() {
		try {
			getService().save(getObject());
			assertNotNull(getService().findAll());
		} catch (AppException e) {
			getLog().error(e.getMessage());
		}
	}
}
