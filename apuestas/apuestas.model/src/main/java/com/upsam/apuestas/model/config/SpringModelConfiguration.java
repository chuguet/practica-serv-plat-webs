package com.upsam.apuestas.model.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringModelConfiguration.
 */
@Configuration
@ComponentScan({ "com.upsam.apuestas.model" })
@PropertySource({ "classpath:/application.properties" })
public class SpringModelConfiguration {

	// Bean para importar el properties
	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// HIBERNATE CONFIGURATION
	/** The dialect. */
	@Value("${hibernate.dialect}")
	private String dialect;

	// JDBC CONFIGURATION DATASOURCE
	/** The driver class name. */
	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	/** The hbm2 ddl. */
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2DDL;
	// MAPPING BEANS
	/** The package beans. */
	@Value("${hibernate.mapping.packages}")
	private String packageBeans;

	/** The password. */
	@Value("${jdbc.password}")
	private String password;

	/** The show sql. */
	@Value("${hibernate.show_sql}")
	private String showSql;

	/** The url. */
	@Value("${jdbc.url}")
	private String url;
	/** The username. */
	@Value("${jdbc.username}")
	private String username;

	/**
	 * Gets the data source.
	 * 
	 * @return the data source
	 */
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource result = new DriverManagerDataSource();
		result.setDriverClassName(driverClassName);
		result.setUrl(url);
		result.setUsername(username);
		result.setPassword(password);
		return result;
	}

	/**
	 * Gets the hibernate properties.
	 * 
	 * @return the hibernate properties
	 */
	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.hbm2ddl.auto", hbm2DDL);
		return properties;
	}

	/**
	 * Gets the hibernate template.
	 * 
	 * @return the hibernate template
	 */
	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(
				getSessionFactory().getObject());
		return hibernateTemplate;
	}

	/**
	 * Gets the session factory.
	 * 
	 * @return the session factory
	 */
	@Bean
	public AnnotationSessionFactoryBean getSessionFactory() {
		AnnotationSessionFactoryBean factoryBean = new AnnotationSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setPackagesToScan(new String[] { packageBeans });
		factoryBean.setHibernateProperties(getHibernateProperties());
		return factoryBean;
	}

	/**
	 * Transaction manager.
	 * 
	 * @return the hibernate transaction manager
	 */
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
