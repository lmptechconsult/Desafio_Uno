package com.lmptechconsult.desafio_Uno.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmptechconsult.desafio_Uno.client.ApiPeriodosClient;
import com.lmptechconsult.desafio_Uno.model.Periodos;
import com.lmptechconsult.desafio_Uno.model.PeriodosFaltantes;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PeriodosFaltantesServiceImp implements PeriodosFaltantesService{

    @Autowired
    private ApiPeriodosClient apiPeriodosClient;

    @Override
    public  Periodos  getPeriodos(){
        return apiPeriodosClient.getPeriodos();
     }
    
    @Override
    public PeriodosFaltantes getPeriodosFaltantes(Periodos periodos) {
        if(periodos == null){
            return null;
        }
        log.info("obteniendo periodos faltantes [Fecha creacion {} - Fecha  final {}]",periodos.getFechaCreacion(),periodos.getFechaFin());
        PeriodosFaltantes periodosFaltantes = new PeriodosFaltantes();
        periodosFaltantes.setId(periodos.getId());
        periodosFaltantes.setFechaCreacion(periodos.getFechaCreacion());
        periodosFaltantes.setFechaFin(periodos.getFechaFin());
        periodosFaltantes.setFechas(periodos.getFechas());
        periodosFaltantes.setFechasFaltantes(new ArrayList<>());

        for (LocalDate fecha = periodos.getFechaCreacion(); 
                    periodos.getFechaFin().isAfter(fecha) || periodos.getFechaFin().isEqual(fecha); 
                        fecha = fecha.plusMonths(1)) {
            if(!periodos.getFechas().contains(fecha)){
                periodosFaltantes.getFechasFaltantes().add(fecha);
            }
        }

        return periodosFaltantes;
    }

    @Override
    public PeriodosFaltantes getPeriodosFaltantes() {
         return this.getPeriodosFaltantes(this.getPeriodos());
    }
    
}
