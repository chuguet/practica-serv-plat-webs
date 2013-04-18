package com.upsam.apuestas.controller.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.upsam.apuestas.batch.config.SpringBatchConfiguration;
import com.upsam.apuestas.model.config.SpringModelConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringControllerConfiguration.
 */
@Configuration
@ComponentScan("com.upsam.apuestas.controller")
@Import({ SpringModelConfiguration.class, SpringBatchConfiguration.class })
public class SpringControllerConfiguration {

	/**
	 * Mapping jackson json view.
	 * 
	 * @return the mapping jackson json view
	 */
	@Bean
	public MappingJacksonJsonView mappingJacksonJsonView() {
		return new MappingJacksonJsonView();
	}

	/**
	 * Bean que especifica los tipos de petición entre la vista y el
	 * controlador.
	 * 
	 * @return the content negotiating view resolver
	 */
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		final ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		contentNegotiatingViewResolver
				.setDefaultContentType(MediaType.APPLICATION_JSON);
		final ArrayList<View> defaultViews = new ArrayList<View>();
		defaultViews.add(mappingJacksonJsonView());
		contentNegotiatingViewResolver.setDefaultViews(defaultViews);
		return contentNegotiatingViewResolver;
	}
}
