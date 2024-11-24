package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping(consumes = "text/tx2")
	public ResponseEntity<?> createAcidenteTrabalho(@RequestBody String tx2Content,
			@RequestHeader("cpfCnpjTransmissor") String cpfCnpjTransmissor,
			@RequestHeader("cpfCnpjEmpregador") String cpfCnpjEmpregador,
			@RequestHeader("idGrupoEventos") String idGrupoEventos, @RequestHeader("versaoManual") String versaoManual,
			@RequestHeader("ambiente") String ambiente) {
		try {
			if (tx2Content == null || tx2Content.isEmpty()) {
				return ResponseEntity.badRequest().body("Conteúdo TX2 não pode ser vazio.");
			}

			String response = acidenteTrabalhoService.createAcidenteTrabalho(tx2Content, cpfCnpjTransmissor,
					cpfCnpjEmpregador, idGrupoEventos, versaoManual, ambiente);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Erro de validação: " + ex.getMessage());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao criar Acidente de Trabalho: " + ex.getMessage());
		}
	}

}
