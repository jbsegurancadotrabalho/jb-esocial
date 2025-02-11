package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.services.AcidenteTrabalhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/acidentetrabalho")
@Tag(name = "AcidenteTrabalho", description = "S-2210 - Comunicação de Acidente de Trabalho")
public class AcidenteTrabalhoController {

	@Autowired
	private AcidenteTrabalhoService acidenteTrabalhoService;

	@PostMapping("/criar")
	@Operation(summary = "Criar Acidente de Trabalho")
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
