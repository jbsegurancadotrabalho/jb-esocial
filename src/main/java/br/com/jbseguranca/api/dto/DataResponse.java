package br.com.jbseguranca.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataResponse {
	@JsonProperty("cnpj_sh")
	private String cnpjSh;
	@JsonProperty("data_criacao")
	private String dataCriacao;
    private String id;
    @JsonProperty("status_envio")
    private StatusEnvio  statusEnvio;
}

