package com.test.periodos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.periodos.model.CPeriodos;
import com.test.periodos.service.FechasService;

@RestController
public class HomeController {

    @Autowired
    FechasService fechasService;

    @GetMapping("/busca-fechas")
    public ResponseEntity<CPeriodos> fechas_faltantes (){
        CPeriodos fechasFaltantes = fechasService.getDatesMissing();
        return new ResponseEntity<>(fechasFaltantes, HttpStatus.ACCEPTED);
    }
}

