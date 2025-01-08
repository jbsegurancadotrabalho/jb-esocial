package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.exception.JbException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AcidenteTrabalhoService {

//	@Autowired
//	private RestTemplate restTemplate;

	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;

	@Value("${tecnospeed.auth.token}")
	private String apiToken;

	@Value("${tecnospeed.auth.cnpj}")
	private String cnpjSh;

	private final RestTemplate restTemplate;

	public AcidenteTrabalhoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public AcidenteTrabalho consumirApiAcidenteTrabalho() {
		try {
			return restTemplate.getForObject(apiUrl, AcidenteTrabalho.class);
		} catch (HttpClientErrorException ex) {
			throw new JbException("Erro na requisição: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString(),
					ex);
		} catch (Exception ex) {
			throw new JbException("Erro desconhecido ao consumir a API de Acidente de Trabalho.", ex);
		}
	}

	public AcidenteTrabalho getAcidenteTrabalhoById(String id) {
		try {
			String url = apiUrl + "/" + id;
			return restTemplate.getForObject(url, AcidenteTrabalho.class);
		} catch (HttpClientErrorException ex) {
			throw new JbException("Erro ao obter Acidente de Trabalho com ID " + id + ": " + ex.getMessage(), ex);
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
	        	//log.info("Lote Recebido com Sucesso.", response.getBody());
	            return objectMapper.readValue(response.getBody(), ApiResponse.class);
	        } else {
	            throw new JbException("Erro na API: Código " + response.getStatusCodeValue());
	        }
	    } catch (HttpClientErrorException ex) {
	        //log.error("Erro ao criar Acidente de Trabalho: {}", ex.getResponseBodyAsString());
	        throw new JbException("Erro ao criar Acidente de Trabalho: " + ex.getMessage(), ex);
	    } catch (Exception ex) {
	        //log.error("Erro inesperado ao criar Acidente de Trabalho.", ex);
	        throw new JbException("Erro inesperado ao criar Acidente de Trabalho.", ex);
	    }
	}


//	private String parseResponse(String responseBody) {
//		try {
//			ObjectMapper objectMapper = new ObjectMapper();
//			JsonNode rootNode = objectMapper.readTree(responseBody);
//			log.info("Resposta da API: {}", responseBody); // Log para ver a resposta completa
//			String id = rootNode.path("id").asText();
//			String codigo = rootNode.path("status").path("codigo").asText();
//			String mensagem = rootNode.path("status").path("mensagem").asText();
//			String recibo = rootNode.path("recibo").asText();
//
//			return String.format("ID: %s, Código: %s, Mensagem: %s, Recibo: %s", id, codigo, mensagem, recibo);
//		} catch (JsonProcessingException ex) {
//			throw new JbException("Erro ao processar resposta da API.", ex);
//		}
//	}

}
