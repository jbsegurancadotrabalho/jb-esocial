package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbseguranca.api.domain.MonitoramentoSaudeTrabalhador;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.exception.JbException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MonitoramentoSaudeTrabalhadorService {

	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;

	@Value("${tecnospeed.auth.token}")
	private String apiToken;

	@Value("${tecnospeed.auth.cnpj}")
	private String cnpjSh;

	private final RestTemplate restTemplate;
	
	public MonitoramentoSaudeTrabalhadorService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String consumirApiMonitoramentoSaudeTrabalhador() {
		try {
			return restTemplate.getForObject(apiUrl, String.class);
		} catch (Exception ex) {
			throw new JbException("Erro ao consumir a API de Monitoramento de Saude do Trabalhador.", ex);
		}
	}
	
	
	public ApiResponse createMonitoramentoSaudeTrabalho(MonitoramentoSaudeTrabalhador monitoramentoSaudeTrabalhador) {
	    if (apiUrl == null || apiUrl.isEmpty()) {
	        throw new JbException("A URL da API não está configurada.");
	    }

	    try {
	        // Serializando o objeto para JSON
	        ObjectMapper objectMapper = new ObjectMapper();
	        String json = objectMapper.writeValueAsString(monitoramentoSaudeTrabalhador);

	        // Fazendo a requisição POST
	        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, json, String.class);

	        if (response.getStatusCode().is2xxSuccessful()) {
	            // Converte a resposta para o DTO
	        	//log.info("Lote Recebido com Sucesso.", response.getBody());
	            return objectMapper.readValue(response.getBody(), ApiResponse.class);
	        } else {
	            throw new JbException("Erro na API: Código " + response.getStatusCodeValue());
	        }
	    } catch (HttpClientErrorException ex) {
	        //log.error("Erro ao criar Monitoramento da saúde do Trabalhor: {}", ex.getResponseBodyAsString());
	        throw new JbException("Erro ao criar Monitoramento da saúde do Trabalhor: " + ex.getMessage(), ex);
	    } catch (Exception ex) {
	        //log.error("Erro inesperado ao criar Monitoramento da saúde do Trabalhor.", ex);
	        throw new JbException("Erro inesperado ao criar Monitoramento da saúde do Trabalhor.", ex);
	    }
	}

}
