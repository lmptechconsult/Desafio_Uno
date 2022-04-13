package previred.desafiouno.periodos.controllers;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import previred.desafiouno.periodos.excepciones.CustomException;
import previred.desafiouno.periodos.excepciones.CustomStatusException;
import previred.desafiouno.periodos.excepciones.FechasFaltantesException;
import previred.desafiouno.periodos.services.PeriodosService;
import previred.desafiouno.periodos.servicios.model.Periodo;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/
@RestController
@RequestMapping(value = "periodos")
public class PeriodosController {
	
	
	@Autowired
	PeriodosService periodosService;
	
	
	@RequestMapping(value = "/faltantes", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public Object faltantes() {
				
		Periodo periodo=null;
		try {
			periodo = periodosService.faltantes();
			return devolverRespuestaCorrectaGET(periodo);
		} catch (FechasFaltantesException e) {
			e.printStackTrace();			
			return devolverRespuestaIncorrecta(new CustomException("E","Hubo un error al intentar obtener las fechas faltantes: "+e.getMessage()));
		}				
		
	}
	
	
	
	
	
	
	///////////////////////PRIVADAS///////////////////////
	private Object devolverRespuestaCorrectaGET(Object o) {
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
	
	public Object devolverRespuestaIncorrecta(Exception e){

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;        
                
        return new ResponseEntity<>(new CustomStatusException(e), httpStatus);
    }

    

}
