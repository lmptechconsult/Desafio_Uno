package com.desafio.uno.service;

import org.springframework.http.ResponseEntity;

import com.desafio.uno.model.PeriodoFaltante;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface PerodioFaltanteService {

	ResponseEntity<PeriodoFaltante> getFechasFaltantes(String uri) throws JsonMappingException, JsonProcessingException;

}
