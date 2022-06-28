package cl.mgajardo.apiperiodosperdidos.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.mgajardo.apiperiodosperdidos.viewmodel.ErrorGeneral;
import cl.mgajardo.apiperiodosperdidos.viewmodel.Periodo;
import cl.mgajardo.apiperiodosperdidos.viewmodel.PeriodoPerdido;
import io.swagger.annotations.Api;
//import cl.mgajardo.apiperiodosperdidos.viewmodel.RetornoPeriodos;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "api-periodos-perdidos")
public interface PeriodosPerdidosApi {
	
    Logger log = LoggerFactory.getLogger(PeriodosPerdidosApi.class);


	  @ApiOperation(value = "periodosperdidos", nickname = "periodosperdidos", notes = "", response = PeriodoPerdido.class, tags = {
				"api-periodos-perdidos", })
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "OK - Listas Obtenidas", response = PeriodoPerdido.class),
				@ApiResponse(code = 400, message = "Bad Request", response = ErrorGeneral.class),
				@ApiResponse(code = 401, message = "No Autorizado", response = ErrorGeneral.class),
				@ApiResponse(code = 403, message = "Prohibido", response = ErrorGeneral.class),
				@ApiResponse(code = 404, message = "Not Found", response = ErrorGeneral.class),
				@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorGeneral.class) 
				})
	@RequestMapping(value = "/periodosperdidos", produces = {
	"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<PeriodoPerdido> periodosPerdidos();
}