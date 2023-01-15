package com.example.desafio.service;

import com.example.desafio.entities.GeneradorDeDatosResponse;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ConsultaGeneradorDeDatosServiceImpl implements ConsultaGeneradorDeDatosService {

    @Override
    public GeneradorDeDatosResponse consultaGDD() throws ParseException {

        GeneradorDeDatosResponse auxResponse = getData();
        GeneradorDeDatosResponse response = new GeneradorDeDatosResponse();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicioTramo = LocalDate.parse(auxResponse.getFechaCreacion(), formatter);
        LocalDate fechaTerminoTramo =  LocalDate.parse(auxResponse.getFechaFin(), formatter);
        ArrayList<String> missingDatesList = generateDateList(fechaInicioTramo, fechaTerminoTramo, auxResponse.getFechas());
        response.setId(auxResponse.getId());
        response.setFechaCreacion(auxResponse.getFechaCreacion());
        response.setFechaFin(auxResponse.getFechaFin());
        response.setFechas(missingDatesList);

        return response;
    }

    private GeneradorDeDatosResponse getData(){

        String url = "http://127.0.0.1:8080/periodos/api";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> rawReaponse = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, String.class);
        System.out.println("Response: " + rawReaponse);

        Gson gson = new Gson();
        GeneradorDeDatosResponse response = gson.fromJson(rawReaponse.getBody(),GeneradorDeDatosResponse.class);


        return response;
    }

    private ArrayList<String> generateDateList(LocalDate fechaInicio, LocalDate fechaTermino, ArrayList<String> fechas){

        boolean llave=true;

        ArrayList<String> fechasResponse = new ArrayList<String>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while(llave){
            fechaInicio = fechaInicio.plusMonths(1);

            if(fechaInicio == fechaTermino){
                llave=false;
            }

            if(!fechas.contains(fechaInicio.toString())){
                if(fechaInicio.getDayOfMonth()==01){
                    fechasResponse.add(fechaInicio.format(formatter));
                }

                if (fechasResponse.stream().count()==100){
                    break;
                }
            }
        }
        return fechasResponse;
    }
}
