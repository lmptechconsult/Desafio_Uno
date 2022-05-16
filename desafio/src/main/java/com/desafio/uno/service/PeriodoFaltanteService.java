package com.desafio.uno.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.uno.model.Periodo;
import com.desafio.uno.model.PeriodoFaltante;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PeriodoFaltanteService implements PerodioFaltanteService{

	@Override
	public ResponseEntity<PeriodoFaltante> getFechasFaltantes(String uri) throws JsonMappingException, JsonProcessingException {
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		/* Recibimos valores de entrada*/
		Periodo fromJson = new ObjectMapper().readValue(result, Periodo.class);
		
		LocalDate ini = fromJson.getFechaCreacion();
		LocalDate end = fromJson.getFechaFin();
		Set<LocalDate> fechas = fromJson.getFechas();
		
		Set<LocalDate> listaFaltantes = new HashSet<>();
		/**
		 * Se crea lista con valores faltantes
		 * Se capturan valores de fecha inicio y fecha fin para validar los rangos
		 * */
		for (LocalDate date = ini; date.isBefore(end); date = date.plusMonths(1)){
			if(!fechas.contains(date)) {
				listaFaltantes.add(date);
			}
		}
		
//			archivoEntrada(result);
		return new ResponseEntity<>(periodoFaltante(fromJson, ini, end, listaFaltantes, fechas), HttpStatus.OK);
	}

	private void archivoEntrada(String result) throws IOException, URISyntaxException {
		CodeSource codeSource = PeriodoFaltanteService.class.getProtectionDomain().getCodeSource();
        String contenido = result;
        File file = new File(codeSource.getLocation().toURI().getPath());
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenido);
        bw.close();
	}
	
	private void archivoSalida(PeriodoFaltante pFaltante) throws IOException, URISyntaxException {
		CodeSource codeSource = PeriodoFaltanteService.class.getProtectionDomain().getCodeSource();
        StringBuffer contenido = new StringBuffer();
        contenido.append(pFaltante.getId());
        contenido.append(pFaltante.getFechaCreacion());
        contenido.append(pFaltante.getFechaFin());
        contenido.append(pFaltante.getFechas());
        contenido.append(pFaltante.getFechasFaltantes());
        File file = new File(codeSource.getLocation().toURI().getPath());
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenido.toString());
        bw.close();
		
	}

	/**
	 * Se crea entidad con valores de salida
	 * @throws URISyntaxException 
	 * */
	private PeriodoFaltante periodoFaltante(Periodo fromJson, LocalDate ini, LocalDate end, Set<LocalDate> listaFaltantes, Set<LocalDate> fechas){
		PeriodoFaltante pFaltante = new PeriodoFaltante();
		pFaltante.setId(fromJson.getId());
		pFaltante.setFechaCreacion(end);
		pFaltante.setFechaFin(ini);
		pFaltante.setFechas(fechas);
		pFaltante.setFechasFaltantes(listaFaltantes);
		
//		archivoSalida(pFaltante);
		return pFaltante;
	}
}
