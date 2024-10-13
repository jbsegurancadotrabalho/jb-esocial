package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.exception.JbException;

@Service
public class AcidenteTrabalhoService {

	@Autowired
	private final RestTemplate restTemplate;

	@Value("${acidente.trabalho.api.url}")
	private String apiUrl;

	public AcidenteTrabalhoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public AcidenteTrabalho consumirApiAcidenteTrabalho() {
		try {
			return restTemplate.getForObject(apiUrl, AcidenteTrabalho.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
			throw new JbException("Erro ao consumir a API de Acidente de Trabalho.");
		}
	}
	
	
	public AcidenteTrabalho getAcidenteTrabalhoById(String id) {
        try {
            String url = apiUrl + "/" + id;
            return restTemplate.getForObject(url, AcidenteTrabalho.class);
        } catch (RestClientException ex) {
            ex.printStackTrace();
            throw new JbException("Erro ao obter o Acidente de Trabalho com ID: " );
        }
    }
	
	
	public AcidenteTrabalho createAcidenteTrabalho(AcidenteTrabalho acidente) {
        try {
            return restTemplate.postForObject(apiUrl, acidente, AcidenteTrabalho.class);
        } catch (RestClientException ex) {
            ex.printStackTrace();
            throw new JbException("Erro ao criar um novo Acidente de Trabalho.");
        }
    }
}
