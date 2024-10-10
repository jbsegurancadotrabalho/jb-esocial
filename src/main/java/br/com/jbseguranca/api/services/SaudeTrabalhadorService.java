package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.jbseguranca.api.domain.SaudeTrabalhador;

@Service
public class SaudeTrabalhadorService {
	
	private final RestTemplate restTemplate;
	
	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;
	
	public SaudeTrabalhadorService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public SaudeTrabalhador consumirApiSaudeTrabalhador() {
		try {
			return restTemplate.getForObject(apiUrl, SaudeTrabalhador.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Erro ao consumir a API de Monitoramento de Saúde do Trabalhador.", ex);
		}
	}

}
