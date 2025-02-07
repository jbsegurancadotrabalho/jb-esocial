package br.com.jbseguranca.api.services;

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

import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.dto.response.ApiResponseGet;
import br.com.jbseguranca.api.exception.JbException;
import br.com.jbseguranca.api.exception.ResourceNotFoundException;

@Service
public class ConsultarEventoService {

	@Value("${endereco.tecnospeed.url.consulta}")
	private String apiUrlConsultar;

	@Value("${acidente.trabalho.auth.token}")
	private String apiToken;

	@Value("${acidente.trabalho.auth.cnpj}")
	private String cnpjSh;
	
	@Value("${acidente.trabalho.auth.empregador}")
	private String empregador;

	private final RestTemplate restTemplate;
	
	public ConsultarEventoService(RestTemplate restTemplate) {
		this.restTemplate = new RestTemplate();
	}
	
	public ApiResponseGet ConsultaEventoPorLoteById(String id, String versaoManual, String ambiente) {
	    if (apiUrlConsultar == null || apiUrlConsultar.isEmpty()) {
	        throw new JbException("A URL da API não está configurada.");
	    }
	    
	    try {
	        String urlComId = apiUrlConsultar + "/" + id + "?versaomanual=" + versaoManual + "&ambiente=" + ambiente;
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("cnpj_sh", cnpjSh);
	        headers.set("token_sh", apiToken);
	        headers.set("empregador", empregador);
	        
	        HttpEntity<String> entity = new HttpEntity<>(headers);
	        
	        ResponseEntity<String> response = restTemplate.exchange(urlComId, HttpMethod.GET, entity, String.class);
	        HttpStatusCode statusCode = response.getStatusCode();
	        
	        if (statusCode.is2xxSuccessful()) {
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(response.getBody(), ApiResponseGet.class);
	        } else if (statusCode == HttpStatus.NOT_FOUND) {
	            throw new ResourceNotFoundException("Consulta por lote não encontrado " + id);
	        } else {
	            throw new JbException("Erro na API: Código " + response.getStatusCodeValue() 
	                                      + " - Resposta: " + response.getBody());
	        }
	    } catch (HttpClientErrorException ex) {
	        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
	            throw new ResourceNotFoundException("Consulta por lote não encontrado " + id, ex);
	        }
	        System.out.println("HttpClientErrorException: " + ex.getStatusCode() 
	                           + " -> " + ex.getResponseBodyAsString());
	        throw new JbException("Erro ao obter Consulta por lote: " + ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new JbException("Erro inesperado ao obter Consulta por lote.", ex);
	    }
	}
}
