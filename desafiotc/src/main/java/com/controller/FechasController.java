package com.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.models.FechasFaltantesModel;
import com.models.FechasModel;

/**
*
* @author daniel.segura.n@gmail.com
*/

@RestController
@RequestMapping("/fechas")
public class FechasController {
	
	/**
     * se conecta a la api periodos para consumir el servicio de Generador Datos Desafio
     * luego revisar cuales son las fechas faltantes y devolver un json con ambos arreglos de fechas
     *
     * @return FechasFaltantesModel
     */
    @GetMapping()
	public FechasFaltantesModel getFechasRecibidasGdd(){
    	String uri = "http://localhost:8080/periodos/api";
		RestTemplate restTemplate = new RestTemplate();
		
		FechasModel fechas = restTemplate.getForObject(uri, FechasModel.class);
		
		FechasFaltantesModel fechasFaltantes = new FechasFaltantesModel();
    	ArrayList<LocalDate> fechasEnviadas = fechas.getFechas();
    	ArrayList<LocalDate> fechasTotales = new ArrayList<LocalDate>();
    	ArrayList<LocalDate> difFechas = new ArrayList<LocalDate>();
    	
    	fechasFaltantes.setId(fechas.getId());
    	fechasFaltantes.setFechaCreacion(fechas.getFechaCreacion());
    	fechasFaltantes.setFechaFin(fechas.getFechaFin());
    	fechasFaltantes.setFechas(fechasEnviadas);
    	    	
    	LocalDate fecIni = fechasFaltantes.getFechaCreacion();
    	LocalDate fecFin = fechasFaltantes.getFechaFin();
    	
    	while (fecIni.isBefore(fecFin)) {
    		fechasTotales.add(fecIni);
    		fecIni = fecIni.plusMonths(1);
    	}
    	
        for (LocalDate fechasDif :fechasTotales) { 
            if (!fechasEnviadas.contains(fechasDif)) { 
            	difFechas.add(fechasDif); 
            } 
        } 
    	fechasFaltantes.setFechasFaltantes(difFechas);
    	
   
    	return fechasFaltantes;
    	
    }
    
    /**
     * servicio que obtienes a través del body un json con formato del FechasModel
     * luego revisar cuales son las fechas faltantes y devolver un json con ambos arreglos de fechas
     *
     * @return FechasFaltantesModel
     */

	@PostMapping()
    public FechasFaltantesModel getFechasFaltantes(@RequestBody FechasModel fechas){
		
    	FechasFaltantesModel fechasFaltantes = new FechasFaltantesModel();
    	ArrayList<LocalDate> fechasEnviadas = fechas.getFechas();
    	ArrayList<LocalDate> fechasTotales = new ArrayList<LocalDate>();
    	ArrayList<LocalDate> difFechas = new ArrayList<LocalDate>();
    	
    	fechasFaltantes.setId(fechas.getId());
    	fechasFaltantes.setFechaCreacion(fechas.getFechaCreacion());
    	fechasFaltantes.setFechaFin(fechas.getFechaFin());
    	fechasFaltantes.setFechas(fechasEnviadas);
    	    	
    	LocalDate fecIni = fechasFaltantes.getFechaCreacion();
    	LocalDate fecFin = fechasFaltantes.getFechaFin();
    	
    	while (fecIni.isBefore(fecFin)) {
    		fechasTotales.add(fecIni);
    		fecIni = fecIni.plusMonths(1);
    	}
    	
        for (LocalDate fechasDif :fechasTotales) { 
            if (!fechasEnviadas.contains(fechasDif)) { 
            	difFechas.add(fechasDif); 
            } 
        } 
    	fechasFaltantes.setFechasFaltantes(difFechas);
    	
   
    	return fechasFaltantes;
    }
}
