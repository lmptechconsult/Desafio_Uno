package com.previred.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.previred.model.PeriodoModel;
import com.previred.repository.PeriodoRepository;


@Service
public class PeriodoServiceImpl implements PeriodoService{

		Logger logger = LogManager.getLogger(PeriodoServiceImpl.class.getName());
		
		@Autowired
		PeriodoRepository periodoRepository;
		
		@Override
		public PeriodoModel buscarPeriodoFaltantes() throws Exception {
			try {
				PeriodoModel periodo = periodoRepository.buscarPeriodoFaltantes();
				List<LocalDate> fechasFaltantes = new ArrayList<LocalDate>();			

				long cantidadMeses = ChronoUnit.MONTHS.between(periodo.getFechaCreacion(), periodo.getFechaFin());

				LocalDate fechaAux=periodo.getFechaCreacion();

				for(int mes=0; mes<=cantidadMeses; mes++) {	        

					if(!periodo.getFechas().contains(fechaAux)) {
						fechasFaltantes.add(fechaAux);
					}

					fechaAux = fechaAux.plusMonths(1);
				}

				periodo.setFechasFaltantes(fechasFaltantes);

				return periodo;
			}catch(Exception e) {
				logger.error(e);
				throw new Exception(e.getMessage());
			}
		}

}
