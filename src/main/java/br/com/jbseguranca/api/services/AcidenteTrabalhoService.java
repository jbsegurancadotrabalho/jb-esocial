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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.jbseguranca.api.exception.JbException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AcidenteTrabalhoService {

//	@Autowired
//	private RestTemplate restTemplate;

	@Value("${endereco.tecnospeed.api.url}")
	private String apiUrl;

	private static final String URL_API = "https://api.tecnospeed.com.br/esocial/v1/evento/enviar/tx2"; // Coloque a URL
																										// da API

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

	public String createAcidenteTrabalho(String tx2Content, String cpfCnpjTransmissor, String cpfCnpjEmpregador,
			String idGrupoEventos, String versaoManual, String ambiente) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("text/tx2"));
		headers.set("cpfCnpjTransmissor", cpfCnpjTransmissor);
		headers.set("cpfCnpjEmpregador", cpfCnpjEmpregador);
		headers.set("idGrupoEventos", idGrupoEventos);
		headers.set("versaoManual", versaoManual);
		headers.set("ambiente", ambiente);

		HttpEntity<String> entity = new HttpEntity<>(tx2Content, headers);

		try {
			ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

			if (response.getStatusCode().is2xxSuccessful()) {
				return parseResponse(response.getBody());
			} else {
				throw new JbException("Erro na API: Código " + response.getStatusCodeValue());
			}
		} catch (HttpClientErrorException ex) {
			System.err.println("Erro ao criar Acidente de Trabalho: " + ex.getResponseBodyAsString());
			throw new JbException("Erro ao criar Acidente de Trabalho: " + ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new JbException("Erro inesperado ao criar Acidente de Trabalho.", ex);
		}
	}

	private String parseResponse(String responseBody) {
// Adapte para processar a estrutura de retorno da API
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(responseBody);
			String id = rootNode.path("id").asText();
			String codigo = rootNode.path("status").path("codigo").asText();
			String mensagem = rootNode.path("status").path("mensagem").asText();
			String recibo = rootNode.path("recibo").asText();

			return String.format("ID: %s, Código: %s, Mensagem: %s, Recibo: %s", id, codigo, mensagem, recibo);
		} catch (JsonProcessingException ex) {
			throw new JbException("Erro ao processar resposta da API.", ex);
		}
	}

	private String convertToTx2FormatS2210() {
		StringBuilder tx2Builder = new StringBuilder();

		// Adiciona os campos iniciais obrigatórios
		tx2Builder.append("cpfcnpjtransmissor=25108808000118").append("\n");
		tx2Builder.append("cpfcnpjempregador=25108808000118").append("\n");
		tx2Builder.append("idgrupoeventos=2").append("\n");
		tx2Builder.append("versaomanual=S.01.02.00").append("\n");
		tx2Builder.append("ambiente=2").append("\n");

		// Inclui os detalhes do S2210
		tx2Builder.append("INCLUIRS2210\n");
		tx2Builder.append("indRetif_4=1").append("\n");
		tx2Builder.append("nrRecibo_5=").append("\n"); // campo vazio
		tx2Builder.append("tpAmb_6=2").append("\n");
		tx2Builder.append("procEmi_7=1").append("\n");
		tx2Builder.append("verProc_8=1.0").append("\n");
		tx2Builder.append("tpInsc_14=1").append("\n");
		tx2Builder.append("nrInsc_15=29062609").append("\n");
		tx2Builder.append("cpfTrab_66=04623008118").append("\n");
		tx2Builder.append("matricula_68=151612158").append("\n");
		tx2Builder.append("codCateg_69=").append("\n"); // campo vazio
		tx2Builder.append("dtAcid_20=2024-10-20").append("\n");
		tx2Builder.append("tpAcid_21=1").append("\n");
		tx2Builder.append("hrAcid_22=10:30").append("\n");
		tx2Builder.append("hrsTrabAntesAcid_23=2").append("\n");
		tx2Builder.append("tpCat_24=1").append("\n");
		tx2Builder.append("indCatObito_25=2").append("\n");
		tx2Builder.append("dtObito_26=").append("\n"); // campo vazio
		tx2Builder.append("indComunPolicia_27=2").append("\n");
		tx2Builder.append("codSitGeradora_28=03").append("\n");
		tx2Builder.append("iniciatCAT_29=1").append("\n");
		tx2Builder.append("obsCAT_30=").append("\n"); // campo vazio
		tx2Builder.append("ultDiaTrab_79=2024-10-20").append("\n");
		tx2Builder.append("houveAfast_80=1").append("\n");
		tx2Builder.append("tpLocal_32=1").append("\n");
		tx2Builder.append("dscLocal_33=Escritório").append("\n");
		tx2Builder.append("tpLograd_76=1").append("\n");
		tx2Builder.append("dscLograd_34=Rua Exemplo").append("\n");
		tx2Builder.append("nrLograd_35=123").append("\n");
		tx2Builder.append("complemento_73=").append("\n"); // campo vazio
		tx2Builder.append("bairro_74=Centro").append("\n");
		tx2Builder.append("cep_75=01010001").append("\n");
		tx2Builder.append("codMunic_36=3550308").append("\n");
		tx2Builder.append("uf_37=SP").append("\n");
		tx2Builder.append("pais_39=BR").append("\n");
		tx2Builder.append("codPostal_40=").append("\n"); // campo vazio
		tx2Builder.append("tpInsc_77=1").append("\n");
		tx2Builder.append("nrInsc_78=08187168000160").append("\n");
		tx2Builder.append("codParteAting_42=01").append("\n");
		tx2Builder.append("lateralidade_43=1").append("\n");
		tx2Builder.append("codAgntCausador_45=09.01.001").append("\n");
		tx2Builder.append("dtAtendimento_48=2024-10-20").append("\n");
		tx2Builder.append("hrAtendimento_49=11:00").append("\n");
		tx2Builder.append("indInternacao_50=2").append("\n");
		tx2Builder.append("durTrat_51=5").append("\n");
		tx2Builder.append("indAfast_52=1").append("\n");
		tx2Builder.append("dscLesao_53=Fratura no braço").append("\n");
		tx2Builder.append("dscCompLesao_54=").append("\n"); // campo vazio
		tx2Builder.append("diagProvavel_55=Fratura").append("\n");
		tx2Builder.append("codCID_56=S52").append("\n");
		tx2Builder.append("observacao_57=").append("\n"); // campo vazio
		tx2Builder.append("nmEmit_59=Dr. João da Silva").append("\n");
		tx2Builder.append("ideOC_60=1").append("\n");
		tx2Builder.append("nrOC_61=12586766997").append("\n");
		tx2Builder.append("ufOC_62=SP").append("\n");
		tx2Builder.append("nrRecCatOrig_65=").append("\n"); // campo vazio

		// Finaliza o bloco S2210
		tx2Builder.append("SALVARS2210");

		return tx2Builder.toString();
	}

}
