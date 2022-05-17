package com.previred.repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.previred.configuration.Config;
import com.previred.domain.Periodo;

@Repository
public class PeriodoRepository {

	public Periodo readJson(RestTemplate restTemplate, Config config) {
		Periodo periodo = null;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Void> rq = new HttpEntity<>(headers);
		
		ResponseEntity<Periodo> rs = restTemplate.exchange(config.getApiGDD(), HttpMethod.GET, rq, Periodo.class);
		
		periodo = rs.getBody();
		
		return periodo;
	}
	
}
