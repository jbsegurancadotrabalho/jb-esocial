package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.AgentesNocivos;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.services.AgentesNocivosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/agentes-nocivos")
@Tag(name = "AgentesNocivos", description = "S-2240 - Condições Ambientais do Trabalho - Agentes Nocivos")
public class AgentesNocivosController {
	
	@Autowired
	private AgentesNocivosService agentesNocivosService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary = "Criar Agentes Nocivos")
	public ApiResponse createAgentesNocivos(@RequestBody AgentesNocivos agentesNocivos) {
		return agentesNocivosService.createAgentesNocivos(agentesNocivos);
	}

}
