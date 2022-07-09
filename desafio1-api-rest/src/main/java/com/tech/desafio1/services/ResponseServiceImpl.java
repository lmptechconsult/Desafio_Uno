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

        Periodo currentPeriodo = clientRest.getForObject("http://127.0.0.1:8080/periodos/api", Periodo.class);

        return buildResponseFinal(currentPeriodo);
    }

    private ResponseFinal buildResponseFinal(Periodo currentPeriodo){
        List<LocalDate> fechasIngresadas = currentPeriodo.getFechas();
        List<LocalDate> fechasOrdenadas = new ArrayList<>();
        List<LocalDate> fechasFaltantes = new ArrayList<>();

        LocalDate fechaInicio = currentPeriodo.getFechaCreacion();
        LocalDate fechaFin = currentPeriodo.getFechaFin();

        fechasOrdenadas = ordenarFechas(fechaInicio,fechaFin);

        fechasFaltantes = fechasOrdenadas;

        fechasFaltantes.removeAll(fechasIngresadas);

        return new ResponseFinal(currentPeriodo, fechasFaltantes);
    }

    private List<LocalDate> ordenarFechas(LocalDate fechaInicio, LocalDate fechaFinal){

        List<LocalDate> fechasOrdenadas = new ArrayList<>();

        int minYear = fechaInicio.getYear();
        int maxYear = fechaFinal.getYear();
        int minMonth = fechaInicio.getMonthValue();
        int maxMonth = fechaFinal.getMonthValue();


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

        return fechasOrdenadas;
    }


}
