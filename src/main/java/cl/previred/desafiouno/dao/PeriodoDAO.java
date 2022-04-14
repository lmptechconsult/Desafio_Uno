package cl.previred.desafiouno.dao;

import java.util.List;

import cl.previred.desafiouno.entity.Periodo;

public interface PeriodoDAO {
	public List<Periodo> getPeriodos(String fechainicio, String fechafin);
}
