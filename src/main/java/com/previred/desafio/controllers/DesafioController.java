package com.previred.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.previred.desafio.models.Periodo;
import com.previred.desafio.services.DesafioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@CrossOrigin(origins = "http://localhost:3000")
@ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Periodo, lista de fechas generadas y lista de fechas faltantes", response = Periodo.class),
        @ApiResponse(code = 401, message = "No Autorizado"),
        @ApiResponse(code = 403, message = "Prohibido"),
        @ApiResponse(code = 404, message = "Recurso NO encontrado")})
@RequestMapping(value = "/desafio")
@RestController
public class DesafioController {
 
@Autowired
private DesafioService desafioService;

	@GetMapping("/periodos")
	@ApiOperation(value = "Listado de fechas generadas", notes = "Obtiene el listado completo de las fechas generadas y faltantes.")
	 public Periodo home() {
		return desafioService.getAllDate();
	 }

}