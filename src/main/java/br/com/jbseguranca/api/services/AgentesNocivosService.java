package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbseguranca.api.domain.AgentesNocivos;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.exception.JbException;

@Service
public class AgentesNocivosService {
	
	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;
	
	@Value("${acidente.trabalho.auth.token}")
	private String apiToken;

	@Value("${acidente.trabalho.auth.cnpj}")
	private String cnpjSh;
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public AgentesNocivosService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public AgentesNocivos consumirApiAgentesNocivos() {
		try {
			return restTemplate.getForObject(apiUrl, AgentesNocivos.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
			throw new JbException("Erro ao consumir a API de Agentes Nocivos.", ex);
		}
		
	}
	
	public AgentesNocivos getAgentesNocivosById(String id) {
		 try {
	            String url = apiUrl + "/" + id;
	            return restTemplate.getForObject(url, AgentesNocivos.class);
	        } catch (RestClientException ex) {
	            ex.printStackTrace();
	            throw new JbException("Erro ao obter o Agentes Nocivos com ID: " );
	        }
	}
	
	public ApiResponse createAgentesNocivos(AgentesNocivos agentesNocivos) {
		 if (apiUrl == null || apiUrl.isEmpty()) {
		        throw new JbException("A URL da API não está configurada.");
		    }

		    try {
		        // Serializando o objeto para JSON
		        ObjectMapper objectMapper = new ObjectMapper();
		        String json = objectMapper.writeValueAsString(agentesNocivos);

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
		        throw new JbException("Erro ao criar Agentes Nocivos: " + ex.getMessage(), ex);
		    } catch (Exception ex) {
		        //log.error("Erro inesperado ao criar Monitoramento da saúde do Trabalhor.", ex);
		        throw new JbException("Erro inesperado ao criar dados de Agentes Nocivos.", ex);
		    }
		
	}
	

}
