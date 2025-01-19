package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.dto.ApiResponse;
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

	@PostMapping("/criar")
	@ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> criarAcidenteTrabalho(@RequestBody AcidenteTrabalho acidenteTrabalho) {
		  try {
	            ApiResponse acidenteCriado = acidenteTrabalhoService.createAcidenteTrabalho(acidenteTrabalho);
	            return ResponseEntity.status(HttpStatus.CREATED).body(acidenteCriado);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	


}
