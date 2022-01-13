/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.previred.prueba.controlador;
import cl.previred.prueba.model.Fechas;
import cl.previred.prueba.model.FechasFaltantes;
import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.Gson;
/**
 *
 * @author Christian
 */
@Service
public class FechasServicesImp implements IFechasServices{

    @Override
    public String consultarFechas(String url) {
     String response = "";
     try{
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder request = target.request();
        request.header("Accept", "application/json");

        Response get = request.get();
        switch (get.getStatus()) {
            case 200:
                response = ordenar(get);
                break;
            default:
                response = null;
                break; 
        }
         
     }catch(Exception e){
         response = e.toString();
     }
        return response;
    
    }
    
    public String ordenar(Response get){
        String response = "";
        FechasFaltantes fechaFaltante = new FechasFaltantes();
        
        String responseJson = get.readEntity(String.class);
        Fechas fechas = new Gson().fromJson(responseJson, Fechas.class);
        LocalDate fechaCreacion = LocalDate.parse(fechas.getFechaCreacion());
        LocalDate fechaFin = LocalDate.parse(fechas.getFechaFin());
        fechaFaltante.setId(fechas.getId());
        fechaFaltante.setFechaCreacion(fechaCreacion.toString());
        fechaFaltante.setFechaFin(fechaFin.toString());
        

        List<String> listaFechas = new ArrayList<>();
        for(int i = 0 ; i < fechas.getFechas().size(); i++){
            LocalDate fechaDate = LocalDate.parse(String.valueOf(fechas.getFechas().get(i)));
            listaFechas.add(fechaDate.toString());
        }
        listaFechas.stream().sorted();
        fechaFaltante.setFechas(listaFechas);
        
        LocalDate startDate = LocalDate.parse(fechas.getFechaCreacion()).withDayOfMonth(1);
        LocalDate endDate = LocalDate.parse(fechas.getFechaFin()).withDayOfMonth(1);

        List<String> listaFechasFaltantes = new ArrayList<>();
        while (!startDate.isAfter(endDate)) {
            listaFechasFaltantes.add(startDate.toString());
            startDate = startDate.plusMonths(1);

        }
        listaFechasFaltantes.removeIf(x -> listaFechas.contains(x));
        fechaFaltante.setFechasFaltantes(listaFechasFaltantes);
        
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        response = gson.toJson(fechaFaltante);
            
        return response;
    }
    
}
