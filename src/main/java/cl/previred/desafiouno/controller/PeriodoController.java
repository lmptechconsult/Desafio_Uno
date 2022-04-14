package cl.previred.desafiouno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cl.previred.desafiouno.service.PeriodoService;

@RestController
@RequestMapping("/periodo") 
public class PeriodoController {

	@Autowired
	private PeriodoService periodoService;

	@GetMapping("/periodo")
	public String getPeriodos(@RequestParam String fechainicio, @RequestParam String fechafin) {
		String json = new Gson().toJson(periodoService.getPeriodos(fechainicio, fechafin));
		return json;
	}

}
