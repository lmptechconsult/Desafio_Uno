package com.camilonavarrete.previred.fechasperdidas.service;

import com.camilonavarrete.previred.fechasperdidas.model.FechasProcesadas;
import com.camilonavarrete.previred.fechasperdidas.model.FechasServicio;
import com.camilonavarrete.previred.fechasperdidas.repository.FechasPerdidasDAO;
import org.joda.time.Months;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;



@Service
public class FechasPerdidasServiceImpl implements FechasPerdidasService{


    private final FechasPerdidasDAO fechasPerdidasDAO;
    Logger logger = LoggerFactory.getLogger(FechasPerdidasServiceImpl.class);

    @Autowired
    public FechasPerdidasServiceImpl(FechasPerdidasDAO fechasPerdidasDAO) {
        this.fechasPerdidasDAO = fechasPerdidasDAO;
    }

    /** Este metodo se encarga de consultar al endpoint del servicio generador de fechas aleatorias
     * para ser procesadas, analizadas y determinar cuales son las fechas perdidas entre los rangos dados.
     * @return Retorna array con las fechas aleatorias generadas por el servicio generador de datos.
     */
    @Override
    public ResponseEntity<FechasProcesadas> consultaFechasServicio() {
        FechasProcesadas fechasPerdidasRecuperadas = new FechasProcesadas();
        ResponseEntity respuestaServicio;
        HttpStatus responseStatus = HttpStatus.SERVICE_UNAVAILABLE;
        FechasServicio fechasRandomServicio = fechasPerdidasDAO.consultarServicio();
           if (null == fechasRandomServicio) {
            return new ResponseEntity<>(fechasPerdidasRecuperadas, responseStatus);
        }
        responseStatus = HttpStatus.OK;
        fechasPerdidasRecuperadas = new FechasProcesadas(fechasRandomServicio);

        this.generaListaPerdidas(fechasPerdidasRecuperadas);
        respuestaServicio = new ResponseEntity<>(fechasPerdidasRecuperadas, responseStatus);
        return respuestaServicio;
    }

    /**
     *
     * @param respuestaServicio array con las fechas random generadas por el servicio generador de datos.
     * @return array las fechas perdidas entre la lista entregada.
     */
    private FechasProcesadas generaListaPerdidas(FechasProcesadas respuestaServicio) {
        List<LocalDate> listaFechas = respuestaServicio.getFechasServicio();
        for (int i = 0; i < listaFechas.size(); i++) {
            int diferenciaMeses = (i >= listaFechas.size() || i + 1 >= listaFechas.size()) ? 0 :
                    Months.monthsBetween(listaFechas.get(i),listaFechas.get(i + 1)).getMonths();
            if (diferenciaMeses > 0)
                respuestaServicio.getFechasProcesadas()
                        .addAll( listarMesesIntermedios(listaFechas.get(i),listaFechas.get(i + 1)));
        }
        return respuestaServicio;
    }


    /**
     *
     * @param fechaInicial Fecha inicial aleatoria determinada por el servicio generador de datos
     * @param fechaFinal Fecha final aleatoria determinada por el servicio generado de datos
     * @return Retorna el listado de fechas acumuladas correspondiente a las fechas intermedias segun fecha inicio y fecha fin.
     */
    private List<LocalDate> listarMesesIntermedios(LocalDate fechaInicial, LocalDate fechaFinal) {
        List<LocalDate> listaFechas = new ArrayList<>();
        while (fechaInicial.isBefore(fechaFinal)) {
            fechaInicial = fechaInicial.plusMonths(1);
            if (!fechaInicial.monthOfYear().equals(fechaFinal.monthOfYear()))
                listaFechas.add(fechaInicial);
        }
        return listaFechas;
    }








}
