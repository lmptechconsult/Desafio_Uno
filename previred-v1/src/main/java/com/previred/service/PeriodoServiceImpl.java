package com.previred.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.configuration.Config;
import com.previred.domain.Periodo;
import com.previred.file.FileWrite;
import com.previred.repository.PeriodoRepository;
import com.previred.util.ConversionUtil;

@Service
public class PeriodoServiceImpl implements PeriodoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PeriodoServiceImpl.class);
	
	@Autowired
	private PeriodoRepository periodoRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Config config;
	
	@Override
	public String getFechasFaltantes() {
		ObjectMapper mapper = new ObjectMapper();
		ConversionUtil conversionUtil = new ConversionUtil();
		String jsonPeriodo = null;
		
		Periodo periodo = periodoRepository.readJson(restTemplate, config);
		
		FileWrite fileWrite = new FileWrite();
		
		fileWrite.writeFile(periodo, config.getPathnameInput());
		periodo.setFechasFaltantes(conversionUtil.fechasFaltantes(periodo));
		fileWrite.writeFile(periodo, config.getPathnameOutput());
		
		try {
			jsonPeriodo = mapper.writeValueAsString(periodo);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error al procesar Json", e);
		}
		
		return jsonPeriodo;
	}

}
