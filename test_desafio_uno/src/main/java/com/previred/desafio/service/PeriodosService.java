/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.previred.desafio.service;

import com.previred.desafio.model.PeriodoVO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;

/**
 *
 * @author Javier Zambrano
 */
@Service
public class PeriodosService {
    
    @Value("${previred.api.periodos.uri}")
    private String uriApiGDD;
    
    public PeriodoVO callApiPeriodosGDD(){
        PeriodoVO periodosResult = new PeriodoVO();
        try{
            RestTemplate restTemplate =new RestTemplate();
            ResponseEntity<PeriodoVO> result = restTemplate.getForEntity(uriApiGDD, PeriodoVO.class);
            if(result.getStatusCode().equals(HttpStatus.OK)){
                periodosResult = result.getBody();
                periodosResult= completaFechasPendientes(periodosResult); 
                periodosResult.setnError(new Long(0));
                periodosResult.setsError("Ok");
            }else{
                periodosResult.setnError(new Long(1));
                periodosResult.setsError("Error al comunicarse con API GDD Periodos, revise si esta Disponible");
            }
        }catch(RestClientException ex){
            periodosResult.setnError(new Long(1));
            periodosResult.setsError("Error al comunicarse con API GDD Periodos, se produjo una excepcion al comunicarse con la API: "+ex.getMessage());
        }catch(Exception ex){
            periodosResult.setnError(new Long(1));
            periodosResult.setsError("Error al generar fechas: "+ex.getMessage());
        }
            
        
        return periodosResult; 
    }
    
    private PeriodoVO completaFechasPendientes(PeriodoVO vo){

        LocalDate fechaDesde = vo.getFechaCreacion();
        LocalDate fechaProceso = vo.getFechaCreacion();
        LocalDate fechaHasta = vo.getFechaFin();
        List<LocalDate> fechasFaltantes = new ArrayList<>();
        int difMeses = 0;
        
        try {
            difMeses = (int) ChronoUnit.MONTHS.between(fechaDesde, fechaHasta);
        } catch(Exception ex) {
            System.out.print(ex);
            difMeses = 0;
        }
        for (int i = 0; i <= difMeses; i++) {
            if (!vo.getFechas().contains(fechaProceso)){
                fechasFaltantes.add(fechaProceso);
            }
            fechaProceso= fechaProceso.plusMonths(new Long(1));
        }
        
        if(!fechasFaltantes.isEmpty()){
            vo.setFechasFaltantes(fechasFaltantes);
        }
        return vo;
    }
}
