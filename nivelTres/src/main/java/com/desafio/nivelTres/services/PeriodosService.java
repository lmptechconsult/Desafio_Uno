package com.desafio.nivelTres.services;

import java.time.LocalDate;
import java.util.List;

import com.desafio.nivelTres.model.Period;

public interface PeriodosService {
	
	public Period getPeriod(String url);

	public List<LocalDate> searchMissedPeriods(LocalDate fechaCreacion, LocalDate fechaFin, List<LocalDate> fechas);
	
	public Period getMissedPeriodos(String url);

}
