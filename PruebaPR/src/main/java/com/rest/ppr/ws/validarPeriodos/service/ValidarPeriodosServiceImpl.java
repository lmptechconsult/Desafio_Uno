package com.rest.ppr.ws.validarPeriodos.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.rest.ppr.ws.validarPeriodos.model.RespuestaPeriodos;
import com.rest.ppr.ws.validarPeriodos.model.RespuestaValidarPeriodos;
import com.rest.ppr.ws.validarPeriodos.objetos.ArchivoPropiedades;
import com.rest.ppr.ws.validarPeriodos.objetos.ConexionServicio;

/** Clase servicio que implementa los metodos de la interface ValidarPeriodosService, que interactua con la capa de datos ValidarPeriodosDao.
 * @author Rodrigo.Pérez */
@Service
@Configuration
@Scope("prototype")
public class ValidarPeriodosServiceImpl implements ValidarPeriodosService {

    /** Objeto Logger: Se utiliza para activar el registro de logs */
    private static final Logger LOGGER = Logger.getLogger("PruebaPR");
    /** OBjeto String con el nombre de la clase, usado para el log */
    private static final String STRING_CLASE = "[ValidarPeriodosServiceImpl] ";
    /** Archivo de propiedades. */
    private Properties properties;

    @Override
    public String getValidarPeriodos() throws IOException {
        final String nombreMetodo = STRING_CLASE + "[getValidarPeriodos] ";
        Gson gson = new Gson();
        ClienteWebService cliente = new ClienteWebServiceImpl();
        cargarArchivoPropiedades();
        RespuestaPeriodos resultado = null;
        RespuestaValidarPeriodos respuesta = null;
        final ConexionServicio conexionServicio = getConexionServicio();
        String endPoint = conexionServicio.getDireccion() + ":" + conexionServicio.getPuerto() + conexionServicio.getEndpoint();
        final String respuestaSolicitud = cliente.enviarSolicitudGDD(endPoint);
        LOGGER.debug(nombreMetodo + "respuestaSolicitud: " + respuestaSolicitud);
        if (respuestaSolicitud != null) {
            resultado = gson.fromJson(respuestaSolicitud, RespuestaPeriodos.class);
            LOGGER.debug(nombreMetodo + "Cantidad de fechas: " + resultado.getFechas().size());
            LocalDate fechaInicio = LocalDate.parse(resultado.getFechaCreacion());
            LocalDate fechaFin = LocalDate.parse(resultado.getFechaFin());
            LOGGER.debug(nombreMetodo + "Fecha Inicio: " + fechaInicio + " - Fecha Fin: " + fechaFin);
            List<String> fechasFaltantes = new ArrayList<>();
            for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusMonths(1)) {
                fechasFaltantes.add(date.toString());
            }
            LOGGER.debug(nombreMetodo + "Se calcularon un total de " + fechasFaltantes.size() + " fechas.");
            for (String fecha : resultado.getFechas()) {
                if (fechasFaltantes.contains(fecha)) {
                    fechasFaltantes.remove(fecha);
                }
            }
            respuesta = new RespuestaValidarPeriodos();
            LOGGER.debug(nombreMetodo + "Faltaron " + fechasFaltantes.size() + " fechas.");
            respuesta.setRespuestaPeriodos(resultado);
            respuesta.setFechasFaltantes(fechasFaltantes);
        }

        return gson.toJson(respuesta);
    }

    /** Metodo que permite cargar el archivo de propiedades. */
    private void cargarArchivoPropiedades() {
        ArchivoPropiedades archivo = new ArchivoPropiedades();
        properties = archivo.cargarArchivoPropiedades();
    }

    /** Metodo para obtener la direccion de conexion al servicio.
     * @return ConexionServicio. */
    private ConexionServicio getConexionServicio() {
        final ConexionServicio conexionServ = new ConexionServicio();
        conexionServ.setDireccion(properties.getProperty("direccion"));
        conexionServ.setPuerto(properties.getProperty("puerto"));
        conexionServ.setEndpoint(properties.getProperty("endPoint"));
        return conexionServ;
    }
}
