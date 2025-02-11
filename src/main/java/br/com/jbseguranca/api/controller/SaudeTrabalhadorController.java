package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.SaudeTrabalhador;
import br.com.jbseguranca.api.services.SaudeTrabalhadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/saudetrabalhador")
@Tag(name = "Saude Trabalhador", description = "2210 - Operações de Acidente de Trabalho")
public class SaudeTrabalhadorController {
	
	@Autowired
	private SaudeTrabalhadorService saudeTrabalhadorService;
	
	
	@Operation(summary = "Criar Saude Trabalhador")
	@PostMapping
	public SaudeTrabalhador createSaudeTrabalhador(SaudeTrabalhador trabalhador) {
		return saudeTrabalhadorService.createSaudeTrabalhadorById(trabalhador);
	}

}
