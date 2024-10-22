package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.services.AcidenteTrabalhoService;

@RestController
@RequestMapping("/acidentetrabalho")
public class AcidenteTrabalhoController {

	@Autowired
	private AcidenteTrabalhoService acidenteTrabalhoService;
	
//	@GetMapping()
//    public AcidenteTrabalho getAcidenteTrabalho() {
//        return acidenteTrabalhoService.consumirApiAcidenteTrabalho();
//    }
//	
//	@GetMapping("/{id}")
//	public AcidenteTrabalho getAcidenteTrabalhoById(@PathVariable String id) {
//		return acidenteTrabalhoService.getAcidenteTrabalhoById(id);
//	}
	
	 @PostMapping(consumes = "text/tx2", produces = "text/tx2")
	    public ResponseEntity<String> createAcidenteTrabalho(@RequestBody AcidenteTrabalho acidenteTrabalho) {
	        try {
	            acidenteTrabalhoService.createAcidenteTrabalho(acidenteTrabalho);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Acidente de Trabalho criado com sucesso.");
	        } catch (IllegalArgumentException ex) {
	            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
	        } catch (Exception ex) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Erro ao criar Acidente de Trabalho: " + ex.getMessage());
	        }
	    }
	
}
