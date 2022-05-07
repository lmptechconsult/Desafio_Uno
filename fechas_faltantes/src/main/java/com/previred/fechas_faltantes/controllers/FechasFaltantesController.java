package com.previred.fechas_faltantes.controllers;

import com.previred.fechas_faltantes.dto.RespuestaDto;
import com.previred.fechas_faltantes.models.FechasEntrada;
import com.previred.fechas_faltantes.services.FechasFaltantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FechasFaltantesController {

    @Autowired
    FechasFaltantesService fechasFaltantesService;

    @GetMapping("/fechasfaltantes")
    public ResponseEntity<RespuestaDto> fechas_faltantes (){
        RespuestaDto fechasFaltantes = fechasFaltantesService.getFechasFaltantes();
        return new ResponseEntity<>(fechasFaltantes, HttpStatus.ACCEPTED);


    }


}
