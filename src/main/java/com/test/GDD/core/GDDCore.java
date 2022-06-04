package com.test.GDD.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.GDD.model.ScheduleDTO;
import com.test.GDD.model.ScheduleFullResponseDTO;
import com.test.GDD.model.ScheduleResponseDTO;

@Component
public class GDDCore {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");

    public ScheduleDTO DoListRandomDate(String init, String end) throws ParseException{
        try{
            List<String> listDate = new ArrayList<String>();
            int count = 0;
            while(count < 100){
                listDate.add(GenerateRandomDate(init,end));
                count++;
            }
            return new ScheduleDTO(new Random().nextInt(10),init,end,listDate);
        }catch(Exception ex){

        }
        return null;
    }

    public ScheduleResponseDTO DoReadFile() throws ParseException{
        ScheduleResponseDTO response = null;
        try{

            ScheduleDTO scheduleDTO = ReadFile();
            response = new ScheduleResponseDTO(
                new Random().nextInt(10), scheduleDTO.getFechaCreacion(),scheduleDTO.getFechaFin(), ProcessDate(scheduleDTO)
                );

                WriteFile("nombre_archivo_salida",new ObjectMapper().writeValueAsString(response));

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    public ScheduleFullResponseDTO GetScheduleFull(ScheduleDTO scheduleDTO){
        ScheduleFullResponseDTO scheduleFullResponseDTO = null;
        try{
            scheduleFullResponseDTO = new ScheduleFullResponseDTO(
                new Random().nextInt(10), scheduleDTO.getFechaCreacion(),scheduleDTO.getFechaFin(),
                scheduleDTO.getFechas(), ProcessDate(scheduleDTO)

            );

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return scheduleFullResponseDTO;
    }


    public boolean WriteFileTextPlain(){
        boolean isValid = false;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            ScheduleDTO scheduleDTO = objectMapper.readValue(new File("nombre_archivo_entrada"), ScheduleDTO.class);
            String fechaRecibidas = "";
            for(String x : scheduleDTO.getFechas()){
                fechaRecibidas += x + " ";
            }
            fechaRecibidas = fechaRecibidas.trim().replaceAll(" ", ", ");
            ScheduleResponseDTO scheduleResponseDTO = objectMapper.readValue(new File("nombre_archivo_salida"), ScheduleResponseDTO.class);
            String fechaFaltantes = "";
            for(String x : scheduleResponseDTO.getFechasFaltantes()){
                fechaFaltantes += x + " ";
            }
            fechaFaltantes = fechaFaltantes.trim().replaceAll(" ", ", ");
            String out = "fecha creación: " + scheduleResponseDTO.getFechaCreacion() + "\n"
            + "fecha fin: " + scheduleResponseDTO.getFechaFin() + "\n"
            + "fechas recibidas: " + fechaRecibidas + "\n"
            + "fechas faltantes: " + fechaFaltantes + "\n";

            WriteFile("nombre_archivo_salida_textplain", out);
            isValid = true;
        }catch(Exception ex){

        }
        return isValid;
    }

    private String GenerateRandomDate(String init, String end){
        Date randomDate = null;
        try {
            Date dateInit = formatter.parse(init);
            Date dateEnd = formatter.parse(end);

            randomDate = new Date(ThreadLocalRandom.current()
            .nextLong(dateInit.getTime(), dateEnd.getTime()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return formatter.format(randomDate) + "-01";

    }

    private ScheduleDTO ReadFile(){
        ScheduleDTO transform = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            transform = objectMapper.readValue(new File("nombre_archivo_entrada"), ScheduleDTO.class);
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transform;
    }

    private void WriteFile(String Path, String info){

        try {
            FileWriter writer = new FileWriter(Path, false);
            writer.write(info);
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private List<String> ProcessDate(ScheduleDTO scheduleDTO) throws ParseException{
        try{
            List<String> listDate = new ArrayList<String>();
            Calendar calendar_init = Calendar.getInstance();
            calendar_init.setTime(formatter.parse(scheduleDTO.getFechaCreacion()));

            Calendar calendar_end = Calendar.getInstance();
            calendar_end.setTime(formatter.parse(scheduleDTO.getFechaFin()));

            Date currentDate = calendar_init.getTime();
            while(!currentDate.equals(calendar_end.getTime())){
                calendar_init.add(Calendar.MONTH, 1);
                currentDate = calendar_init.getTime();
                String finalDate = formatter.format(currentDate) + "-01";
                if(!scheduleDTO.getFechas().stream().anyMatch(s -> s.equals(finalDate))){
                    listDate.add(finalDate);
                }
            }
            return listDate;
        }catch(Exception ex){

            ex.printStackTrace();
        }
        return null;
    }
}
