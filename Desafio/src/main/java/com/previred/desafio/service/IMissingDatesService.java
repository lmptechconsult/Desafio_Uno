package com.previred.desafio.service;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.previred.desafio.configuration.ConfigProperties;
import com.previred.desafio.exception.ApiForbiddenException;
import com.previred.desafio.exception.ApiJsonException;
import com.previred.desafio.exception.ApiRequestException;
import com.previred.desafio.model.Periodo;
import com.previred.desafio.repository.RestRepository;
import com.previred.desafio.utils.DateUtils;
import com.previred.desafio.utils.FileWriterUtils;

@Service
public class IMissingDatesService implements MissingDatesServices {

	;
	@Autowired
	ConfigProperties configProperties;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	RestRepository restRepository;

	public String findAll() throws Exception

	{
		try {
			String json_output;
			String json_input;
			Periodo periodo = restRepository.getPeriods(restTemplate, configProperties);
			ObjectWriter ow = new ObjectMapper()
					.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS).writer()
					.withDefaultPrettyPrinter();
			json_input = ow.writeValueAsString(periodo);
			periodo.setFechasFaltantes(DateUtils.CalculateMissingDates(periodo));

			json_output = ow.writeValueAsString(periodo);
			FileWriterUtils.FileWrite(json_input, configProperties.getPathInputJson());
			FileWriterUtils.FileWrite(json_output, configProperties.getPathOutputJson());

			return json_output;

		} catch (ResourceAccessException e) {
			throw new ApiRequestException("No se puede acceder a la api con el url facilitado : "
					+ configProperties.getApiHost() + configProperties.getApiResource());
		} catch (JsonProcessingException e) {
			throw new ApiJsonException("No se ha podido mapear el objeto a formato json");
		} catch (AccessDeniedException e) {
			throw new ApiForbiddenException("El acceso a la api ha sido denegado");
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error inesperado");
		}

	}

}