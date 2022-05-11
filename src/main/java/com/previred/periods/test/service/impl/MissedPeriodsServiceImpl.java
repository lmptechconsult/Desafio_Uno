package com.previred.periods.test.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.previred.periods.test.client.PeriodsClient;
import com.previred.periods.test.dto.PeriodDTO;
import com.previred.periods.test.service.IMissedPeriodsService;

// TODO: Auto-generated Javadoc
/**
 * The Class MissedPeriodsServiceImpl.
 */
@Service
public class MissedPeriodsServiceImpl implements IMissedPeriodsService {
	
	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/** The periods client. */
	@Autowired
	private PeriodsClient periodsClient;
	
    /**
     * Method that obtains a list of randomly generated time periods, to obtain the remaining periods.
     * @return PeriodDTO
     */
	@Override
	public PeriodDTO getMissedPeriods() {
		PeriodDTO periods = periodsClient.getPeriods();
		if(Objects.isNull(periods)) return periods;
		try {
			List<LocalDate> missedsPeriods = 
					Stream
					.iterate(periods.getFechaCreacion(), date -> date.plusMonths(1))
					.limit(ChronoUnit.MONTHS.between(periods.getFechaCreacion(), periods.getFechaFin()) + 1)
					.filter(pm -> !periods.getFechas().contains(pm))
					.collect(Collectors.toList());
			periods.setFechasFaltantes(missedsPeriods);
			return periods;
		} catch (Exception e) {
			log.error("An error has occurred: {}", e.getMessage());
			return new PeriodDTO();
		}
	}

}
