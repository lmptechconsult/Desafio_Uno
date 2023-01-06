package com.adolfopena.gdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adolfopena.gdd.services.GddService;
import com.adolfopena.gdd.vo.PeriodDTO;

@RestController
public class GddController {
	
	@Autowired
	private GddService service;
	
	@GetMapping("/gdd")
	public ResponseEntity<PeriodDTO> getGdd(){

		PeriodDTO response = service.getMissingDates();

		return new ResponseEntity<PeriodDTO>(response, HttpStatus.OK);
	}

}
