package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbseguranca.api.domain.Empregador;
import br.com.jbseguranca.api.dto.response.EmpregadorDto;
import br.com.jbseguranca.api.exception.JbException;

@Service
public class EmpregadorService {

	@Value("${cadastrar.empregador.tecnospeed.api.url}")
	private String apiUrl;

	@Value("${tecnospeed.auth.token}")
	private String apiToken;

	@Value("${tecnospeed.auth.cnpj}")
	private String cnpjSh;

	private final RestTemplate restTemplate;

	public EmpregadorService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Empregador consumirApiEmpregador() {
		try {
			return restTemplate.getForObject(apiUrl, Empregador.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
			throw new JbException("Erro ao consumir a API de para cadastro de empregador.", ex);
		}

	}

	public EmpregadorDto cadastrarEmpregador(Empregador empregador) {
		if (apiUrl == null || apiUrl.isEmpty()) {
			throw new JbException("A URL da API não está configurada.");
		}

		try {
			// Serializando o objeto para JSON
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(empregador);

			// Fazendo a requisição POST
			ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, json, String.class);

			if (response.getStatusCode().is2xxSuccessful()) {
				// Converte a resposta para o DTO
				// log.info("Lote Recebido com Sucesso.", response.getBody());
				return objectMapper.readValue(response.getBody(), EmpregadorDto.class);
			} else {
				throw new JbException("Erro na API: Código " + response.getStatusCodeValue());
			}
		} catch (HttpClientErrorException ex) {
			// log.error("Erro ao criar Monitoramento da saúde do Trabalhor: {}",
			// ex.getResponseBodyAsString());
			throw new JbException("Erro ao criar o empregador: " + ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("Erro inesperado ao criar Monitoramento da saúde do Trabalhor.",
			// ex);
			throw new JbException("Erro inesperado ao criar um empregador.", ex);
		}

	}

}
