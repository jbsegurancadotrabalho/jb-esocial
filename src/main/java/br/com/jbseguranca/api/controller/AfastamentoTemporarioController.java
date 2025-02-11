package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.AfastamentoTemporario;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.services.AfastamentoTemporarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/afastamentotemporario")
@Tag(name = "Afastamento Temporario", description = "2230 - Afastamento Temporario")
public class AfastamentoTemporarioController {
	
	@Autowired
	private AfastamentoTemporarioService afastamentoTemporarioService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary = "Criar Afastamento Temporario")
	public ApiResponse createAfastamentoTemporario(@RequestBody AfastamentoTemporario afastamento) {
		return afastamentoTemporarioService.createAfastamentoTemporario(afastamento);
	}

}
