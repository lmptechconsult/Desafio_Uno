package com.jsnaranjov.service;

import java.time.Duration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jsnaranjov.repo.IService;


/**
 * @author Jaime Sebastián Naranjo V
 * @version 1.0.0
 */
@Service
public class ServiceController implements IService {
	

	public String llamadaApi() {
		String base = "http://127.0.0.1:8080/periodos/api";
		WebClient webClient = 
				WebClient
				.builder()
				.baseUrl(base)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.build();
		String response = 
				webClient.get()
				.retrieve()
				.bodyToMono(String.class)
				.block(Duration.ofSeconds(3));
		return response;
	}
}