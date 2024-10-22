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

}
