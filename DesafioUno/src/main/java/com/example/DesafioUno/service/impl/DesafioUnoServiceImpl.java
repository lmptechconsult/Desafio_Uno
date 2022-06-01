package com.example.DesafioUno.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DesafioUno.model.DesafioUnoResponse;
import com.example.DesafioUno.rest.PeriodosRestTemplate;
import com.example.DesafioUno.service.DesafioUnoService;

@Service
public class DesafioUnoServiceImpl implements DesafioUnoService {

	private static final Logger log = LoggerFactory.getLogger(DesafioUnoServiceImpl.class);

	@Autowired
	private PeriodosRestTemplate periodosRestTemplate;

	@Override
	public DesafioUnoResponse obtenerFechas() {
		log.info("Ingresando a obtenerFechas()");
		DesafioUnoResponse response = new DesafioUnoResponse();
		response = this.periodosRestTemplate.obtenerFechasGeneradorDesafioUno();
		if (response != null && response.getFechaCreacion() != null && response.getFechaFin() != null) {
			log.info("Obteniendo cantidad de meses entre fecha creacion: "+response.getFechaCreacion()+ " Fecha fin: "+response.getFechaFin());
			Long months = ChronoUnit.MONTHS.between(response.getFechaCreacion(), response.getFechaFin());
			log.info("Generando fechas intermedias entre ambas fechas");
			response.setFechasFaltantes(LongStream.range(0, months+1).mapToObj(response.getFechaCreacion()::plusMonths)
					.collect(Collectors.toList()));
			if (response.getFechas() != null && !response.getFechas().isEmpty()) {
				log.info("Descartando fechas entregadas desde Generador de fechas");
				response.getFechasFaltantes().removeAll(response.getFechas());
			}
		}
		log.info("Saliendo de obtenerFechas()");
		return response;

	}
}
