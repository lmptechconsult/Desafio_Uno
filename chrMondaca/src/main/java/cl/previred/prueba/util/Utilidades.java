/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.previred.prueba.util;
import org.apache.commons.validator.routines.UrlValidator;
/**
 *
 * @author Christian
 */
public class Utilidades {
    
    public static boolean urlValidator(String url)
    {
        /* Obteniendo UrlValidator */
        UrlValidator defaultValidator = new UrlValidator();
        return defaultValidator.isValid(url);
    }
}
