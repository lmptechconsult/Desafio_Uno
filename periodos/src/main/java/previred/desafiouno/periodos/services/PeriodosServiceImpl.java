package previred.desafiouno.periodos.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import previred.desafiouno.periodos.excepciones.AppPropertiesException;
import previred.desafiouno.periodos.excepciones.FechasFaltantesException;
import previred.desafiouno.periodos.excepciones.ServicioGDDException;
import previred.desafiouno.periodos.servicios.model.Periodo;
import previred.desafiouno.periodos.utils.Propiepdades;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
* 
*/

@Service
public class PeriodosServiceImpl implements PeriodosService {

	final String GDD_SERVICE_URI_PROP = "service.gdd.uri";

	
	
	@Override
	public Periodo faltantes() throws FechasFaltantesException {

		//consumir GDD REST Service y obtener periodo
		Periodo periodoGDD = null;
		try {
			periodoGDD = getPeriodoGDD();
		} catch (ServicioGDDException e) {
			throw new FechasFaltantesException(e.getMessage());
		}

		validoPeriodo(periodoGDD);

		calculoFechasFaltantes(periodoGDD);

		return periodoGDD;
	}
	
	

	//////////////////////////////PRIVADAS////////////////////////////////////

	private Periodo getPeriodoGDD() throws ServicioGDDException {
		//Consume servicio REST Generador de datos (GDD)
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri;
		String uriServicioGDDProp = obtenerURIServicioGDD();
		try {
			uri = new URI(uriServicioGDDProp);
		} catch (URISyntaxException e) {
			throw new ServicioGDDException(
					"Error de formato con la URL del servicio GDD: "
							+ e.getMessage());
		}
		ResponseEntity<Periodo> respuestaGDD = null;
		try {
			respuestaGDD = restTemplate.getForEntity(uri, Periodo.class);
		} catch (Exception e) {
			throw new ServicioGDDException(
					"Error en la llamada al servicio GDD: " + e.getMessage());
		}
		if (respuestaGDD == null)
			throw new ServicioGDDException(
					"Servicio GDD entrega respuesta nula.");

		Periodo periodo = respuestaGDD.getBody();
		return periodo;

	}
	
	private void validoPeriodo(Periodo periodo) throws FechasFaltantesException {
		//Valida contenido del objeto periodo
		
		if (periodo.getFechaCreacion() == null)
			throw new FechasFaltantesException(
					"Fecha de creacion del periodo es nula.");
		if (periodo.getFechaFin() == null)
			throw new FechasFaltantesException(
					"Fecha de fin del periodo es nula.");

		if (periodo.getFechas() == null)
			periodo.setFechas(new ArrayList<LocalDate>());

		// Me aseguro que las fechas esten ordenadas
		Set<LocalDate> fechas = new HashSet<>(periodo.getFechas());
		periodo.setFechas(fechas.stream().sorted().collect(Collectors.toList()));

	}

	
	private String obtenerURIServicioGDD() throws ServicioGDDException {
		//Obtiene la URI del servicio REST GDD de aplication.properties
		
		Properties props;
		try {
			props = Propiepdades.getAppProperties();
		} catch (AppPropertiesException e) {
			throw new ServicioGDDException(
					"Error al intentar obtener la URI para la llamada del servicio GDD "
							+ "desde el archivo application.properties: "
							+ e.getMessage());
		}
		if (props.getProperty(GDD_SERVICE_URI_PROP) == null)
			throw new ServicioGDDException(
					"Llamada al servicio GDD. No se encuentra la propiedad "
							+ GDD_SERVICE_URI_PROP
							+ " en el archivo application.properties.");
		return props.getProperty(GDD_SERVICE_URI_PROP);

	}


	private Periodo calculoFechasFaltantes(Periodo periodoGDD) {
		//Calcula las fechas faltantes a partir de las fechas recibidas en periodoGDD
		
		LocalDate fechaCreacion = periodoGDD.getFechaCreacion();
		LocalDate fechaFin = periodoGDD.getFechaFin();
		int posFechasGDD = 0;
		boolean fechasGDDFin = posFechasGDD >= periodoGDD.getFechas().size();
		LocalDate fechaGDDComparar = null;
		if (!fechasGDDFin)
			fechaGDDComparar = periodoGDD.getFechas().get(posFechasGDD);
		Set<LocalDate> fechasFaltan = new HashSet();

		/*
		 * recorro años y meses del período, comparando con la fechaGDD en la
		 * posicion posFechasGDD de periodoGDD.getFechas() que es una lista
		 * ordenada creciente, y agrego las que faltan entre medio. De esta
		 * forma recorro esa lista una sola vez.
		 */
		//recorro los años del período
		for (int anio = fechaCreacion.getYear(); anio <= fechaFin.getYear(); anio++) {
			int mesInicio = 1;
			int mesFin = 12;
			if (anio == fechaCreacion.getYear()) {
				mesInicio = fechaCreacion.getMonthValue();
			}
			if (anio == fechaFin.getYear()) {
				mesFin = fechaFin.getMonthValue();
			}
			
			//recorro los meses del período
			for (int mes = mesInicio; mes <= mesFin; mes++) {
				LocalDate fechaActual = LocalDate.of(anio, mes, 1);

				/*
				 * mientras fechaActual sea menor que la actual referenciada de
				 * GDD, la agrego pues falta,o, si ya recorri todas las fechas
				 * GDD y aún no recorro el período completo, agreggo hasta
				 * completarlo.
				 */
				if (fechasGDDFin || fechaActual.compareTo(fechaGDDComparar) < 0) {
					fechasFaltan.add(fechaActual);
				} else {
					/*
					 * se alcanzó una fecha GDD, por lo tanto la actual no
					 * falta, no se agrega, y hay que ir por la siguiente fecha
					 * GDD
					 */
					posFechasGDD++;
					if (posFechasGDD < periodoGDD.getFechas().size())
						fechaGDDComparar = periodoGDD.getFechas().get(
								posFechasGDD);
					else
						fechasGDDFin = true;
				}
			}
		}

		periodoGDD.setFechasFaltantes(fechasFaltan.stream().sorted()
				.collect(Collectors.toList()));

		return periodoGDD;
	}

}
