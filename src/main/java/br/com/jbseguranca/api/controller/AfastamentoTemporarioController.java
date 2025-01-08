package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.AfastamentoTemporario;
import br.com.jbseguranca.api.services.AfastamentoTemporarioService;


@RestController
@RequestMapping("/afastamento-temporario")
public class AfastamentoTemporarioController {
	
	@Autowired
	private AfastamentoTemporarioService afastamentoTemporarioService;
	
	@GetMapping()
	public AfastamentoTemporario getAfastamentoTemporario() {
		return afastamentoTemporarioService.consumirApiAfastamentoTrabalho();
	}
	
	@GetMapping("/{id}")
	public AfastamentoTemporario getAfastamentoTemporarioById(@PathVariable String id) {
		return afastamentoTemporarioService.getAfastamentoTemporarioById(id);
	}
	
	public AfastamentoTemporario createAfastamentoTemporario(AfastamentoTemporario afastamento) {
		return afastamentoTemporarioService.createAfastamentoTemporario(afastamento);

	}

}
