package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.SaudeTrabalhador;
import br.com.jbseguranca.api.services.SaudeTrabalhadorService;

@RestController
@RequestMapping("/saudetrabalhador")
public class SaudeTrabalhadorController {
	
	@Autowired
	private SaudeTrabalhadorService saudeTrabalhadorService;
	
	@GetMapping()
	public SaudeTrabalhador getSaudeTrabalhador() {
		return saudeTrabalhadorService.consumirApiSaudeTrabalhador();
	}

}
