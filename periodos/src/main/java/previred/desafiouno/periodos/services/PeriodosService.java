package previred.desafiouno.periodos.services;

import previred.desafiouno.periodos.excepciones.FechasFaltantesException;
import previred.desafiouno.periodos.servicios.model.Periodo;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/

public interface PeriodosService {
	
	Periodo faltantes() throws FechasFaltantesException;

}
