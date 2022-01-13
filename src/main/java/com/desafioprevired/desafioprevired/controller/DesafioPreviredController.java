package com.desafioprevired.desafioprevired.controller;

import com.desafioprevired.desafioprevired.DesafiopreviredApplication;
import com.desafioprevired.desafioprevired.model.Periodo;
import com.desafioprevired.desafioprevired.service.DesafioPreviredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DesafioPreviredController {
    private final Logger log = LoggerFactory.getLogger(DesafioPreviredController.class);
    private DesafioPreviredService service;
    private Periodo periodo;
    private HttpStatus status;

    public DesafioPreviredController(DesafioPreviredService service, Periodo periodo){
        this.service = service;
        this.periodo = periodo;
    }

    @PostMapping(path = "/fechasfaltantes", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Periodo> obtenerFechasFaltantes(@RequestBody Periodo periodoEntrante) {
        try {
            periodo = service.getFechasFaltantes(periodoEntrante);
            status = HttpStatus.OK;
        } catch(Exception e){
            log.error(e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } finally{ return new ResponseEntity<>(periodo, status); }
    }
}
