package com.desafio.controller;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.exception.BussinesException;
import com.desafio.model.Periodo;
import com.desafio.service.DesafioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@Api(tags = "Api Desafio Fechas Faltantes")
@RestController
@RequestMapping("/api")
public class DesafioController {
	
	private static final Logger logger = LoggerFactory.getLogger(DesafioController.class);
	
	@Autowired 
	DesafioService desafioService;

	@ApiOperation(value = "Periodo y Fechas Faltantes", nickname = "periodos", notes = "", response = Periodo.class, tags={ "Api Desafio Fechas Faltantes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Periodo,lista de fechas y fechas faltantes", response = Periodo.class) })
    @GetMapping(value="/fechasFaltantes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Periodo> getApiFechasFaltantes() throws UnknownHostException, BussinesException  {
    	logger.debug("Iniciando getApiFechasFaltantes ");
    	
    	Periodo periodo = null;
    	periodo = desafioService.getFechasFaltantes();
    	
    	logger.debug("Finalizando getApiFechasFaltantes ");
		return new ResponseEntity<>(periodo, HttpStatus.OK);
        
        
        
    }
	
	
	
	
	
	


}
