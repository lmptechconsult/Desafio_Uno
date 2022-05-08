package com.desafiouno.previred.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafiouno.previred.model.Fechas;
import com.desafiouno.previred.model.Periodos;

@Service
public class FechasService {
	
	private final static String URL = "http://127.0.0.1:8080/periodos/api";

	final RestTemplate restTemplate;

    public FechasService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Periodos getDatesMissing() {
    	try {
        ResponseEntity<Fechas> response = restTemplate.getForEntity(URL, Fechas.class);
        if(response == null) {
        	System.out.println("Debe ejecutar el servicio GDD");
        }
        Fechas fechasEntrada = response.getBody();
        LocalDate fechaCreacion = fechasEntrada.getFechaCreacion();
        LocalDate fechaFinal = fechasEntrada.getFechaFin();
        List<LocalDate> fechas = fechasEntrada.getFechas();
        List<LocalDate> allDates = new ArrayList<>();
        allDates.add(fechaCreacion);
        for(int i;fechaCreacion.isBefore(fechaFinal);) {
        	allDates.add(fechaCreacion.plusMonths(1));
            fechaCreacion = fechaCreacion.plusMonths(1);
        }
        allDates.removeAll(fechas);
        allDates.remove(allDates.size() - 1);
        return new Periodos(fechasEntrada,allDates);
    	}catch(Exception e) {
    		return null;
    	}

    }
}


