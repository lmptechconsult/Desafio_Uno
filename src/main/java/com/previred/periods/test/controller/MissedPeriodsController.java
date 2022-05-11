package com.previred.periods.test.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.previred.periods.test.dto.PeriodDTO;
import com.previred.periods.test.service.IMissedPeriodsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// TODO: Auto-generated Javadoc
/**
 * RestController that gets the missing periods.
 */
@RestController
public class MissedPeriodsController {
	
	/** The missed periods service. */
	@Autowired
	private IMissedPeriodsService missedPeriodsService;
	
    /**
     * Method in charge of delivering a response of the missing periods.
     * @return ResponseEntity<PeriodDTO>
     */
    @ApiOperation(value = "List of missing periods", nickname = "periods", notes = "Challenge previred", response = PeriodDTO.class, tags={ "Missed Periods" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of missing periods",response = PeriodDTO.class),
        @ApiResponse(code = 502, message = "When the external rest API could not be accessed", response = Void.class),
        @ApiResponse(code = 500, message = "When an internal error occurs in the service", response = Void.class) 
    })
	@GetMapping("/third/level")
	public ResponseEntity<PeriodDTO> getMissedPeriods() {
		PeriodDTO response = missedPeriodsService.getMissedPeriods();
		if(Objects.isNull(response)) return new ResponseEntity<>(response,HttpStatus.BAD_GATEWAY);
		if(Objects.isNull(response.getId())) return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}

