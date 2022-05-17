package com.previred.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.previred.service.PeriodoService;

@RestController
@RequestMapping("/api")
public class GDDController {

	@Autowired
	PeriodoService periodoService;
	
	@GetMapping("/fechas_ausentes")
	public ResponseEntity<String> getFechasFaltantes() {
		return ResponseEntity.ok().body(periodoService.getFechasFaltantes());
	}
}
