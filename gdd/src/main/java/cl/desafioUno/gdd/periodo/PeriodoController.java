package cl.desafioUno.gdd.periodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * @author Francisco Devaud
 * @date 02/04/2022
 **/
@RestController
@RequestMapping(path = "api/v1/periodo")
public class PeriodoController {

	private final PeriodoService periodoService;

	@Autowired
	public PeriodoController(PeriodoService periodoService) {
		this.periodoService = periodoService;
	}

	@GetMapping("/getPeriodoRandom")
	@ApiOperation(value = "Genera periodos aleatorios", notes = "Genera una lista de periodos aleatorios, con un rango de 10 a 100 fechas", response = Periodo.class)
	public Periodo getPeriodoRandom() {
		return periodoService.getPeriodosAll();
	}

	@PostMapping("/getPeriodosByJson")
	@ApiOperation(value = "Busca periodos faltantes segun JSON de entrada", notes = "Busca los periodos faltantes segun criterios de entradas, "
			+ "la respuesta en formato JSON con las fechas recibidas y las fechas faltantes, maximo 100 respuestas", response = Periodo.class)
	public Periodo getPeriodosByJson(@RequestBody Periodo periodo) {
		return periodoService.getPeriodosJSON(periodo);
	}

}
