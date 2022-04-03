package com.previred.app.date.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.previred.app.date.dto.ExternalResponseDTO;
import com.previred.app.date.dto.ResponseDTO;
import com.previred.app.date.exception.InteropException;
import com.previred.app.date.exception.ServicesException;
import com.previred.app.date.service.IProcessService;
import com.previred.app.date.service.external.IRequestDatesService;
import com.previred.app.date.utils.AppDatesUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lmancild
 * @version 1.0.0
 */
@Service
@Slf4j
public class ProcessServiceImpl implements IProcessService {

	@Autowired
	private IRequestDatesService requestDatesService;
	@Autowired
	private MessageSource messageSource;
	

	@Override
	public ResponseDTO processRequestDate() throws ServicesException, InteropException {
		log.info("INIT :: processRequestDate");
		ExternalResponseDTO responeExternal = getDatesFromGenerator();
		if (log.isDebugEnabled()) 
			log.debug("Response from generation dates services: {}", responeExternal);
		ResponseDTO response = internalProcessMissingDates(responeExternal);
		if (log.isDebugEnabled()) 
			log.debug("Response message: {}", response);
		log.info("END :: processRequestDate");
		return response;
	}

	// ---------------------
	// PRIVATE METHODS
	// ---------------------
	/*
	 * 
	 */
	private ExternalResponseDTO getDatesFromGenerator() throws InteropException {
		if (log.isDebugEnabled()) 
			log.debug("INIT :: getDatesFromGenerator");
		return requestDatesService.requestDatesExternalService();
	}

	/*
	 * 
	 */
	private ResponseDTO internalProcessMissingDates(ExternalResponseDTO responseExternal) throws ServicesException {
		if (log.isDebugEnabled()) 
			log.debug("INIT :: internalProcessMissingDates");
		validateInputData(responseExternal);
		List<String> generatedDates = responseExternal.getFechas();
		String creationDate = responseExternal.getFechaCreacion();
		String endDate = responseExternal.getFechaFin();
		List<String> allDates = insertMissingDates(creationDate, endDate, generatedDates);
		if (log.isDebugEnabled()) 
			log.debug("END :: internalProcessMissingDates");
		return generatedResponse(responseExternal, allDates);
	}

	/*
	 * 
	 */
	private List<String> insertMissingDates(String creationDate, String endDate,
			List<String> generatedDates) {
		if (log.isDebugEnabled()) 
			log.debug("INIT :: insertMissingDates");
		int startYear = Integer.parseInt(creationDate.split("-")[0]);
		int endYear = Integer.parseInt(endDate.split("-")[0]);
		int month = (Integer.parseInt(creationDate.split("-")[1]));
		int endMonthOriginal = Integer.parseInt(endDate.split("-")[1]);
		List<String> datesList = new ArrayList<>();
		for (int index = 0; startYear <= endYear; startYear++, index++) {
			int startMonth = index == 0 ? month : 1;
			if (startMonth > 12)
				continue;
			int endMonth = (startYear == endYear) ? endMonthOriginal : 12;
			generateMonthsForYear(startYear, startMonth, endMonth, datesList, generatedDates);
		}
		if (log.isDebugEnabled()) {
			log.info("Dates: {}", String.join(",", datesList));
			log.debug("END :: insertMissingDates");
		}
		return datesList;
	}

	/*
	 * 
	 */
	private void generateMonthsForYear(Integer year, Integer startMonth,
			Integer endmMonth, List<String> datesList, List<String> generatedDates) {
		if (log.isDebugEnabled()) 
			log.debug("INIT :: generateMonthsForYear");
		for (; startMonth <= endmMonth; startMonth++) {
			String generateDate = AppDatesUtils.generatedEvalDate(year, startMonth);
			if(!generatedDates.contains(generateDate))
				datesList.add(generateDate);
		}
		if (log.isDebugEnabled()) 
			log.debug("END :: generateMonthsForYear");
	}

	/*
	 * 
	 */
	private ResponseDTO generatedResponse(ExternalResponseDTO responseExternal, List<String> dates) {
		if (log.isDebugEnabled()) 
			log.debug("INIT :: generatedResponse");
		ResponseDTO response = new ResponseDTO();
		response.setId(responseExternal.getId());
		response.setFechaCreacion(responseExternal.getFechaCreacion());
		response.setFechaFin(responseExternal.getFechaFin());
		response.setFechas(responseExternal.getFechas());
		response.setFechasFaltantes(dates);
		log.info("Response services: {}", response);
		return response;
	}

	/*
	 * 
	 */
	private void validateInputData(ExternalResponseDTO responseExternal) throws ServicesException {
		if (log.isDebugEnabled()) 
			log.debug("INIT :: validateInputData");
		if(StringUtils.isBlank(responseExternal.getFechaCreacion())) {
			throw new ServicesException(messageSource.getMessage("generator.creation.date.empty", null, null));
		}
		if(StringUtils.isBlank(responseExternal.getFechaFin())) {
			throw new ServicesException(messageSource.getMessage("generator.end.date.empty", null, null));
		}
		if(CollectionUtils.isEmpty(responseExternal.getFechas())) {
			throw new ServicesException(messageSource.getMessage("generator.list.dates.empty", null, null));
		}
	}
}
