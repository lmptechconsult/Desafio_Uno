package cl.previred.desafio.model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.previred.desafio.model.entities.Dates;
import cl.previred.desafio.model.entities.Periods;

/**
 * 
 * @author franciscoperez
 * This service is responsible for making a call to an external api through RestTemplate.
 */
@Service
public class PeriodServiceImpl implements IPeriodService {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PeriodServiceImpl.class);

	@Value("${previred.api.url:http://localhost:8080/periodos/api}")
	private String urlRequest;

	/**
	 * Returns an entity of type "Periods" with the response information from the api and the result 
	 * of the missing dates.
	 */
	@Override
	public Periods findAllMissingDates() {

		final ResponseEntity<Dates> res = restTemplate.getForEntity(urlRequest, Dates.class);
		Periods period = null;

		final Dates reqResult = res.getBody();
		
		if(reqResult == null)
			throw new NullPointerException("The Response body is null");
		
		try {
			List<LocalDate> dates = reqResult.getFechas();
			List<LocalDate> periods = new ArrayList<>();
			LocalDate startDate = reqResult.getFechaCreacion();
			LocalDate endDate = reqResult.getFechaFin();

			while (startDate.isBefore(endDate.minusMonths(1))) {

				final LocalDate finalDate = startDate.plusMonths(1);
				periods.add(finalDate);
				startDate = finalDate;
			}
			periods.removeAll(dates);
			period = new Periods(reqResult, periods);

		} catch (Exception ex) {
			logger.warn(String.format("An error occurred [%s]", ex.getMessage()));
		}

		return period;
	}

}
