package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.jbseguranca.api.domain.AfastamentoTemporario;
import br.com.jbseguranca.api.exception.JbException;

@Service
public class AfastamentoTemporarioService {
	
	private final RestTemplate restTemplate;
	
	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;
	
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

	public AfastamentoTemporario createAfastamentoTemporario(AfastamentoTemporario afastamento) {
		 try {
	            return restTemplate.postForObject(apiUrl, afastamento, AfastamentoTemporario.class);
	        } catch (RestClientException ex) {
	            ex.printStackTrace();
	            throw new JbException("Erro ao criar um novo Afastamento de Trabalho.");
	        }
	    }
	}

