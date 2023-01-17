package cl.previred.ms.dates.service;

import cl.previred.ms.dates.domain.GDDResponse;
import cl.previred.ms.dates.domain.MissingDatesDto;
import cl.previred.ms.dates.facade.GDDService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franklin Conde / franklinpqn@gmail.com
 */
@Service
@RequiredArgsConstructor
public class GDDServiceImpl implements GDDService {

    private static final Logger logger = LoggerFactory.getLogger(GDDServiceImpl.class.getSimpleName());

    @Override
    public MissingDatesDto findMissingDates() {
        logger.info("Get missing dates in the implementation");
        RestTemplate restTemplate = new RestTemplate();
        String missingDateUrl = "http://localhost:8080/periodos/api";
        GDDResponse response = restTemplate.getForEntity(missingDateUrl, GDDResponse.class).getBody();
        MissingDatesDto missingDatesDto = new MissingDatesDto();
        missingDatesDto.setId(response.getId());
        missingDatesDto.setCreationDate(response.getFechaCreacion());
        missingDatesDto.setFinalDate(response.getFechaFin());
        missingDatesDto.setDates(response.getFechas());

        LocalDate startDate = LocalDate.of(response.getFechaCreacion().getYear(), response.getFechaCreacion().getMonthValue(), response.getFechaCreacion().getDayOfMonth());
        LocalDate endDate = LocalDate.of(response.getFechaFin().getYear(), response.getFechaFin().getMonthValue(), response.getFechaFin().getDayOfMonth());

        List<LocalDate> generatedDates = response.getFechas();
        List<LocalDate> missingDates = new ArrayList<>();

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusMonths(1)) {
            if (!generatedDates.contains(date.withDayOfMonth(1))) {
                missingDates.add(date.withDayOfMonth(1));
            }
        }

        missingDatesDto.setMissingDates(missingDates);

        return missingDatesDto;
    }

}