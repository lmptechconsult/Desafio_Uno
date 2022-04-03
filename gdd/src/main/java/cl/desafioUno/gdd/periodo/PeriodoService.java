package cl.desafioUno.gdd.periodo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.desafioUno.gdd.tools.RandomDate;

/**
 * @author Francisco Devaud
 * @date 02/04/2022
 **/
@Service
public class PeriodoService {

	private final static int MIN = 10;  
	private final static int MAX = 100;  

	/**
	 * Implementacion otorgada a modo de ejemplo, lista de periodos aleatorios
	 * 
	 * @return periodo
	 */
	public Periodo getPeriodosAll()  {
		// Se asguran almenos 100 fechas distintas 2004 - 1013
		RandomDate fechaInicial = new RandomDate(LocalDate.of(1980, 1, 1), LocalDate.of(2004, 1, 1));
		RandomDate fechaFin = new RandomDate(LocalDate.of(2013, 2, 1), LocalDate.of(2019, 1, 1));

		Periodo periodo = new Periodo();
		periodo.setId(1L);
		periodo.setFechaCreacion(fechaInicial.nextDate());
		periodo.setFechaFin(fechaFin.nextDate());
		RandomDate fechaPeriodos = new RandomDate(periodo.getFechaCreacion(), periodo.getFechaFin());

		Random aleatorio = new Random();
		int cantidadPeriodos = aleatorio.nextInt((MAX - MIN) + 1) + MIN;
		Set<LocalDate> fechas = new HashSet<LocalDate>();
		while (fechas.size() <= cantidadPeriodos) {
			fechas.add(fechaPeriodos.nextDate());
		}
		periodo.setFechas(fechas.stream().sorted().collect(Collectors.toList()));
		return periodo;
	}

	/**
	 * Periodo entrante junto con la lista de periodos requeridos
	 * 
	 * @param periodo
	 * @return periodo
	 */
	public Periodo getPeriodosJSON(Periodo periodo){
		periodo.setFechas(periodo.getFechas().stream().sorted().collect(Collectors.toList()));
		List<LocalDate> recibe = faltantesPeriodos(periodo.getFechaCreacion(), periodo.getFechaFin(),
				periodo.getFechas());
		periodo.setFechasFaltantes(recibe);
		return periodo;
	}

	/**
	 * Periodos faltantes segun criteria de entrada
	 * 
	 * @param ldFechaInicio fecha de inicio
	 * @param ldFechaFin    fecha de fin
	 * @param fechasList    lista de fechas establecidas
	 * @return List<LocalDate>
	 */
	public static List<LocalDate> faltantesPeriodos(LocalDate ldFechaInicio, LocalDate ldFechaFin,
			List<LocalDate> fechasList) {
		Set<LocalDate> fechaTemp = new HashSet<LocalDate>();
		int cantidad=0;
		while (ldFechaInicio.isBefore(ldFechaFin) && cantidad<MAX) {
			ldFechaInicio = ldFechaInicio.plusMonths(1);
			Boolean flag = false;
			for (LocalDate auxFechas : fechasList) {
				if (auxFechas.equals(ldFechaInicio))
					flag = true;
			}
			if (!flag) {
				fechaTemp.add(ldFechaInicio);
				cantidad++;
			}
				
		}
		return fechaTemp.stream().sorted().collect(Collectors.toList());
	}

}
