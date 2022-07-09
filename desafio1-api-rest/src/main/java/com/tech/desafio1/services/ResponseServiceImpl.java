package com.tech.desafio1.services;

import com.tech.desafio1.model.Periodo;
import com.tech.desafio1.model.ResponseFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ResponseServiceImpl implements ResponseService{

    @Autowired
    private RestTemplate clientRest = new RestTemplate();

    public ResponseFinal responseService() {

        Periodo payload = clientRest.getForObject("http://127.0.0.1:8080/periodos/api", Periodo.class);

        List<LocalDate> fechasIngresadas = payload.getFechas();
        List<LocalDate> fechasOrdenadas = new ArrayList<>();
        List<LocalDate> fechasFaltantes = new ArrayList<>();

        LocalDate fechaInicio = payload.getFechaCreacion();
        LocalDate fechaFin = payload.getFechaFin();


        int minYear = fechaInicio.getYear();
        int maxYear = fechaFin.getYear();
        int minMonth = fechaInicio.getMonthValue();
        int maxMonth = fechaFin.getMonthValue();


        String dateString = null;

        for (int x = minYear; x <= maxYear; x++){

            if(x == minYear){
                for (int y = minMonth; y <= 12 ; y++){
                    if(y >= 10 &&  y <= 12){
                        dateString = x + "-" + y + "-01";
                    }else{
                        dateString = x + "-0" + y + "-01";
                    }
                    LocalDate dateGen = LocalDate.parse(dateString);
                    fechasOrdenadas.add(dateGen);
                }
                x++;
            }

            if (x == maxYear){

                for (int y = 1; y <= maxMonth ; y++){
                    if(y >= 10 && y <= 12){
                        dateString = x + "-" + y + "-01";
                    }else{
                        dateString = x + "-0" + y + "-01";
                    }
                    LocalDate dateGen = LocalDate.parse(dateString);
                    fechasOrdenadas.add(dateGen);
                }

            }else{

                for (int y = 1; y <= 12 ; y++){
                    if(y >= 10 && y <= 12){
                        dateString = x + "-" + y + "-01";
                    }else{
                        dateString = x + "-0" + y + "-01";
                    }

                    LocalDate dateGen = LocalDate.parse(dateString);
                    fechasOrdenadas.add(dateGen);
                }
            }
        }

        fechasFaltantes = fechasOrdenadas;

        fechasFaltantes.removeAll(fechasIngresadas);

        return new ResponseFinal(payload , fechasFaltantes);
    }


}
