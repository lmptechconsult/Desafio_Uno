package com.lmptechconsult.desafio_Uno.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmptechconsult.desafio_Uno.client.ApiPeriodosClient;
import com.lmptechconsult.desafio_Uno.model.Periodos;
import com.lmptechconsult.desafio_Uno.model.PeriodosFaltantes;

public class PeriodosFaltantesServiceImpTest {
    @Mock
    private ApiPeriodosClient apiPeriodosClient;
    
    @InjectMocks
    private PeriodosFaltantesServiceImp periodosFaltantesService;

    private Periodos periodos;
    private PeriodosFaltantes periodosFaltantesEsperado;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        periodos = new Periodos();
        periodos.setId(6);
        periodos.setFechaCreacion(LocalDate.parse("1969-03-01"));
        periodos.setFechaFin(LocalDate.parse("1970-01-01"));
        periodos.setFechas(new ArrayList<>());
        periodos.getFechas().add(LocalDate.parse("1969-03-01"));
        periodos.getFechas().add(LocalDate.parse("1969-05-01"));
        periodos.getFechas().add(LocalDate.parse("1969-09-01"));
        periodos.getFechas().add(LocalDate.parse("1970-01-01"));

        periodosFaltantesEsperado = new PeriodosFaltantes();
        periodosFaltantesEsperado.setId(6);
        periodosFaltantesEsperado.setFechaCreacion(LocalDate.parse("1969-03-01"));
        periodosFaltantesEsperado.setFechaFin(LocalDate.parse("1970-01-01"));
        periodosFaltantesEsperado.setFechasFaltantes(new ArrayList<>());
        periodosFaltantesEsperado.getFechasFaltantes().add(LocalDate.parse("1969-04-01"));
        periodosFaltantesEsperado.getFechasFaltantes().add(LocalDate.parse("1969-06-01"));
        periodosFaltantesEsperado.getFechasFaltantes().add(LocalDate.parse("1969-07-01"));
        periodosFaltantesEsperado.getFechasFaltantes().add(LocalDate.parse("1969-08-01"));
        periodosFaltantesEsperado.getFechasFaltantes().add(LocalDate.parse("1969-10-01"));
        periodosFaltantesEsperado.getFechasFaltantes().add(LocalDate.parse("1969-11-01"));
        periodosFaltantesEsperado.getFechasFaltantes().add(LocalDate.parse("1969-12-01"));
    }

    
    @Test
    void testGetPeriodosFaltantes() {
        when(apiPeriodosClient.getPeriodos()).thenReturn(periodos);
        Periodos periodo = periodosFaltantesService.getPeriodos();
        PeriodosFaltantes periodosFaltante = periodosFaltantesService.getPeriodosFaltantes(periodo);

        assertNotNull(periodosFaltante);
        assertEquals(periodosFaltantesEsperado.getId(), periodosFaltante.getId());
        assertEquals(periodosFaltantesEsperado.getFechaCreacion(), periodosFaltante.getFechaCreacion());
        assertEquals(periodosFaltantesEsperado.getFechaFin(), periodosFaltante.getFechaFin());
        assertEquals(periodosFaltantesEsperado.getFechasFaltantes(), periodosFaltante.getFechasFaltantes());
 
     
    }
 
}
