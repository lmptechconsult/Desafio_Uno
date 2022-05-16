package com.previred.desafio.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.previred.desafio.model.Periodo;

public class DateUtils {

	public static ArrayList<String> CalculateMissingDates(Periodo periodo) throws IOException {

		LocalDate startDate = LocalDate.parse(periodo.getFechaCreacion());
		LocalDate endDate = LocalDate.parse(periodo.getFechaFin());
		ArrayList<String> missingDates = new ArrayList<>();
		while (!startDate.equals(endDate)) {
			if (!periodo.getFechas().contains(String.valueOf(startDate))) {
				missingDates.add(String.valueOf(startDate));
			}
			startDate = startDate.plusMonths(1);
		}
		return missingDates;
	}

}
