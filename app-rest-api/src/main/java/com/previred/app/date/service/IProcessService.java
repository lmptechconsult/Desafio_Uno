package com.previred.app.date.service;

import com.previred.app.date.dto.ResponseDTO;
import com.previred.app.date.exception.InteropException;
import com.previred.app.date.exception.ServicesException;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
public interface IProcessService {

	/**
	 * Servicio que procesa la solicitud de fechas obtenidas desde el generador
	 * @return
	 * @throws ServicesException
	 * @throws InteropException
	 * @version 1.0.0
	 */
	public ResponseDTO processRequestDate() throws ServicesException, InteropException;
}
