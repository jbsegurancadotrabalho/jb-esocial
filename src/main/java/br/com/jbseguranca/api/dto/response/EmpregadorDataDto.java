package br.com.jbseguranca.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpregadorDataDto {
	
	 @JsonProperty("_id")
	    private String id;

	    @JsonProperty("cnpj")
	    private String cnpj;

	    @JsonProperty("razaosocial")
	    private String razaoSocial;

	    @JsonProperty("email")
	    private String email;

	    @JsonProperty("telefone")
	    private String telefone;

	    @JsonProperty("enderecologradouro")
	    private String enderecoLogradouro;

	    @JsonProperty("endereconumero")
	    private String enderecoNumero;

	    @JsonProperty("enderecocomplemento")
	    private String enderecoComplemento;

	    @JsonProperty("enderecobairro")
	    private String enderecoBairro;

	    @JsonProperty("enderecocep")
	    private String enderecoCep;

	    @JsonProperty("enderecocidadeibge")
	    private String enderecoCidadeIbge;
	    
	    
	    @JsonProperty("certificado")
	    private String certificado;

	    @JsonProperty("uf")
	    private String uf;

	    @JsonProperty("cnpj_sh")
	    private String cnpjSh;

	    @JsonProperty("data_criacao")
	    private long dataCriacao;

	    @JsonProperty("situacao")
	    private String situacao;

}
