package com.desafio.service;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.desafio.exception.BussinesException;
import com.desafio.model.Periodo;
import com.desafio.utils.Utils;


import io.netty.channel.ChannelOption;
import reactor.netty.http.client.HttpClient;

@Service
public class DesafioService {
	
	private static final Logger logger = LoggerFactory.getLogger(DesafioService.class);
	
	private final WebClient.Builder webClientBuilder;
    
    public DesafioService(WebClient.Builder webClientBuilder) {
     this.webClientBuilder = webClientBuilder;
    }
    
    HttpClient httpClient = HttpClient
            .create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            ;
    
    /** 
	 * Metodo que invoca a la api de periodos para obtener el listado de fechas,
	 * y procede a la busqueda de las fechas faltantes del listado obtenido
	 * 
	 * @return Objeto Periodo
	 * @author Willian Pacheco
     * @throws UnknownHostException,Exception 
	 */	
    
    
	public Periodo getFechasFaltantes () throws UnknownHostException,BussinesException {
		
		Periodo periodo = null;
		try {
			periodo = getPeriodos();
			List<LocalDate> fechasFaltante = new ArrayList<>();
			
			if (periodo != null && !Utils.isNullOrEmpty(periodo.getFechas())) {
				LocalDate fecha= periodo.getFechaCreacion();
				do {
					if (!periodo.getFechas().contains(fecha)) {
						fechasFaltante.add(fecha);
					}
					fecha = fecha.plusMonths(1);
					
				} while (fecha.isBefore(periodo.getFechaFin()));
				
				periodo.setFechasFaltantes(fechasFaltante);		
			}
		}catch (UnknownHostException ex) {
			 throw new UnknownHostException(ex.getMessage());
		}
		catch (Exception e) {
			 logger.error(e.getMessage());
			 throw  new BussinesException("500", "Error del servicio. Favor intente nuevamente o contacte al Administrador del sistema", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return periodo;
	}
    
    
    /**
	 * Metodo que invoca a la api de periodos para obtener el listado de fechas
	 * 
	 * @return Objeto Periodo
	 * @author Willian Pacheco
     * @throws UnknownHostException 
	 */	
	private  Periodo getPeriodos() throws UnknownHostException {
		
		Periodo periodo = null;
		try {
			WebClient client = webClientBuilder.clientConnector(new ReactorClientHttpConnector(httpClient))
	                .baseUrl("http://localhost:8080/periodos/api")
	                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
	                .build();        
	        periodo = client.method(HttpMethod.GET).uri("/")
	                .retrieve().bodyToMono(Periodo.class).block();
		} catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return periodo;
            } else {
                throw new UnknownHostException(e.getMessage());
            }
        }catch (Exception e) {
        	throw new UnknownHostException(e.getMessage());
        }

        
        return periodo ;
    }       
	
	


}
