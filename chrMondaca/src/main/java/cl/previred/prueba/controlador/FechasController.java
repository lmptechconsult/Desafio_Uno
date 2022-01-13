/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.previred.prueba.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Christian
 */
@Controller
public class FechasController {
    @Autowired
    private FechasServicesImp servicio;
    
    public FechasController(){
        servicio = new FechasServicesImp();
    }
    public String consultarFechas(String url){
        String response = "";
        response = servicio.consultarFechas(url);
        return response;
    } 

}
