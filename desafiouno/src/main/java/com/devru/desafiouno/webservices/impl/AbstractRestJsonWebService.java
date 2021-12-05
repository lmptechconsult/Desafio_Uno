package com.devru.desafiouno.webservices.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.devru.desafiouno.rest.PeriodosController;
import com.devru.desafiouno.webservices.WebServicesUtils;

public abstract class AbstractRestJsonWebService extends AbstractWebService {

	private static final Logger _log = LogManager.getLogger(PeriodosController.class);
	private final RestTemplate restTemplate;
	
	public AbstractRestJsonWebService(String webServiceUrl) {
		super(webServiceUrl);
		this.restTemplate = getRestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
		messageConverters.add(converter);
		messageConverters.add(new FormHttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);
	}

	/**
	 * @return the restTemplate
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(WebServicesUtils.ConnectTimeout);
		clientHttpRequestFactory.setReadTimeout(WebServicesUtils.ReadTimeout);
		_log.info("RestTemplate init");
		return new RestTemplate(clientHttpRequestFactory);
	}
	
	public HttpHeaders getHttpHeadersAccepJson() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}

}
