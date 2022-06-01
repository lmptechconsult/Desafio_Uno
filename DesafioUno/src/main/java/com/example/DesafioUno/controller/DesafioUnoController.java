package com.example.DesafioUno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesafioUno.model.DesafioUnoResponse;
import com.example.DesafioUno.service.DesafioUnoService;

@RestController
@RequestMapping("/")
public class DesafioUnoController {

	@Autowired
	private DesafioUnoService desafioUnoService;
	
	@GetMapping(value = "/fechas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DesafioUnoResponse> obtenerFechas() {
		return ResponseEntity.ok(this.desafioUnoService.obtenerFechas());
	}
}
