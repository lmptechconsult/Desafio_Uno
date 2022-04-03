package com.previred.app.date.service.external.impl;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.previred.app.date.dto.ExternalResponseDTO;
import com.previred.app.date.exception.InteropException;
import com.previred.app.date.service.external.IRequestDatesService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@Service
@Slf4j
public class RequestDatesServiceImpl implements IRequestDatesService {
	
	@Value("${api.rest.remote.host}")
	private String remoteHost;
	@Value("${api.rest.remote.endpoint}")
	private String remoteEndpoint; 
	
	@Override
	public ExternalResponseDTO requestDatesExternalService() throws InteropException {
		log.info("INIT :: requestDatesExternalService");
		try {
			ExternalResponseDTO response = callRemoteService();
			return response;
		} catch (Exception e) {
			log.error("Error to consume external service", e);
			throw new InteropException("Error al invocar generador de fechas: " + e.getMessage());
		}	
	}
	
	
	// ------------------------
	// PRIVATE METHODS
	// ------------------------
	
	/*
	 * (non-Javadoc)
	 * 
	 */
	private ExternalResponseDTO callRemoteService() throws InteropException, InterruptedException, ExecutionException{
		if(log.isDebugEnabled())
			log.debug("INIT ::  callRemoteService");
		WebClient webClient = WebClient.create(remoteHost);
		ExternalResponseDTO response =  webClient
        .get().uri(remoteEndpoint)
 		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
 	    .retrieve()
 	    .bodyToMono(ExternalResponseDTO.class).block();
		if(log.isDebugEnabled())
			log.debug("External response: {}" , response);
		if(response == null) {
			throw new InteropException("Response is null");
		}
		log.info("END :: callRemoteService");
		return response;
	}
	
	

}
