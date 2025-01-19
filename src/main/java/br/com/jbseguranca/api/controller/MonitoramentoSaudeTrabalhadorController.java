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

@RestController
@RequestMapping("/monitoramento-saude-trabalhador")
public class MonitoramentoSaudeTrabalhadorController {
	
	@Autowired
	private MonitoramentoSaudeTrabalhadorService monitoramentoSaudeTrabalhadorService;

	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ApiResponse monitoramentoSaudeTrabalhador(@RequestBody MonitoramentoSaudeTrabalhador monitoramentoSaudeTrabalhador) {
		return  monitoramentoSaudeTrabalhadorService.createMonitoramentoSaudeTrabalho(monitoramentoSaudeTrabalhador);
	}
}
