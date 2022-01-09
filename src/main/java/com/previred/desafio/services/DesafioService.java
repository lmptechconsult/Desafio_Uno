package com.previred.desafio.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.previred.desafio.models.Periodo;

@Service
public class DesafioService {
	
	// Parametro con URl del servicio generador de datos
	@Value("${endpointservice.url}")
	private String endPointServiceExternal;

	public Periodo getAllDate() {
		// Declaración del cliente rest para consumir el servicio generador
		RestTemplate restClient = new RestTemplate();
		Periodo periodoRta = restClient.getForObject(endPointServiceExternal, Periodo.class);
		LocalDate fechaIterador = periodoRta.getFechaCreacion();
		
		while (fechaIterador.isBefore(periodoRta.getFechaFin()) 
				|| fechaIterador.isEqual(periodoRta.getFechaFin())) {
			
			if(!periodoRta.getFechas().contains(fechaIterador)) {
				periodoRta.addFechasFalantesItem(fechaIterador);
			}
			
			// fechaIterador++
			fechaIterador = fechaIterador.plusMonths(1);
			
		}
		return periodoRta;
	}
	
}
