package com.upsam.apuestas.model.test.repository;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.upsam.apuestas.model.bean.IModelTable;
import com.upsam.apuestas.model.config.SpringModelConfiguration;
import com.upsam.apuestas.model.repository.IRepositoryDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractTest.
 * 
 * @param <I>
 *            the generic type
 * @param <T>
 *            the generic type
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringModelConfiguration.class, loader = AnnotationConfigContextLoader.class)
public abstract class AbstractTest<I extends IModelTable, T extends IRepositoryDAO<I>> {

	/**
	 * Gets the log.
	 * 
	 * @return the log
	 */
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
	public abstract T getRepository();

	/**
	 * Creates the test.
	 */
	@Test
	public final void createTest() {
		try {
			getRepository().save(getObject());
		} catch (SQLException e) {
			getLog().error(e.getMessage());
		}
	}

	/**
	 * Delete test.
	 */
	@Test
	public final void deleteTest() {
		try {
			getRepository().save(getObject());
			getRepository().delete(getObject());
		} catch (SQLException e) {
			getLog().error(e.getMessage());
		}
	}

	/**
	 * Find one test.
	 */
	@Test
	public final void findOneTest() {
		try {
			Integer id = getRepository().save(getObject());
			assertNotNull(getRepository().findOne(id));
		} catch (SQLException e) {
			getLog().error(e.getMessage());
		}
	}

	/**
	 * Find all test.
	 */
	@Test
	public final void findAllTest() {
		try {
			getRepository().save(getObject());
			assertNotNull(getRepository().findAll());
		} catch (SQLException e) {
			getLog().error(e.getMessage());
		}
	}
}
