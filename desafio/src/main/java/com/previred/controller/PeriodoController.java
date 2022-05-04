package com.previred.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.previred.model.PeriodoModel;
import com.previred.service.PeriodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/periodos")
@Api(value = "/periodos", tags = "Periodos", description="Lista de métodos asociados a periodos")
public class PeriodoController {
	
	@Autowired
	PeriodoService periodoService;
	
	
	@GetMapping("/faltantes")
	@ApiOperation(value = "Realiza búsqueda de periodos faltantes",notes = "Realiza búsqueda de periodos faltantes utilizando API Generador Datos Desafio.")
	public ResponseEntity<PeriodoModel> buscarPeriodoFaltantes() throws Exception {
					
		return ResponseEntity.ok(periodoService.buscarPeriodoFaltantes());		
		
	}

}
