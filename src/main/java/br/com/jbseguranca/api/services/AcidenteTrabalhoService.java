package br.com.jbseguranca.api.services;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.jbseguranca.api.domain.AcidenteTrabalho;
import br.com.jbseguranca.api.domain.S2210Item;
import br.com.jbseguranca.api.dto.ApiResponse;
import br.com.jbseguranca.api.exception.JbException;
import br.com.jbseguranca.api.exception.ResourceNotFoundException;
import br.com.jbseguranca.api.repository.AcidenteTrabalhoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AcidenteTrabalhoService {


	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;
	
	@Value("${endereco.tecnospeed.url.consulta}")
	private String apiUrlConsultar;

	@Value("${tecnospeed.auth.token}")
	private String apiToken;

	@Value("${tecnospeed.auth.cnpj}")
	private String cnpjSh;
	
	@Value("${tecnospeed.auth.empregador}")
	private String empregador;

	private final RestTemplate restTemplate;
	
	@Autowired
	private AcidenteTrabalhoRepository acidenteTrabalhoRepository;

	public AcidenteTrabalhoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public AcidenteTrabalho salvarAcidenteTrabalho(AcidenteTrabalho acidenteTrabalho) {
        return acidenteTrabalhoRepository.save(acidenteTrabalho);
    }
	
	public ApiResponse getAcidenteTrabalhoConsultaEventoById(String id, String versaoManual, String ambiente) {
	    if (apiUrlConsultar == null || apiUrlConsultar.isEmpty()) {
	        throw new JbException("A URL da API não está configurada.");
	    }
	    
	    try {
	        String urlComId = apiUrlConsultar + "/" + id + "?versaomanual=" + versaoManual + "&ambiente=" + ambiente;
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("cnpj", cnpjSh);
	        headers.set("token", apiToken);
	        headers.set("empregador", empregador);
	        
	        HttpEntity<String> entity = new HttpEntity<>(headers);
	        
	        ResponseEntity<String> response = restTemplate.exchange(urlComId, HttpMethod.GET, entity, String.class);
	        HttpStatusCode statusCode = response.getStatusCode();
	        
	        if (statusCode.is2xxSuccessful()) {
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(response.getBody(), ApiResponse.class);
	        } else if (statusCode == HttpStatus.NOT_FOUND) {
	            throw new ResourceNotFoundException("Acidente de Trabalho não encontrado " + id);
	        } else {
	            throw new JbException("Erro na API: Código " + response.getStatusCodeValue() 
	                                      + " - Resposta: " + response.getBody());
	        }
	    } catch (HttpClientErrorException ex) {
	        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
	            throw new ResourceNotFoundException("Acidente de Trabalho não encontrado " + id, ex);
	        }
	        System.out.println("HttpClientErrorException: " + ex.getStatusCode() 
	                           + " -> " + ex.getResponseBodyAsString());
	        throw new JbException("Erro ao obter Acidente de Trabalho: " + ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new JbException("Erro inesperado ao obter Acidente de Trabalho.", ex);
	    }
	}


	public ApiResponse createAcidenteTrabalho(AcidenteTrabalho acidenteTrabalho) {
		if (apiUrl == null || apiUrl.isEmpty()) {
			throw new JbException("A URL da API não está configurada.");
		}

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(acidenteTrabalho);

			ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, json, String.class);

			if (response.getStatusCode().is2xxSuccessful()) {
				log.info("Lote Recebido com Sucesso.", response.getBody());
				ApiResponse apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
				objectMapper.readValue(response.getBody(), ApiResponse.class);
				salvarNoBanco(acidenteTrabalho, apiResponse);
				return apiResponse;
			} else {
				throw new JbException("Erro na API: Código " + response.getStatusCodeValue());
			}
		} catch (HttpClientErrorException ex) {
			log.error("Erro ao criar Acidente de Trabalho: {}", ex.getResponseBodyAsString());
			throw new JbException("Erro ao criar Acidente de Trabalho: " + ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("Erro inesperado ao criar Acidente de Trabalho.", ex);
			throw new JbException("Erro inesperado ao criar Acidente de Trabalho.", ex);
		}
	}
	
	private void salvarNoBanco(AcidenteTrabalho acidenteTrabalho, ApiResponse apiResponse) {
		AcidenteTrabalho acidenteTrabalhoEntity = new AcidenteTrabalho(null, acidenteTrabalho.getCpfCnpjTransmissor(),
				acidenteTrabalho.getCpfCnpjEmpregador(), acidenteTrabalho.getIdGrupoEventos(),
				acidenteTrabalho.getVersaoManual(), acidenteTrabalho.getAmbiente(), null 
		);
		Set<S2210Item> s2210Items = acidenteTrabalho.getS2210().stream().map(item -> {
			S2210Item s2210Item = new S2210Item();
			s2210Item.setIndRetif_4(item.getIndRetif_4());
			s2210Item.setNrRecibo_5(item.getNrRecibo_5());
			s2210Item.setTpAmb_6(item.getTpAmb_6());
			s2210Item.setProcEmi_7(item.getProcEmi_7());
			s2210Item.setVerProc_8(item.getVerProc_8());
			s2210Item.setTpInsc_14(item.getTpInsc_14());
			s2210Item.setNrInsc_15(item.getNrInsc_15());
			s2210Item.setCpfTrab_66(item.getCpfTrab_66());
			s2210Item.setMatricula_68(item.getMatricula_68());
			s2210Item.setCodCateg_69(item.getCodCateg_69());
			s2210Item.setDtAcid_20(item.getDtAcid_20());
			s2210Item.setTpAcid_21(item.getTpAcid_21());
			s2210Item.setHrAcid_22(item.getHrAcid_22());
			s2210Item.setHrsTrabAntesAcid_23(item.getHrsTrabAntesAcid_23());
			s2210Item.setTpCat_24(item.getTpCat_24());
			s2210Item.setIndCatObito_25(item.getIndCatObito_25());
			s2210Item.setDtObito_26(item.getDtObito_26());
			s2210Item.setIndComunPolicia_27(item.getIndComunPolicia_27());
			s2210Item.setCodSitGeradora_28(item.getCodSitGeradora_28());
			s2210Item.setIniciatCAT_29(item.getIniciatCAT_29());
			s2210Item.setObsCAT_30(item.getObsCAT_30());
			s2210Item.setUltDiaTrab_79(item.getUltDiaTrab_79());
			s2210Item.setHouveAfast_80(item.getHouveAfast_80());
			s2210Item.setTpLocal_32(item.getTpLocal_32());
			s2210Item.setDscLocal_33(item.getDscLocal_33());
			s2210Item.setTpLograd_76(item.getTpLograd_76());
			s2210Item.setDscLograd_34(item.getDscLograd_34());
			s2210Item.setNrLograd_35(item.getNrLograd_35());
			s2210Item.setComplemento_73(item.getComplemento_73());
			s2210Item.setBairro_74(item.getBairro_74());
			s2210Item.setCep_75(item.getCep_75());
			s2210Item.setCodMunic_36(item.getCodMunic_36());
			s2210Item.setUf_37(item.getUf_37());
			s2210Item.setPais_39(item.getPais_39());
			s2210Item.setCodPostal_40(item.getCodPostal_40());
			s2210Item.setTpInsc_77(item.getTpInsc_77());
			s2210Item.setNrInsc_78(item.getNrInsc_78());
			s2210Item.setCodParteAting_42(item.getCodParteAting_42());
			s2210Item.setLateralidade_43(item.getLateralidade_43());
			s2210Item.setCodAgntCausador_45(item.getCodAgntCausador_45());
			s2210Item.setDtAtendimento_48(item.getDtAtendimento_48());
			s2210Item.setHrAtendimento_49(item.getHrAtendimento_49());
			s2210Item.setIndInternacao_50(item.getIndInternacao_50());
			s2210Item.setDurTrat_51(item.getDurTrat_51());
			s2210Item.setIndAfast_52(item.getIndAfast_52());
			s2210Item.setDscLesao_53(item.getDscLesao_53());
			s2210Item.setDscCompLesao_54(item.getDscCompLesao_54());
			s2210Item.setDiagProvavel_55(item.getDiagProvavel_55());
			s2210Item.setCodCID_56(item.getCodCID_56());
			s2210Item.setObservacao_57(item.getObservacao_57());
			s2210Item.setNmEmit_59(item.getNmEmit_59());
			s2210Item.setNrOC_61(item.getNrOC_61());
			s2210Item.setUfOC_62(item.getUfOC_62());
			s2210Item.setNrRecCatOrig_65(item.getNrRecCatOrig_65());
			s2210Item.setAcidenteTrabalho(acidenteTrabalhoEntity);
			return s2210Item;
		}).collect(Collectors.toSet());
		acidenteTrabalhoEntity.setS2210(s2210Items);
		salvarAcidenteTrabalho(acidenteTrabalhoEntity);
	}

}

