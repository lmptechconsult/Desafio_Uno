package com.desafiouno.previred.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiouno.previred.model.Periodos;
import com.desafiouno.previred.service.FechasService;

@RestController
public class HomeController {

	@Autowired
	FechasService fechasService;

    @GetMapping("/fechas-faltantes")
    public ResponseEntity<Periodos> fechas_faltantes (){
        Periodos fechasFaltantes = fechasService.getDatesMissing();
        return new ResponseEntity<>(fechasFaltantes, HttpStatus.ACCEPTED);
    }
}

