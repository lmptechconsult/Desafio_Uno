package cl.previred.desafio.model.services;

import cl.previred.desafio.model.entities.Periods;

/**
 * @author franciscoperez
 *@
 */
public interface IPeriodService {

	public Periods findAllMissingDates();
	
}
