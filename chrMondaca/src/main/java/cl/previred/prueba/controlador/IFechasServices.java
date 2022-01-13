/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.previred.prueba.controlador;

import org.springframework.stereotype.Service;

/**
 *
 * @author Christian
 */
@Service
public interface IFechasServices {
    public String consultarFechas(String url);
}
