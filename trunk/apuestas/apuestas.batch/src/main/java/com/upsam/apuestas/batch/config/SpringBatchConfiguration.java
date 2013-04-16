package com.upsam.apuestas.batch.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringBatchConfiguration.
 */
@Configuration
@ComponentScan("com.upsam.apuestas.batch")
@EnableScheduling
public class SpringBatchConfiguration {

	/**
	 * /** Rest template.
	 * 
	 * @return the rest template
	 */
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
		list.add(new MappingJacksonHttpMessageConverter());
		restTemplate.setMessageConverters(list);
		return restTemplate;
	}

}
