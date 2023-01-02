package com.previred.periodos.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.previred.periodos.model.Periodo;
import com.previred.periodos.service.PeriodosService;
import com.previred.periodos.tools.Respuesta;


@RestController
@RequestMapping("/periodos-api/v1/")
public class RestApiController {

  @Autowired
  PeriodosService periodosService;

  @PostMapping("/periodos")
    public ResponseEntity<?> getPeriodos(@RequestBody Periodo periodo) {
      Respuesta response = periodosService.getFechasFaltantes(periodo);
      if (response.getCode()==1) return new ResponseEntity<>(response.getPeriodo(), HttpStatus.OK);
      if (response.getCode()==0) return new ResponseEntity<>(response.toString(), HttpStatus.NOT_ACCEPTABLE);
      if (response.getCode()==-1) return new ResponseEntity<>(response.toString(), HttpStatus.BAD_REQUEST);
        return null;
    }
    
}
