package cl.prueba.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.prueba.modelos.FechaFaltante;
import cl.prueba.servicios.IFechasServicios;

@RestController
public class InicioController {

	@Autowired
	IFechasServicios serv;
	

	@RequestMapping("/inicio/{entrada}/{salida}")
	public List<FechaFaltante> Home(@PathVariable String entrada,@PathVariable String salida) {
		List<FechaFaltante> respuesta = new ArrayList<FechaFaltante>();
			serv.GeneradorDeDatos(entrada, salida);
			serv.CreateFechasFaltantes(salida, entrada);
			respuesta = serv.ReadFechasFaltantes(salida);
		
		return respuesta;
	}
	
	

}
