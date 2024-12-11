package br.com.jbseguranca.api.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

public class ApiClient {

	public void enviarDados() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("text/tx2")); // Ajustando o tipo de conteúdo para text/tx2

		// Adicionando CNPJ da Software House ao cabeçalho
		headers.set("cnpj_sh", "29062609000177");

		// Token de autenticação
		String token = "1DuS5BCloe2EeZ0I9D5j19fcwF79ychg3OSkyvAL"; // Certifique-se de que o token é válido
		headers.set("Authorization", "Bearer " + token);

		// Corpo da requisição em formato TX2
		String body = "cpfcnpjtransmissor=29062609000177\n" + "cpfcnpjempregador=29062609000177\n"
				+ "idgrupoeventos=2\n" + "versaomanual=S.01.02.00\n" + "ambiente=2\n" + "indRetif_4=1\n"
				+ "nrRecibo_5=\n" + "tpAmb_6=2\n" + "procEmi_7=1\n" + "verProc_8=1.0\n" + "tpInsc_10=1\n"
				+ "nrInsc_11=29062609\n" + "cpfTrab_13=04623008118\n" + "matricula_15=151612158\n" + "codCateg_85=\n"
				+ "dtIniCondicao_18=2021-06-23\n" + "localAmb_90=1\n" + "dscSetor_91=escritorio\n" + "tpInsc_92=1\n"
				+ "nrInsc_93=08187168000160\n" + "dscAtivDes_22=pressão do trabalho\n" + "obsCompl_84=\n"
				+ "codAgNoc_94=09.01.001\n" + "tpAval_96=2\n" + "eficEpi_112=S\n" + "cpfResp_86=53211347070\n"
				+ "ideOC_88=1\n" + "nrOC_73=12586766997\n" + "ufOC_74=PR\n";

		// Criando a entidade HTTP
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

		// URL para enviar os dados
		String url = "https://api.tecnospeed.com.br/esocial/v1/evento/enviar/tx2";

		// Fazendo a requisição POST
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

		// Verificando a resposta
		if (response.getStatusCode().is2xxSuccessful()) {
			System.out.println("Dados enviados com sucesso: " + response.getBody());
		} else {
			System.out.println("Erro ao enviar dados: " + response.getStatusCode() + " - " + response.getBody());
		}
	}

	public static void main(String[] args) {
		ApiClient client = new ApiClient();
		client.enviarDados();
	}
}