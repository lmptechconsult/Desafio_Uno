package com.lmptechconsult.desafio_Uno.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.lmptechconsult.desafio_Uno.model.PeriodosFaltantes;
import com.lmptechconsult.desafio_Uno.services.PeriodosFaltantesService;

 
@RestController
public class PeriodosFaltantesControllerImpl implements PeriodosFaltantesController{

    @Autowired
    private PeriodosFaltantesService periodosFaltantesService;

    @Override
    public ResponseEntity<PeriodosFaltantes> getPeriodosFaltantes() {
        try {
            PeriodosFaltantes periodosFaltantes = periodosFaltantesService.getPeriodosFaltantes();
            if(periodosFaltantes == null){
                return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
            }
            return new ResponseEntity<>(periodosFaltantes, HttpStatus.OK); 
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
     
    }
    
}
