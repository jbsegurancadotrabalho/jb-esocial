package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.AfastamentoTemporario;
import br.com.jbseguranca.api.services.AfastamentoTemporarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/afastamentotemporario")
@Tag(name = "Afastamento Temporario", description = "2230 - Operações de Acidente de Trabalho")
public class AfastamentoTemporarioController {
	
	@Autowired
	private AfastamentoTemporarioService afastamentoTemporarioService;
	
	@PostMapping
	@Operation(summary = "Criar Afastamento Temporario")
	public AfastamentoTemporario createAfastamentoTemporario(AfastamentoTemporario afastamento) {
		return afastamentoTemporarioService.createAfastamentoTemporario(afastamento);

	}

}
