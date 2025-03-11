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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jbseguranca.api.domain.Empregador;
import br.com.jbseguranca.api.dto.response.ConsultaEmpregadorDto;
import br.com.jbseguranca.api.dto.response.EmpregadorDto;
import br.com.jbseguranca.api.exception.JbException;
import br.com.jbseguranca.api.exception.ResourceNotFoundException;

@Service
public class EmpregadorService {
	
	@Value("${consulta.empregador.tecnospeed.api.url}")
	private String apiUrlConsultar;

	@Value("${cadastrar.empregador.tecnospeed.api.url}")
	private String apiUrl;

	@Value("${tecnospeed.auth.token}")
	private String apiToken;

	@Value("${tecnospeed.auth.cnpj}")
	private String cnpjSh;

	private final RestTemplate restTemplate;

	public EmpregadorService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Empregador consumirApiEmpregador() {
		try {
			return restTemplate.getForObject(apiUrl, Empregador.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
			throw new JbException("Erro ao consumir a API de para cadastro de empregador.", ex);
		}

	}

	public EmpregadorDto cadastrarEmpregador(Empregador empregador) {
		if (apiUrl == null || apiUrl.isEmpty()) {
			throw new JbException("A URL da API não está configurada.");
		}
		String cnpjLimpo = empregador.getEmpregador().replaceAll("\\D", "");
		if (!isCnpjValido(cnpjLimpo)) {
			 throw new JbException("Erro: CNPJ inválido (" + empregador.getEmpregador() + ")");
		}

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(empregador);
			
			HttpHeaders headers = new HttpHeaders();
	        headers.set("Content-Type", "application/json");
	        headers.set("cnpj", cnpjSh);
	        headers.set("token", apiToken);

	        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

	        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);


			if (response.getStatusCode().is2xxSuccessful()) {
				return objectMapper.readValue(response.getBody(), EmpregadorDto.class);
			} else {
				throw new JbException("Erro na API: Código " + response.getStatusCodeValue());
			}
		} catch (HttpClientErrorException ex) {
			throw new JbException("Erro ao criar o empregador: " + ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new JbException("Erro inesperado ao criar um empregador.", ex);
		}

	}
	
	public ConsultaEmpregadorDto ConsultarEmpregadorPorCpfOuCnpj(String cpfOuCnpj) {
		 if (apiUrlConsultar == null || apiUrlConsultar.isEmpty()) {
		        throw new JbException("A URL da API não está configurada.");
		    }
		    
		    try {
		        String urlComId = apiUrlConsultar + "/" + cpfOuCnpj;
		        
		        HttpHeaders headers = new HttpHeaders();
		        headers.set("cnpj_sh", cnpjSh);
		        headers.set("token_sh", apiToken);
		        headers.set("empregador", cpfOuCnpj);
		        
		        HttpEntity<String> entity = new HttpEntity<>(headers);
		        
		        ResponseEntity<String> response = restTemplate.exchange(urlComId, HttpMethod.GET, entity, String.class);
		        HttpStatusCode statusCode = response.getStatusCode();
		        
		        if (statusCode.is2xxSuccessful()) {
		            ObjectMapper objectMapper = new ObjectMapper();
		            return objectMapper.readValue(response.getBody(), ConsultaEmpregadorDto.class);
		        } else if (statusCode == HttpStatus.NOT_FOUND) {
		            throw new ResourceNotFoundException("Empregador não encontrado " + cpfOuCnpj);
		        } else {
		            throw new JbException("Erro na API: Código " + response.getStatusCodeValue() 
		                                      + " - Resposta: " + response.getBody());
		        }
		    } catch (HttpClientErrorException ex) {
		        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
		            throw new ResourceNotFoundException("Consulta por lote não encontrado " + cpfOuCnpj, ex);
		        }
		        System.out.println("HttpClientErrorException: " + ex.getStatusCode() 
		                           + " -> " + ex.getResponseBodyAsString());
		        throw new JbException("Erro ao obter dados do empregador: " + ex.getMessage(), ex);
		    } catch (Exception ex) {
		        throw new JbException("Erro inesperado ao obter dados do empregador.", ex);
		    }
		}
	
	

	public boolean isCnpjValido(String cnpj) {
	    if (cnpj == null || cnpj.length() != 14 || !cnpj.matches("\\d+")) {
	        return false;
	    }

	    int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	    int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

	    try {
	        int soma1 = 0, soma2 = 0;
	        for (int i = 0; i < 12; i++) {
	            int num = Character.getNumericValue(cnpj.charAt(i));
	            soma1 += num * pesos1[i];
	            soma2 += num * pesos2[i];
	        }

	        int dv1 = (soma1 % 11 < 2) ? 0 : (11 - (soma1 % 11));
	        soma2 += dv1 * pesos2[12];
	        int dv2 = (soma2 % 11 < 2) ? 0 : (11 - (soma2 % 11));

	        return dv1 == Character.getNumericValue(cnpj.charAt(12)) &&
	               dv2 == Character.getNumericValue(cnpj.charAt(13));
	    } catch (Exception e) {
	        return false;
	    }
	}


}
