package com.test.periodos.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.test.periodos.model.CFechas;
import com.test.periodos.model.CPeriodos;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FechasService {

    private final static String URL = "http://127.0.0.1:8080/periodos/api";

    final RestTemplate restTemplate;

    public FechasService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CPeriodos getDatesMissing() {
        try {
            ResponseEntity<CFechas> response = restTemplate.getForEntity(URL, CFechas.class);
            if(response == null) {
                System.out.println("Debe ejecutar el servicio GDD");
            }
            CFechas fechasEntrada = response.getBody();
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
            return new CPeriodos(fechasEntrada,allDates);
        }catch(Exception e) {
            return null;
        }

    }
}