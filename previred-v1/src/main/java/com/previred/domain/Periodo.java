package com.previred.domain;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Periodo {
	
	  private Long id;
	  private String fechaCreacion;
	  private String fechaFin;
	  private List<String> fechas;
	  private List<String> fechasFaltantes;

}
