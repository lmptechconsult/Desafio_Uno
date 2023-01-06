package com.adolfopena.gdd.services;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adolfopena.gdd.vo.PeriodDTO;
import com.adolfopena.gdd.vo.PeriodVO;
import com.google.gson.Gson;

@Service
public class GddService {

    @Value("${api.gdd.url}")
    private String urlGdd;

    public PeriodDTO getMissingDates() {
        PeriodVO requestVO = this.periods();

        PeriodDTO result = new PeriodDTO();
        result.setId(requestVO.getId());
        result.setFechaCreacion(requestVO.getFechaCreacion());
        result.setFechaFin(requestVO.getFechaFin());
        result.setFechas(requestVO.getFechas());

        List<String> fechasFaltantes = new ArrayList<>();

        LocalDate fechaInicio = LocalDate.parse(result.getFechaCreacion());
        LocalDate fechaFin = LocalDate.parse(result.getFechaFin());

        Stream<LocalDate> monthsBetween = fechaInicio.datesUntil(fechaFin, Period.ofMonths(1));

        monthsBetween.forEach(date -> {
            String fecha = date.toString();
            if (!result.getFechas().contains(fecha) && !result.getFechaCreacion().equals(fecha) && !result.getFechaFin().equals(fecha)) {
                fechasFaltantes.add(date.toString());
            }
        });

        result.setFechasFaltantes(fechasFaltantes);
        return result;
    }

    private PeriodVO periods() {        
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(urlGdd))
                .GET()
                .header("Accept", "application/json")
                .build();

            HttpClient client = HttpClient.newBuilder().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
            Gson gson = new Gson();
            
            PeriodVO period = gson.fromJson(response.body(), PeriodVO.class);
            
            return period;
        
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error request GET periods");
        }

        return null;
    }

}
