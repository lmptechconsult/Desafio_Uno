package com.desafio.nivelTres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafio.nivelTres.model.Period;
import com.desafio.nivelTres.services.PeriodosService;


@Controller
@RequestMapping("/rest")
public class RestController {
	
	private static final String API_FECHAS_URL = "http://127.0.0.1:8080/periodos/api";
	
	@Autowired
	@Qualifier("restService")
	private PeriodosService restService;
	
	@GetMapping("/testRequest")
	public ResponseEntity<Period> checkJson() {
		Period period = restService.getPeriod(API_FECHAS_URL);
		return new ResponseEntity<Period>(period, HttpStatus.OK);
	}
	
	@GetMapping("/missedPeriods")
	public ResponseEntity<Period> getMissedperiods() {
		Period period = restService.getMissedPeriodos(API_FECHAS_URL);
		return new ResponseEntity<Period>(period, HttpStatus.OK);
	}
}
