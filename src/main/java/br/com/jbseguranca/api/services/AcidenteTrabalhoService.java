package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;

@Service
public class AcidenteTrabalhoService {

	private final RestTemplate restTemplate;

	@Value("${acidente.trabalho.api.url}")
	private String apiUrl;

	@Autowired
	public AcidenteTrabalhoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public AcidenteTrabalho consumirApiAcidenteTrabalho() {
		try {
			return restTemplate.getForObject(apiUrl, AcidenteTrabalho.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Erro ao consumir a API de Acidente de Trabalho.", ex);
		}
	}
}
