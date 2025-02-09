package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbseguranca.api.domain.AfastamentoTemporario;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.exception.JbException;

@Service
public class AfastamentoTemporarioService {
	
	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;
	
	@Value("${tecnospeed.auth.token}")
	private String apiToken;

	@Value("${tecnospeed.auth.cnpj}")
	private String cnpjSh;
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public AfastamentoTemporarioService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public AfastamentoTemporario consumirApiAfastamentoTrabalho() {
		try {
			return restTemplate.getForObject(apiUrl, AfastamentoTemporario.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
			throw new JbException("Erro ao consumir a API de Afastamento temporário.", ex);
		}
	}

	public AfastamentoTemporario getAfastamentoTemporarioById(String id) {
		 try {
	            String url = apiUrl + "/" + id;
	            return restTemplate.getForObject(url, AfastamentoTemporario.class);
	        } catch (RestClientException ex) {
	            ex.printStackTrace();
	            throw new JbException("Erro ao obter o Afastamento de Trabalho com ID: " );
	        }
	}

	
	public ApiResponse createAfastamentoTemporario(AfastamentoTemporario afastamentoTemporario) {
	    if (apiUrl == null || apiUrl.isEmpty()) {
	        throw new JbException("A URL da API não está configurada.");
	    }

	    try {
	        // Serializando o objeto para JSON
	        ObjectMapper objectMapper = new ObjectMapper();
	        String json = objectMapper.writeValueAsString(afastamentoTemporario);

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

