package cl.previred.desafio.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.previred.desafio.model.entities.Periods;
import cl.previred.desafio.model.services.PeriodServiceImpl;

/**
 * @author franciscoperez
 */
@RestController
@RequestMapping("/api/v1")
public class ApiController {
	
	private final PeriodServiceImpl periodService;
	
	public ApiController(PeriodServiceImpl periodService) {
		
		this.periodService = periodService;
	}
	
	@GetMapping("/periodos")
	public ResponseEntity<Periods> getMissingDates(){
		
		final Periods missingDates = periodService.findAllMissingDates();
		
		return new ResponseEntity<>(missingDates,HttpStatus.OK);
	}

}
