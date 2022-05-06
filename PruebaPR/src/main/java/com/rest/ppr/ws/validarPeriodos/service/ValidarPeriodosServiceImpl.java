package com.rest.ppr.ws.validarPeriodos.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.rest.ppr.ws.validarPeriodos.model.RespuestaError;
import com.rest.ppr.ws.validarPeriodos.model.RespuestaValidarPeriodos;
import com.rest.ppr.ws.validarPeriodos.objetos.ArchivoPropiedades;
import com.rest.ppr.ws.validarPeriodos.objetos.ConexionServicio;

/** Clase servicio que implementa los metodos de la interface ValidarPeriodosService
 * @author Rodrigo.Pérez */
@Service
@Configuration
@Scope("prototype")
public class ValidarPeriodosServiceImpl implements ValidarPeriodosService {

    /** Objeto Logger: Se utiliza para activar el registro de logs */
    private static final Logger LOGGER = Logger.getLogger("DesafioPreviRed");
    /** OBjeto String con el nombre de la clase, usado para el log */
    private static final String STRING_CLASE = "[ValidarPeriodosServiceImpl] ";
    /** Archivo de propiedades. */
    private Properties properties;

    @Override
    public String getValidarPeriodos() throws IOException {
        final String nombreMetodo = STRING_CLASE + "[getValidarPeriodos] ";
        LOGGER.debug(nombreMetodo + "Inicia metodo");
        Gson gson = new Gson();
        ClienteWebService cliente = new ClienteWebServiceImpl();
        cargarArchivoPropiedades();
        RespuestaValidarPeriodos respuesta = null;
        RespuestaError error;
        final ConexionServicio conexionServicio = getConexionServicio();
        try {
            String endPoint = conexionServicio.getDireccion() + ":" + conexionServicio.getPuerto() + conexionServicio.getEndpoint();
            final String respuestaSolicitud = cliente.enviarSolicitudGDD(endPoint);
            LOGGER.debug(nombreMetodo + "Respuesta Solicitud: " + respuestaSolicitud);
            if (respuestaSolicitud != null) {
                respuesta = gson.fromJson(respuestaSolicitud, RespuestaValidarPeriodos.class);
                LOGGER.debug(nombreMetodo + "Cantidad de fechas Generadas: " + respuesta.getFechas().size());
                LocalDate fechaInicio = LocalDate.parse(respuesta.getFechaCreacion());
                LocalDate fechaFin = LocalDate.parse(respuesta.getFechaFin());
                LOGGER.debug(nombreMetodo + "Rango entre: Fecha Inicio: " + fechaInicio + " - Fecha Fin: " + fechaFin);
                List<String> fechasFaltantes = new ArrayList<>();
                for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusMonths(1)) {
                    fechasFaltantes.add(date.toString());
                }
                LOGGER.debug(nombreMetodo + "Se calcularon un total de " + fechasFaltantes.size() + " fechas.");
                for (String fecha : respuesta.getFechas()) {
                    if (fechasFaltantes.contains(fecha)) {
                        fechasFaltantes.remove(fecha);
                    }
                }
                LOGGER.debug(nombreMetodo + "Cantidad de fechas Faltantes: " + fechasFaltantes.size() + " fechas.");
                respuesta.setFechasFaltantes(fechasFaltantes);
                crearArchivo(respuesta);
            }

        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            error = new RespuestaError(508, e.getMessage());
            return gson.toJson(error);
        }
        LOGGER.debug(nombreMetodo + "Fin metodo. Se genera respuesta.");
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

    /** Metodo privado que genera un archivo .yml y .json
     * @param RespuestaValidarPeriodos objeto */
    private void crearArchivo(RespuestaValidarPeriodos respuestaValidarPeriodos) throws Exception {
        final String nombreMetodo = STRING_CLASE + "[crearYmlGenerado] ";
        LOGGER.debug(nombreMetodo + "inicia metodo");
        StringBuilder strYml = new StringBuilder();
        byte[] ymlAsBytes = null;
        File archivoYml = null;
        File archivoJson = null;
        String nombreArchivoYml;
        String nombreArchivoJson;
        Gson gson = new Gson();

        try {
            if (respuestaValidarPeriodos != null) {

                strYml.append("- ID: " + respuestaValidarPeriodos.getId() + "\n");
                strYml.append("- Fecha Creación: " + respuestaValidarPeriodos.getFechaCreacion() + "\n");
                strYml.append("- Fecha Fin: " + respuestaValidarPeriodos.getFechaFin() + "\n");

                strYml.append("- Fechas: " + "\n");
                for (int i = 0; i < respuestaValidarPeriodos.getFechas().size(); i++) {
                    strYml.append("        " + respuestaValidarPeriodos.getFechas().get(i) + "\n");
                }
                strYml.append("- Fechas Faltantes: " + "\n");
                for (int i = 0; i < respuestaValidarPeriodos.getFechasFaltantes().size(); i++) {
                    strYml.append("                    " + respuestaValidarPeriodos.getFechasFaltantes().get(i) + "\n");
                }
                String strArchivoYml = URLDecoder.decode(strYml.toString(), "UTF-8");
                ymlAsBytes = (byte[]) strArchivoYml.getBytes();

                nombreArchivoYml = "respuestaValidarPeriodos.yml";
                archivoYml = new File(nombreArchivoYml);
                FileOutputStream fileOutPutStreamYml = new FileOutputStream(archivoYml);
                fileOutPutStreamYml.write(ymlAsBytes);
                fileOutPutStreamYml.close();

                nombreArchivoJson = "respuestaValidarPeriodos.json";
                archivoJson = new File(nombreArchivoJson);
                FileOutputStream fileOutPutStreamJson = new FileOutputStream(archivoJson);
                fileOutPutStreamJson.write(gson.toJson(respuestaValidarPeriodos).getBytes());
                fileOutPutStreamJson.close();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
