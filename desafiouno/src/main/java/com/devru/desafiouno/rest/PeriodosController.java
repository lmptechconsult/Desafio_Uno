package com.devru.desafiouno.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.devru.desafiouno.dto.Periodo;
import com.devru.desafiouno.service.DateService;
import com.devru.desafiouno.webservices.ResponseHandler;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
* Controller PeriodosController expone los rest para las acciones sobre los Periodos
*
* @author Devru
* @version 5-12-21
*/
@RestController
@RequestMapping("/periodos")
public class PeriodosController {

	private static final Logger log = LogManager.getLogger(PeriodosController.class);
	
	/* Para consultar servicios de la logica del negocio */
	@Autowired
	private DateService dateService;
	
	@ApiOperation(value = "Completa Periodos", notes = "Completa Periodos entre dos fechas creadas por GDD")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Periodos Calculados correctamente", response=Periodo.class),
			@ApiResponse(code = 401, message = "Unauthorizede"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 405, message = "Method Not Allowed"),
			@ApiResponse(code = 408, message = "Request Timeout"),
			@ApiResponse(code = 500, message = "Internal Error")
	})
	@RequestMapping(value = "/completar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> completarPeriodos() {
		log.info("completarPeriodos Init");
		Periodo periodos = null;
		
		try {
			periodos = dateService.calcularPeriodos();
		} catch (RestClientException rce) {
			return new ResponseEntity<>(ResponseHandler.generateResponse(rce.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ""), HttpStatus.INTERNAL_SERVER_ERROR);				
		} 		
		
		if(periodos != null) {
			log.info("periodos: {}", periodos);
			return ResponseEntity.ok(periodos);
		}
		log.info("completarPeriodos Finish");
		return new ResponseEntity<>(ResponseHandler.generateResponse("No se logro completar las fechas", HttpStatus.INTERNAL_SERVER_ERROR, ""), HttpStatus.INTERNAL_SERVER_ERROR);
	}
			
}
