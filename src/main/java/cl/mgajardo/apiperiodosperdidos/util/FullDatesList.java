package cl.mgajardo.apiperiodosperdidos.util;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cl.mgajardo.apiperiodosperdidos.controller.GeneralExceptionHandler;
import cl.mgajardo.apiperiodosperdidos.controller.PeriodosPerdidosApi;

public class FullDatesList {
	
    Logger log = LoggerFactory.getLogger(PeriodosPerdidosApi.class);
	
	private final LocalDate fechaCreacion;
	private final LocalDate fechaFin;
	private final List<LocalDate> fechas;
    private final String ERROR_MESSAGE = "Error en la ejecución de la utilidad";
	 
	public FullDatesList(LocalDate fechaCreacion, LocalDate fechaFin, 
			List<LocalDate> fechas) {
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechas = fechas;
	}

	/**
	 * Genera una cantidad cierta de fechas, dado un periodo
	 * y las colecta dentro del límite inicial y final.
	 * Dadas dos fechas, excluye el segundo argumento en la lista.
	 * Considerar plusDays(1) para su inclusión si es necesario.
	 * 	
	 */
	public List<LocalDate> generateDates() {
		long obtCantidadDeFechas = ChronoUnit.DAYS.between(fechaCreacion, fechaFin.plusDays(1)); 
		return IntStream.iterate(0, i -> i + 1)
		.limit(obtCantidadDeFechas)
		.mapToObj(i -> fechaCreacion.plusDays(i))
		.collect(Collectors.toList());
	}
	  

	/**
	 * Obtiene todas las fechas de una lista y ejecuta
	 * un filtro que permite la colección sólo de aquellas
	 * que correspondan al primer día de cada mes.
	 * Retorna la lista de fechas.
	 */
	public List<LocalDate> filterDatesWithDayOfMonth() {
		List<LocalDate> fechasGeneradas = generateDates();
		List<LocalDate> retornoFechas = new ArrayList<LocalDate>();
		if (fechasGeneradas.isEmpty()) {
			log.error("No existen datos para procesar en la Lista", 
					fechasGeneradas);
			throw new GeneralExceptionHandler(ERROR_MESSAGE);
		} else {
		fechasGeneradas.forEach(f -> {
		int firstDay = f.get(ChronoField.DAY_OF_MONTH);
		if (firstDay == 1) {
		retornoFechas.add(f);
		}});
		}
		return retornoFechas;
	  }
	
	/**
	 * Ejecuta la remoción de todas las fechas existentes
	 * en la lista de origen, permitiendo el retorno de la 
	 * colección con las fechas faltantes.
	 */
	public List<LocalDate> executeFilter() {
		List<LocalDate> generatedDates = filterDatesWithDayOfMonth();
		generatedDates.removeAll(fechas);
		return generatedDates;
	}
}