package br.com.jbseguranca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbseguranca.api.domain.Empregador;
import br.com.jbseguranca.api.dto.response.ConsultaEmpregadorDto;
import br.com.jbseguranca.api.dto.response.EmpregadorDto;
import br.com.jbseguranca.api.services.EmpregadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cadastrar-empregador")
@Tag(name = "CadastrarEmpregador", description = "Cadastro de empregador")
public class EmpregadorController {
	
	@Autowired
	private EmpregadorService empregadorService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary = "Cadastrar Empregador")
	public EmpregadorDto cadastroDeEmpregador(@RequestBody Empregador empregador) {
		return empregadorService.cadastrarEmpregador(empregador);
		
	}
	
	@GetMapping("/{cpfOuCnpj}")	
	@Operation(summary = "Consultar Empregador Cadastrado")
	public ConsultaEmpregadorDto getEmpregadorByCpfCnpj(@PathVariable String cpfOuCnpj) {
		return empregadorService.ConsultarEmpregadorPorCpfOuCnpj(cpfOuCnpj);
	}

}
