package com.previred.desafio.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.previred.desafio.configuration.ConfigProperties;
import com.previred.desafio.model.Periodo;

@Repository
public class RestRepository {
	Logger logger = LogManager.getLogger(RestRepository.class.getName());

	public Periodo getPeriods(RestTemplate restTemplate, ConfigProperties configProperties) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<Periodo> response = restTemplate.exchange(
				configProperties.getApiHost() + configProperties.getApiResource(), HttpMethod.GET, requestEntity,
				Periodo.class);
		Periodo periodo = response.getBody();

		return periodo;

	}
}
