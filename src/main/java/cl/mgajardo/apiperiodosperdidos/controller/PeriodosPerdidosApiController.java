package cl.mgajardo.apiperiodosperdidos.controller;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import cl.mgajardo.apiperiodosperdidos.service.IPeriodosPerdidosService;
import cl.mgajardo.apiperiodosperdidos.util.FullDatesList;
import cl.mgajardo.apiperiodosperdidos.viewmodel.Periodo;
import cl.mgajardo.apiperiodosperdidos.viewmodel.PeriodoPerdido;

@Controller
public class PeriodosPerdidosApiController implements PeriodosPerdidosApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

	@Autowired
	IPeriodosPerdidosService service;
	
	@Autowired
	public PeriodosPerdidosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}
	
	@Value("${url.api.gdd}")
	private String urlapigdd;
	
	@Override
	public ResponseEntity<PeriodoPerdido> periodosPerdidos() {
		Periodo periodo = service.getPeriodos(urlapigdd);
		PeriodoPerdido retornoPeriodo;
		LocalDate fechaCreacion;
        LocalDate fechaFin;
        List<LocalDate> fechas;
        List<LocalDate> fechasFaltantes;
        FullDatesList fullDates = null;
        if (null != periodo.getFechaCreacion() 
        		&& null != periodo.getFechaFin()
        		&& null != periodo.getFechas()) {
        	fechaCreacion = periodo.getFechaCreacion();
        	fechaFin = periodo.getFechaFin();
        	fechas = periodo.getFechas();
        	fullDates = new FullDatesList(fechaCreacion,fechaFin,
        			fechas);
        } else {
        	log.error("Error al obtener las fechas del rango.");
        }
        //Se obtienen las fechas faltantes
        fechasFaltantes = fullDates.executeFilter();
        retornoPeriodo = new PeriodoPerdido();
        retornoPeriodo.setId(periodo.getId());
        retornoPeriodo.setFechaCreacion(periodo.getFechaCreacion());
        retornoPeriodo.setFechaFin(periodo.getFechaFin());
        retornoPeriodo.setFechas(periodo.getFechas());
        retornoPeriodo.setFechasFaltantes(fechasFaltantes);
        return new ResponseEntity<PeriodoPerdido>(retornoPeriodo, HttpStatus.OK);
	}
}