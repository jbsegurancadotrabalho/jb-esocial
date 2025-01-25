package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.exception.JbException;
import br.com.jbseguranca.api.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AcidenteTrabalhoService {

//	@Autowired
//	private RestTemplate restTemplate;

	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;

	@Value("${acidente.trabalho.auth.token}")
	private String apiToken;

	@Value("${acidente.trabalho.auth.cnpj}")
	private String cnpjSh;

	private final RestTemplate restTemplate;

	public AcidenteTrabalhoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ApiResponse getAcidenteTrabalhoById(String id) {
	    if (apiUrl == null || apiUrl.isEmpty()) {
	        throw new JbException("A URL da API não está configurada.");
	    }

	    try {
	        String urlComId = apiUrl + "/" + id;

	        ResponseEntity<String> response = restTemplate.getForEntity(urlComId, String.class);
	        
	        HttpStatusCode statusCode = response.getStatusCode();

	        if (statusCode.is2xxSuccessful()) {
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(response.getBody(), ApiResponse.class);
	        }else if(statusCode ==HttpStatus.NOT_FOUND) {
	        	throw new ResourceNotFoundException("Acidente de Trabalho não encontrado " +  id);
	        }else {
	            // Caso não seja 2xx, tratamos como erro
	            throw new JbException("Erro na API: Código " + response.getStatusCodeValue()
	                                  + " - Resposta: " + response.getBody());
	        }
	    } catch (HttpClientErrorException ex) {
	    	
	    	if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
	    		throw new ResourceNotFoundException("Acidente de Trabalho não encontrado " +  id, ex);
	    	}
	        // Aqui você consegue ver o status e o body de erro
	        System.out.println("HttpClientErrorException: " + ex.getStatusCode() + " -> " + ex.getResponseBodyAsString());
	        throw new JbException("Erro ao obter Acidente de Trabalho: " + ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new JbException("Erro inesperado ao obter Acidente de Trabalho.", ex);
	    }
	}

	public ApiResponse createAcidenteTrabalho(AcidenteTrabalho acidenteTrabalho) {
	    if (apiUrl == null || apiUrl.isEmpty()) {
	        throw new JbException("A URL da API não está configurada.");
	    }

	    try {
	        // Serializando o objeto para JSON
	        ObjectMapper objectMapper = new ObjectMapper();
	        String json = objectMapper.writeValueAsString(acidenteTrabalho);

	        // Fazendo a requisição POST
	        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, json, String.class);

	        if (response.getStatusCode().is2xxSuccessful()) {
	            // Converte a resposta para o DTO
	        	log.info("Lote Recebido com Sucesso.", response.getBody());
	            return objectMapper.readValue(response.getBody(), ApiResponse.class);
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

