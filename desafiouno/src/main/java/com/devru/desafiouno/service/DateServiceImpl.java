package com.devru.desafiouno.service;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.devru.desafiouno.dto.Periodo;
import com.devru.desafiouno.utils.DesafioUtils;
import com.devru.desafiouno.webservices.WebServiceFacade;
import com.devru.desafiouno.webservices.WebServicesUtils;
import com.devru.desafiouno.webservices.dto.ObtenerPeriodosRequest;
import com.devru.desafiouno.webservices.dto.ObtenerPeriodosResponse;

@Service
public class DateServiceImpl implements DateService {

	private static final Logger log = LogManager.getLogger(DateServiceImpl.class);
	
	/* Para consultar servicios externos  */
	@Autowired
	private WebServiceFacade ws;
	
	@PostConstruct
	private void init() {
		/** Por si necesito inicializar previamente */
	}	
	
	
	@Override
	public Periodo calcularPeriodos() throws RestClientException {
		log.info("calcularPeriodos init");
		ObtenerPeriodosRequest serviceRequest = new ObtenerPeriodosRequest();
		serviceRequest.setTrx(DesafioUtils.formatDate(DesafioUtils.santiagoDate(), DesafioUtils.FULL_DATE_FORMAT));
		
		log.info("llamando servicio externo GDD");
		ObtenerPeriodosResponse serviceResponse = null;
		try {
			serviceResponse = ws.obtenerPeriodos(serviceRequest);
			log.info("recibiendo respuesta servicio externo GDD");
		} catch (RestClientException rce) {
			
			if (rce.getCause() instanceof ConnectTimeoutException) {
				log.error("ConnectTimeoutException: {}", "Tiempo de conexion ("+WebServicesUtils.ConnectTimeout+"mseg) con servicio GDD agotado");
				throw new RestClientException("Tiempo de conexion ("+WebServicesUtils.ConnectTimeout+"mseg) con servicio GDD agotado");
			} else if (rce.getCause() instanceof HttpClientErrorException) {
				log.error("HttpClientErrorException: {}", rce.getMessage());
				throw rce;
			} else if (rce.getCause() instanceof HttpServerErrorException) {
				log.error("HttpServerErrorException: {}", rce.getMessage());
				throw rce;
			} else if (rce.getCause() instanceof UnknownHttpStatusCodeException) {
				log.error("UnknownHttpStatusCodeException: {}", rce.getMessage());
				throw rce;
			}

		} 		
		
		if(serviceResponse != null && serviceResponse.getFechaCreacion() != null && !serviceResponse.getFechaCreacion().isEmpty() && serviceResponse.getFechaFin() != null && !serviceResponse.getFechaCreacion().isEmpty() ) {
			log.info("serviceResponse ok {}", serviceResponse);
			/*Se prepara el formato de fecha a leer*/
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			/*Se instancian las fechas*/
			YearMonth fechaCreacion = YearMonth.parse(serviceResponse.getFechaCreacion(), formatter);
			YearMonth fechaFin = YearMonth.parse(serviceResponse.getFechaFin(), formatter);
			/*Lista de fechas faltantes*/
			List<String> fechasFaltantes = new ArrayList<>();
			
			/*Se valida que la lista de periodos pre-generados por el GDD no sea null*/
			if(serviceResponse.getFechas() == null || serviceResponse.getFechas().isEmpty()) {
				serviceResponse.setFechas(new ArrayList<>());
			}
			
			log.info("completando fechas");
			while(fechaCreacion.isBefore(fechaFin)) { /*Miestras sea antes de la fecha fin*/
				/*Se incrementa el mes de uno en uno*/
				fechaCreacion = fechaCreacion.plusMonths(1); 
				log.info("fecha calculada: {}",fechaCreacion+"-01");
				/* Si ya existe en la lista de fechas generadas por GDD (Generador Datos Desafio) servicio externo*/
				if (serviceResponse.getFechas().contains(fechaCreacion+"-01") || serviceResponse.getFechaFin().equalsIgnoreCase(fechaCreacion+"-01")) {
					log.debug("fecha {} ya existe", fechaCreacion+"-01");
				} else {
					log.debug("fecha {} agregada", fechaCreacion+"-01");
					fechasFaltantes.add(fechaCreacion+"-01");
				}
			}
			log.info("fechas completadas");
			/*Se mapea el objeto con las dos lista de fechas*/
			Periodo periodo = new Periodo();
			periodo.setFechaCreacion(serviceResponse.getFechaCreacion());
			periodo.setFechaFin(serviceResponse.getFechaFin());
			periodo.setFechas(serviceResponse.getFechas());
			periodo.setFechasFaltantes(fechasFaltantes);
			periodo.setId(serviceResponse.getId());
			return periodo;			
		} else {
			log.error("Respuesta del Servicio GDD {}", serviceResponse);
			throw new RestClientException("Error en respuesta del Servicio GDD");
		}

	}

}
