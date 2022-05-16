package com.previred.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.previred.desafio.service.IMissingDatesService;

@RestController
@RequestMapping(value = "/periodos", produces = "application/json")
@Async("taskExecutor")
public class ExternalApiCallerController {

	@Autowired
	private IMissingDatesService missingDatesService;

	@GetMapping(produces = "application/json")
	public ResponseEntity<String> findAll() throws Exception {

		return ResponseEntity.ok().body(missingDatesService.findAll());

	}

}
