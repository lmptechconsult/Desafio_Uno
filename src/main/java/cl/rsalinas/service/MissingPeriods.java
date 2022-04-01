package cl.rsalinas.service;

import cl.rsalinas.model.Query;
import cl.rsalinas.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MissingPeriods {
    Logger log = LoggerFactory.getLogger(MissingPeriods.class);

    public Response setLostPeriods(Query query) {

        log.info("Periodos API Request: "+query.toString());

        Response resp = new Response();
        resp.setId(query.getId());
        resp.setCreationDate(query.getCreationDate());
        resp.setEndDate(query.getEndDate());
        resp.setDates(query.getDates().stream()
                .sorted()
                .collect(Collectors.toList()));

        long numOfDays = ChronoUnit.DAYS.between(query.getCreationDate(), query.getEndDate());
        List<LocalDate> listaTotal = Stream.iterate(query.getCreationDate(), date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());

        Set<LocalDate> totalDates = new HashSet();
        for (LocalDate localDate : listaTotal) {
            totalDates.add(LocalDate.of(localDate.getYear()
                    , localDate.getMonthValue()
                    , localDate.getDayOfMonth()));
        }

        Set<LocalDate> listLostDates = new HashSet();
        listLostDates.stream().sorted()
                .collect(Collectors.toList());
        for (LocalDate localDate : totalDates) {
            if(!query.getDates().contains(localDate))
                if(localDate.getDayOfMonth()==1)
                    listLostDates.add(localDate);
        }

        resp.setLostDates(listLostDates.stream().sorted()
                .collect(Collectors.toList()));

        List<LocalDate> fullPeriod = Stream.concat(query.getDates().stream(), listLostDates.stream()).collect(Collectors.toList());

        resp.setFullPeriod(fullPeriod.stream().sorted()
                .collect(Collectors.toList()));


        log.info("Periodos API Request: "+resp.toString());

        return resp;
    }
}
