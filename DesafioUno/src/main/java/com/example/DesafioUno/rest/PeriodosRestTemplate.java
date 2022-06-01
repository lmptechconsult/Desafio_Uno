package com.example.DesafioUno.rest;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.DesafioUno.model.DesafioUnoResponse;

@Component
public class PeriodosRestTemplate {
	private static final Logger log = LoggerFactory.getLogger(PeriodosRestTemplate.class);
	private static final String GENERATOR_URL = System.getProperty("URL_GENERADOR") + "/periodos";

	public DesafioUnoResponse obtenerFechasGeneradorDesafioUno() {
		try {
			log.info("ingresando a obtenerFechasGeneradorDesafioUno()");
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> entity = new HttpEntity<Object>(headers);

			RestTemplate restTemplate = new RestTemplate();
			log.info("realizando llamado a " + GENERATOR_URL + "/api");
			ResponseEntity<DesafioUnoResponse> dataModel = restTemplate.exchange(GENERATOR_URL + "/api", HttpMethod.GET,
					entity, DesafioUnoResponse.class);
			log.info("saliendo de obtenerFechasGeneradorDesafioUno()");
			return dataModel.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("error: " + e.getMessage());
			log.info("saliendo de obtenerFechasGeneradorDesafioUno() retornando null");
			return null;
		}
	}

}
