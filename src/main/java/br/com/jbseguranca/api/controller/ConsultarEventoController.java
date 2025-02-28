package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.dto.response.ApiResponseGet;
import br.com.jbseguranca.api.services.ConsultarEventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/consultar")
@Tag(name = "ConsultarPorLote", description = "Realizar Consulta por Lote")
public class ConsultarEventoController {

	@Autowired
	private ConsultarEventoService consultarEventoService;
	
	
	@GetMapping("/lote/{id}/{versaoManual}/{ambiente}")
	@Operation(summary = "Consultar por Lote")
	public ApiResponseGet getConsultarLoteById(@PathVariable String id, @PathVariable String versaoManual,
			@PathVariable String ambiente) {
		return consultarEventoService.ConsultaEventoPorLoteById(id, versaoManual, ambiente);
	}
}
