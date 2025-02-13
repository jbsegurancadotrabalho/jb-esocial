package br.com.jbseguranca.api.services;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.domain.S2210Item;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.exception.JbException;
import br.com.jbseguranca.api.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AcidenteTrabalhoService {


	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;
	
	@Value("${endereco.tecnospeed.url.consulta}")
	private String apiUrlConsultar;

	@Value("${tecnospeed.auth.token}")
	private String apiToken;

	@Value("${tecnospeed.auth.cnpj}")
	private String cnpjSh;
	
	@Value("${tecnospeed.auth.empregador}")
	private String empregador;

	private final RestTemplate restTemplate;
	

	public AcidenteTrabalhoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	

	public ApiResponse createAcidenteTrabalho(AcidenteTrabalho acidenteTrabalho) {
		if (apiUrl == null || apiUrl.isEmpty()) {
			throw new JbException("A URL da API não está configurada.");
		}

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(acidenteTrabalho);

			ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, json, String.class);

			if (response.getStatusCode().is2xxSuccessful()) {
				log.info("Lote Recebido com Sucesso.", response.getBody());
				ApiResponse apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
				objectMapper.readValue(response.getBody(), ApiResponse.class);
				return apiResponse;
			} else {
				throw new JbException("Erro na API: Código " + response.getStatusCodeValue());
			}
		} catch (HttpClientErrorException ex) {
			log.error("Erro ao criar Acidente de Trabalho: {}", ex.getResponseBodyAsString());
			throw new JbException("Erro ao criar Acidente de Trabalho: " + ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("Erro inesperado ao criar Acidente de Trabalho.", ex);
			throw new JbException("Erro inesperado ao criar Acidente de Trabalho.", ex);
		}
	}
}
	

