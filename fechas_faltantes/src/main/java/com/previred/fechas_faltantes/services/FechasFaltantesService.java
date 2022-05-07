package com.previred.fechas_faltantes.services;

import com.previred.fechas_faltantes.dto.RespuestaDto;
import com.previred.fechas_faltantes.models.FechasEntrada;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FechasFaltantesService {

    final RestTemplate restTemplate;

    public FechasFaltantesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RespuestaDto getFechasFaltantes() {

        //CONSULTO LA API GENERADOR DE DATOS Y GUARDO LOS DATOS EN LA CLASE FECHASDEENTRADA
        String url = "http://127.0.0.1:8080/periodos/api";
        ResponseEntity<FechasEntrada> response = restTemplate.getForEntity(url, FechasEntrada.class);
        FechasEntrada fechasEntrada = response.getBody();


        LocalDate fechaCreacion = fechasEntrada.getFechaCreacion();
        LocalDate fechaFin = fechasEntrada.getFechaFin();
        List<LocalDate> fechas = fechasEntrada.getFechas();

        //GENERO UNA LISTA CON TODAS LAS FECHAS DESDE LA CREACION AL FIN INCLUIDOS
        List<LocalDate> todasLasFechas = new ArrayList<>();
        todasLasFechas.add(fechaCreacion);
        while (fechaCreacion.isBefore(fechaFin)) {
            todasLasFechas.add(fechaCreacion.plusMonths(1));
            fechaCreacion = fechaCreacion.plusMonths(1);

        }

        //OBTENGO LAS FECHAS FALTANTES, ELIMINADO TODOS LOS DATOS QUE SE ENCUENTRAN EN LA LISTA FECHAS
        todasLasFechas.removeAll(fechas);
        return new RespuestaDto(fechasEntrada,todasLasFechas);

    }
}
