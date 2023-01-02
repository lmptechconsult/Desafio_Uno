package com.previred.periodos.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.previred.periodos.model.Periodo;
import com.previred.periodos.tools.Respuesta;

@Service
public class PeriodosService {
    Respuesta respuesta = new Respuesta();
    
//Metodo para determinar las fechas faltantes del periodo
    public Respuesta getFechasFaltantes(Periodo periodo) {

        //Determinar si la fecha de creacion es mayor que la fecha de fin
        if (periodo.getFechaCreacion().isAfter(periodo.getFechaFin())) {
            respuesta.setMessage("Lapso de fecha incorrecta");
            respuesta.setPeriodo(null);
            respuesta.setCode(0);
            return respuesta;
        }

        int minDay = (int) periodo.getFechaCreacion().toEpochDay();
        int maxDay = (int) periodo.getFechaFin().toEpochDay();

        Set<LocalDate> fechasTotales = new HashSet<>();

        for (int i = minDay; i <= maxDay; i++) {
            // System.out.println( LocalDate.ofEpochDay(i).withDayOfMonth(1).toString());
            fechasTotales.add(LocalDate.ofEpochDay(i).withDayOfMonth(1));
        }
        //Determinar si hay mas de 100 fechas dentro el intervalo
        if (fechasTotales.size()>100) {
            respuesta.setMessage("Rango de fecha demasiado grande");
            respuesta.setPeriodo(null);
            respuesta.setCode(-1);
            return respuesta;
        }
        Set<LocalDate> fechasFaltantes = fechasTotales.stream()
                .filter(val -> !periodo.getFechas().contains(val))
                .collect(Collectors.toSet());

        periodo.setFechasFaltantes(fechasFaltantes);

        respuesta.setMessage("ok");
            respuesta.setPeriodo(periodo);
            respuesta.setCode(1);
            return respuesta;
    }

}
