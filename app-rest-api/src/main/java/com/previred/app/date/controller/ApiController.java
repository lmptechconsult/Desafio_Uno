package com.previred.app.date.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.previred.app.date.dto.ResponseDTO;
import com.previred.app.date.exception.InteropException;
import com.previred.app.date.exception.ServicesException;
import com.previred.app.date.service.IProcessService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@RequestMapping("/api/v1")
@RestController
@Slf4j
public class ApiController {
	
	@Autowired
	private IProcessService processService;
	
	/**
	 * 
	 * @return
	 * @throws ServicesException
	 * @throws InteropException
	 */
	@Operation(summary = "Invoca al generador de fechas, posteriormente procesara las fechas faltantes")
	@GetMapping("/search/missing/dates")
	public ResponseDTO processMissingDates() throws ServicesException, InteropException {
		log.info("INIT :: processMissingDates");
		return processService.processRequestDate();
	}

}
