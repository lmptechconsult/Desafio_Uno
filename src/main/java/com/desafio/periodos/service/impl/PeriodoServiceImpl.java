package com.desafio.periodos.service.impl;

import com.desafio.periodos.config.exceptions.ServiceException;
import com.desafio.periodos.model.Periodo;
import com.desafio.periodos.service.PeriodoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PeriodoServiceImpl implements PeriodoService {
    private static final Log LOGGER = LogFactory.getLog(PeriodoServiceImpl.class);
    private static final int MES=1;
    private static final String ERROR_CLIENTE = "Error con el cliente ";
    private static final String ERROR_SERVICIO = "Error al consumir el servicio: ";
    private static final String ERROR_RESPUESTA = "La respuesta del servicio es nula";
    private static final String ERROR_NULO = "Se ha encontrado un valor nulo: ";

    @Value("${endpoint.periodo.local}")
    private String urlEdnpointPeriodo;

    @Override
    public Periodo obtenerFechasFaltantes() {
        LOGGER.info("Inicio impl obtenerFechasFaltantes");
        Periodo periodo = new Periodo();
        RestTemplate restTemplate = new RestTemplate();
        Periodo respuestaPerido;
        try {
            respuestaPerido = restTemplate.getForObject(urlEdnpointPeriodo, Periodo.class);
        }catch(RestClientException e){
            LOGGER.error(ERROR_CLIENTE + e.getMessage());
            throw new ServiceException(ERROR_CLIENTE+ e.getMessage());
        }catch(Exception e){
            LOGGER.error(ERROR_SERVICIO + e.getMessage());
            throw new ServiceException(ERROR_SERVICIO + e.getMessage());
        }

        assert respuestaPerido != null:ERROR_RESPUESTA;
        periodo.setId(respuestaPerido.getId());
        periodo.setFechaCreacion(respuestaPerido.getFechaCreacion());
        periodo.setFechaFin(respuestaPerido.getFechaFin());
        Collections.sort(respuestaPerido.getFechas());
        periodo.setFechas(respuestaPerido.getFechas());
        List<LocalDate> fechasFaltantes = new ArrayList<>();
        LocalDate fechaConsulta = periodo.getFechaCreacion();

        try {
            while(fechaConsulta.isBefore(periodo.getFechaFin()) || fechaConsulta.isEqual(periodo.getFechaFin())){
                if(!periodo.getFechas().contains(fechaConsulta)){
                    fechasFaltantes.add(fechaConsulta);
                }
                fechaConsulta = fechaConsulta.plusMonths(MES);
            }
            periodo.setFechasFaltantes(fechasFaltantes);

        }catch(NullPointerException e){
            LOGGER.error(ERROR_NULO + e.getMessage());
            throw e;
        }

        return periodo;
    }
}
