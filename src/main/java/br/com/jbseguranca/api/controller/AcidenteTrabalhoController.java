package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.services.AcidenteTrabalhoService;

@RestController
@RequestMapping("/acidentetrabalho")
public class AcidenteTrabalhoController {

	@Autowired
	private AcidenteTrabalhoService acidenteTrabalhoService;
	
	@GetMapping()
    public AcidenteTrabalho getAcidenteTrabalho() {
        return acidenteTrabalhoService.consumirApiAcidenteTrabalho();
    }
	
	@GetMapping("/{id}")
	public AcidenteTrabalho getAcidenteTrabalhoById(@PathVariable String id) {
		return acidenteTrabalhoService.getAcidenteTrabalhoById(id);
	}
	
	@PostMapping
	public AcidenteTrabalho createAcidenteTrabalho(AcidenteTrabalho acidente) {
		return acidenteTrabalhoService.createAcidenteTrabalho(acidente);
	}
	
}
