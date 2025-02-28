package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.MonitoramentoSaudeTrabalhador;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.services.MonitoramentoSaudeTrabalhadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/monitoramento-saude-trabalhador")
@Tag(name = "MonitoramentoSaudeTrabalhador", description = "S-2220 - Monitoramento da Saúde do Trabalhador")
public class MonitoramentoSaudeTrabalhadorController {
	
	@Autowired
	private MonitoramentoSaudeTrabalhadorService monitoramentoSaudeTrabalhadorService;

	
	@PostMapping
	@Operation(summary = "Criar Monitoramento Saude Trabalhador")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ApiResponse monitoramentoSaudeTrabalhador(@RequestBody MonitoramentoSaudeTrabalhador monitoramentoSaudeTrabalhador) {
		return  monitoramentoSaudeTrabalhadorService.createMonitoramentoSaudeTrabalho(monitoramentoSaudeTrabalhador);
	}
}
