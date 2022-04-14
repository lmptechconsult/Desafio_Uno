package cl.previred.desafiouno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.previred.desafiouno.dao.PeriodoDAO;
import cl.previred.desafiouno.entity.Periodo;

@Service
public class PeriodoServiceImpl implements PeriodoService {

    @Autowired
    private PeriodoDAO periodoDAO;
	
	@Override
	public List<Periodo> getPeriodos(String fechainicio, String fechafin) {
		List<Periodo> listaPeriodo = periodoDAO.getPeriodos(fechainicio, fechafin);
		return listaPeriodo;
	}
	
}
