package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.jbseguranca.api.domain.SaudeTrabalhador;
import br.com.jbseguranca.api.exception.JbException;

@Service
public class SaudeTrabalhadorService {

	private final RestTemplate restTemplate;

	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;

	public SaudeTrabalhadorService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public SaudeTrabalhador createSaudeTrabalhadorById(SaudeTrabalhador trabalhador) {
		try {
			return restTemplate.postForObject(apiUrl, trabalhador, SaudeTrabalhador.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
			throw new JbException("Erro ao criar um novo laudo de Saúde do Trabalhador.");
		}
	}
}
