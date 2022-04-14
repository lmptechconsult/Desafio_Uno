package cl.previred.desafiouno.service;

import java.util.List;

import cl.previred.desafiouno.entity.Periodo;

public interface PeriodoService {
	public List<Periodo> getPeriodos(String fechainicio, String fechafin);
}
