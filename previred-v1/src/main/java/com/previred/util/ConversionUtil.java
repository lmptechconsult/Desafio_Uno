package com.previred.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.previred.domain.Periodo;

public class ConversionUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConversionUtil.class);
	
	public String parseaDate(Date date){
		String dateConvert = null;
		
		if (date != null) {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
			dateConvert = sdf.format(date);
		}
		
		return dateConvert;
	}
	
	public List<String> fechasFaltantes(Periodo periodo) {
		LOGGER.info("[init fechasFaltantes Calculo]");
		List<String> fechasFaltantes = new ArrayList<>();
		
		try {
			LocalDate iniFecha = LocalDate.parse(periodo.getFechaCreacion());
			LocalDate finFecha = LocalDate.parse(periodo.getFechaFin());
			
			while (!iniFecha.equals(finFecha.plusMonths(1))) {
				if (!periodo.getFechas().contains(iniFecha.toString())) {
					fechasFaltantes.add(iniFecha.toString());
				}
				iniFecha = iniFecha.plusMonths(1);
			}
		} catch (DateTimeParseException e) {
			LOGGER.error("Error en el parse de las fechas", e);
		}
		
		
		LOGGER.info("[end fechasFaltantes Calculo]");
		return fechasFaltantes;
	}

}
