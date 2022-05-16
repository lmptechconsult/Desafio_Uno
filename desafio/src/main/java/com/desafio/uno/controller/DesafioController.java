package com.desafio.uno.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.uno.model.PeriodoFaltante;
import com.desafio.uno.service.PerodioFaltanteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DesafioController {
	
	private final PerodioFaltanteService perodioFaltanteService;
	
	@Value("${uri.faltantes}")
	private String uri;
	
	@GetMapping("/faltantes")
	public ResponseEntity<PeriodoFaltante> faltantes() {
		try {
			/* llamada servicio de entrada/salida*/
			return perodioFaltanteService.getFechasFaltantes(uri);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
