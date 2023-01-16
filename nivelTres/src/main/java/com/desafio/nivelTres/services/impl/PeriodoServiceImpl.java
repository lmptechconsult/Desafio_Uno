package com.desafio.nivelTres.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.nivelTres.model.Period;
import com.desafio.nivelTres.services.PeriodosService;

@Service("restService")
public class PeriodoServiceImpl implements PeriodosService {

	@Override
	public List<LocalDate> searchMissedPeriods(LocalDate fechaCreacion, LocalDate fechaFin, List<LocalDate> fechas) {
		List<LocalDate> fechasFaltantes = new ArrayList<LocalDate>();

		for (LocalDate date = fechaCreacion; date.isBefore(fechaFin); date = date.plusMonths(1)) {
			fechasFaltantes.add(date);
		}
		fechasFaltantes.removeAll(fechas);
		return fechasFaltantes;
	}

	@Override
	public Period getMissedPeriodos(String url) {
		Period periodIn = getPeriod(url); // devuelve objeto period
		Long id = periodIn.getId();
		LocalDate fechaCreacion = periodIn.getFechaCreacion();
		LocalDate fechaFin = periodIn.getFechaFin();
		List<LocalDate> fechasRandom = periodIn.getFechas();

		Period periodOut = new Period(id, fechaCreacion, fechaFin, fechasRandom, null);
		periodOut.setFechasFaltantes(searchMissedPeriods(fechaCreacion, fechaFin, fechasRandom));
		return periodOut;
	}

	@Override
	public Period getPeriod(String url) {
		RestTemplate restTemplate = new RestTemplate();
		Period period = restTemplate.getForObject(url, Period.class);
		return period;
	}

}