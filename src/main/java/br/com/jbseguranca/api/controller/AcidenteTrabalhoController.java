package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

	@PostMapping("/criar")
    public ResponseEntity<String> criarAcidenteTrabalho(@RequestBody AcidenteTrabalho acidenteTrabalho) {
	    
		  try {
	            // Chama o serviço para criar o acidente de trabalho
	            String acidenteCriado = acidenteTrabalhoService.createAcidenteTrabalho(acidenteTrabalho);

	            // Retorna uma resposta de sucesso com o objeto criado
	            return ResponseEntity.status(HttpStatus.CREATED).body(acidenteCriado);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: " + e.getMessage());
	        } catch (Exception e) {
	            // Se houver outros erros
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: " + e.getMessage());
	        }
	    }
	


}
