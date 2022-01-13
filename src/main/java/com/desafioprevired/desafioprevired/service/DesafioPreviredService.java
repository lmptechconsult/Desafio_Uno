package com.desafioprevired.desafioprevired.service;

import com.desafioprevired.desafioprevired.model.Periodo;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Service
public class DesafioPreviredService {

    public Periodo getFechasFaltantes(Periodo periodo){
        List<LocalDate> fechasFaltantes = new ArrayList();
        List<LocalDate> fechasEntrantes = periodo.getFechas();

        /*
        * Solucion estilo Imperativo.
        *
        int indexSiguienteFecha = 0;
        int indexUltimoRegistro = fechasEntrantes.size()-1;

        for (int i = 0; i < fechasEntrantes.size(); i++) {
            LocalDate fechaActual = fechasEntrantes.get(i);
            indexSiguienteFecha = i+1;

            //Si el registro actual no es igual al próximo
            if(!fechasEntrantes.get(indexUltimoRegistro).equals(fechaActual)){
                LocalDate fechaSiguiente = fechasEntrantes.get(indexSiguienteFecha);

                //Obtengo las fechas faltantes entre el objeto actual y el proximo
                for (int mesFechaFaltante = 1; !fechaActual.plusMonths(mesFechaFaltante).equals(fechaSiguiente); mesFechaFaltante++) {
                    fechasFaltantes.add(fechaActual.plusMonths(mesFechaFaltante));
                }
            }
        }*/


        /*
        * Solucion estilo Funcional.
        */
        IntStream.range(0,fechasEntrantes.size()-1).forEach(i -> {
           fechasEntrantes.get(i).plusMonths(1).
                   datesUntil(fechasEntrantes.get(i+1), Period.ofMonths(1)).
                   forEach(fechasFaltantes::add);
        });

        periodo.setFechas(fechasFaltantes);
        return periodo;
    }

}
