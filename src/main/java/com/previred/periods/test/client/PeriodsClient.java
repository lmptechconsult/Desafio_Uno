package com.previred.periods.test.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.previred.periods.test.config.MissedPeriodsValuesConfig;
import com.previred.periods.test.dto.PeriodDTO;
// TODO: Auto-generated Javadoc

/**
 * Client that makes http requests to GDD service.
 */
@Component
public class PeriodsClient {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;
	
	/** The missed periods values config. */
	@Autowired
	private MissedPeriodsValuesConfig missedPeriodsValuesConfig;
	
    /**
     * Method that gets a randomly generated list of time periods between two dates delivered from a REST service.
     * @return PeriodDTO
     */
	public PeriodDTO getPeriods() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		try {
			ResponseEntity<PeriodDTO> response = restTemplate.exchange(missedPeriodsValuesConfig.getUrlServiceGdd(), HttpMethod.GET, requestEntity, PeriodDTO.class, "");
			return response.getBody();
		} catch (Exception e) {
			log.error("An error has occurred: {}", e.getMessage());
			return null;
		}

		
	}
}
