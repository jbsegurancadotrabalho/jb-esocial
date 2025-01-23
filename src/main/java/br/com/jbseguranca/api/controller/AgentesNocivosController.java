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

@RestController
@RequestMapping("/agentes-nocivos")
public class AgentesNocivosController {
	
	@Autowired
	private AgentesNocivosService agentesNocivosService;
	
	@GetMapping()
	public AgentesNocivos getAfastamentoTemporario() {
		return agentesNocivosService.consumirApiAgentesNocivos();
	}
	
	@GetMapping("/{id}")
	public AgentesNocivos getAgentesNocivosById(@PathVariable String id) {
		return agentesNocivosService.getAgentesNocivosById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ApiResponse createAgentesNocivos(@RequestBody AgentesNocivos agentesNocivos) {
		return agentesNocivosService.createAgentesNocivos(agentesNocivos);
	}

}
