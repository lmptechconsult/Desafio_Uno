package com.previred.app.date.service.external;

import com.previred.app.date.dto.ExternalResponseDTO;
import com.previred.app.date.exception.InteropException;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
public interface IRequestDatesService {

	/**
	 * Servicio que consulta a un servicio externo las fechas disponibles
	 * @return
	 * @throws InteropException
	 * @version 1.0.0
	 */
	public ExternalResponseDTO requestDatesExternalService() throws InteropException;
}
