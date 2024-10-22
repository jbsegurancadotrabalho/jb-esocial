package br.com.jbseguranca.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.domain.S2210Item;
import br.com.jbseguranca.api.exception.JbException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AcidenteTrabalhoService {

//	@Autowired
//	private RestTemplate restTemplate;

	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;
	
	 private static final String URL_API = "https://api.tecnospeed.com.br/esocial/v1/evento/enviar/tx2"; // Coloque a URL da API

//	public AcidenteTrabalho consumirApiAcidenteTrabalho() {
//        try {
//            return restTemplate.getForObject(apiUrl, AcidenteTrabalho.class);
//        } catch (HttpClientErrorException ex) {
//            throw new JbException("Erro na requisição: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString(), ex);
//        } catch (Exception ex) {
//            throw new JbException("Erro desconhecido ao consumir a API de Acidente de Trabalho.", ex);
//        }
//    }
//	
//	
//	public AcidenteTrabalho getAcidenteTrabalhoById(String id) {
//        try {
//            String url = apiUrl + "/" + id;
//            return restTemplate.getForObject(url, AcidenteTrabalho.class);
//        } catch (HttpClientErrorException ex) {
//            throw new JbException("Erro ao obter Acidente de Trabalho com ID " + id + ": " + ex.getMessage(), ex);
//        }
//    }
	
	
	 public void createAcidenteTrabalho(AcidenteTrabalho acidenteTrabalho) {
	        String tx2Content = convertToTx2Format(acidenteTrabalho);
	        System.out.println("Conteúdo TX2 enviado: " + tx2Content);
	        
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
//	        headers.setContentType(MediaType.valueOf("text/tx2"));
	        headers.set("cnpj_sh", "29062609000177");
	        headers.set("Authorization", "Bearer " + "1DuS5BCloe2EeZ0I9D5j19fcwF79ychg3OSkyvAL");

	        HttpEntity<String> entity = new HttpEntity<>(tx2Content, headers);

	        try {
	            ResponseEntity<String> response = restTemplate.exchange(URL_API, HttpMethod.POST, entity, String.class);
	            System.out.println("Resposta: " + response.getBody());
	        } catch (HttpClientErrorException ex) {
	            System.err.println("Erro ao criar Acidente de Trabalho: " + ex.getMessage());
	            throw new JbException("Erro ao criar Acidente de Trabalho: " + ex.getMessage(), ex);
	        }
	    }
	    
	    private String convertToTx2Format(AcidenteTrabalho acidenteTrabalho) {
	       
	        if (acidenteTrabalho.getCpfCnpjTransmissor() == null) {
	            throw new IllegalArgumentException("CPF/CNPJ Transmissor não pode ser nulo");
	        }
	        
	        if (acidenteTrabalho.getCpfCnpjEmpregador() == null) {
	            throw new IllegalArgumentException("CPF/CNPJ Empregador não pode ser nulo");
	        }

	        // Construir o conteúdo TX2
	        StringBuilder tx2Builder = new StringBuilder();
	        tx2Builder.append("ACIDENTE_TRABALHO|")
	                  .append(acidenteTrabalho.getCpfCnpjTransmissor()).append("|")
	                  .append(acidenteTrabalho.getCpfCnpjEmpregador()).append("|")
	                  .append(acidenteTrabalho.getIdGrupoEventos()).append("|")
	                  .append(acidenteTrabalho.getVersaoManual()).append("|")
	                  .append(acidenteTrabalho.getAmbiente()).append("|");

	        // Adicione mais campos conforme necessário
	        S2210Item s2210 = acidenteTrabalho.getS2210();
	        if (s2210 != null) {
	            // Preencha todos os campos obrigatórios
	            tx2Builder.append(s2210.getIndRetif4()).append("|")
	                      .append(s2210.getNrRecibo5()).append("|")
	                      .append(s2210.getTpAmb()).append("|")
	                      .append(s2210.getProcEmi()).append("|")
	                      .append(s2210.getVerProc()).append("|");
	        }

	        return tx2Builder.toString();
	    }
	
//	private String convertToTx2Format(AcidenteTrabalho acidenteTrabalho) {
//	    // Verificações iniciais
//	    if (acidenteTrabalho.getCpfCnpjTransmissor() == null) {
//	        throw new IllegalArgumentException("CPF/CNPJ Transmissor não pode ser nulo");
//	    }
//	    
//	    if (acidenteTrabalho.getCpfCnpjEmpregador() == null) {
//	        throw new IllegalArgumentException("CPF/CNPJ Empregador não pode ser nulo");
//	    }
//
//	    // Construir o conteúdo TX2
//	    StringBuilder tx2Builder = new StringBuilder();
//	    tx2Builder.append("ACIDENTE_TRABALHO|")
//	              .append(acidenteTrabalho.getCpfCnpjTransmissor()).append("|")
//	              .append(acidenteTrabalho.getCpfCnpjEmpregador()).append("|")
//	              .append(acidenteTrabalho.getIdGrupoEventos()).append("|")
//	              .append(acidenteTrabalho.getVersaoManual()).append("|")
//	              .append(acidenteTrabalho.getAmbiente()).append("|");
//
//	    // Adicione mais campos conforme necessário
//	    S2210Item s2210 = acidenteTrabalho.getS2210();
//	    if (s2210 != null) {
//	        // Preencha todos os campos obrigatórios
//	        tx2Builder.append(s2210.getIndRetif4()).append("|")
//	                  .append(s2210.getNrRecibo5()).append("|")
//	                  .append(s2210.getTpAmb()).append("|")
//	                  .append(s2210.getProcEmi()).append("|")
//	                  .append(s2210.getVerProc()).append("|");
//	    }
//
//	    return tx2Builder.toString();
//	}

	
}
