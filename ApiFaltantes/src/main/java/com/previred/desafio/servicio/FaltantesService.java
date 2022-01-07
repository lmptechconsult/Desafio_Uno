package com.previred.desafio.servicio;

import com.previred.desafio.swagger.codegen.model.Faltante;
import com.previred.desafio.utils.BetweenDates;
import com.previred.periodos.api.client.model.Periodo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 *
 * @author samanzanom@gmail.com
 */
@Service
public class FaltantesService {

    Logger log = LoggerFactory.getLogger(FaltantesService.class);

    @Value("${api.destino.endpoint}")
    private String endPointApiDestindo;

    /**
     * Genera un Objeto faltante, con las fechas que debería contener la api periodos, pero no se encontraron
     *
     * @return
     * @param fechaInicio
     * @param fechaFin
     */
    public Faltante getFaltantes(String fechaInicio, String fechaFin) {

        Faltante faltante = new Faltante();
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate fechaInicial = LocalDate.parse(fechaInicio, formatter);
            LocalDate fechaTermino = LocalDate.parse(fechaFin, formatter);

            /*
                Obtenemos las fechas que deberían estar entre 2 fechas
             */
            BetweenDates betweenDates = new BetweenDates(fechaInicial, fechaTermino);
            String[] fechasTotales = betweenDates.getDates();

            if(log.isDebugEnabled()) {
                log.debug("Fechas Que deberian existir");
                log.debug(fechasTotales.toString());
            }

            /*
                Obtenemos las fechas desde la api periodos
             */
            List<String> periodos = new ArrayList<>();
            RestTemplate plantilla = new RestTemplate();
            Periodo periodo = plantilla.getForObject(endPointApiDestindo, Periodo.class);

            if(log.isDebugEnabled()) {
                log.debug("Fechas API Periodo");
                log.debug(periodo.toString());
            }


            for(LocalDate date : periodo.getFechas() ) {
                periodos.add(date.format(formatter));
            }

            /*
            Comparamos ambas listas
             */
            LocalDate[] fechasFaltantes = compareDates(fechasTotales, periodos.toArray(new String[0]));

            /*
            poblamos el objeto de resultado
             */
            faltante.setId(periodo.getId());
            faltante.setFechaCreacion(fechaInicial);
            faltante.setFechaFin(fechaTermino);
            faltante.setFechas(periodo.getFechas());
            faltante.setFechasFaltantes(Arrays.asList(fechasFaltantes));

        }catch (Exception e) {
            log.error("Error al obtener fechas.", e);
        }
        return faltante;
    }

    /**
     * Retorna la lista de fechas que deberían estar en la lista de periodos y no estan
     * @param fechas fechas que si deberian existir
     * @param periodo fechas obtenidas desde la api de periodos
     * @return retorna un arreglo con las fechas faltantes
     */
    private LocalDate[] compareDates(String[] fechas, String[]  periodo) {

        List<LocalDate> fechasDistintas = new ArrayList<>();
        Set<String> setFechas = new HashSet<>(Arrays.asList(fechas));
        Set<String> setPeriodo = new HashSet<>(Arrays.asList(periodo));

        //Comparacion de fechas
        String[] notExists = setFechas.stream().filter(e -> !setPeriodo.contains(e)).sorted().toArray(String[]::new);

        //Parseo de fechas tipo String a Localdate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        for (String fecha : notExists) {
            fechasDistintas.add(LocalDate.parse(fecha, formatter));
        }

        return fechasDistintas.toArray(new LocalDate[0]);
    }
}
