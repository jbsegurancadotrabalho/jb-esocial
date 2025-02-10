package br.com.jbseguranca.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataResponse {
    private String id;
    @JsonProperty("cnpj_sh")
    private String cnpj_sh;
    @JsonProperty("data_criacao")
    private String data_criacao;
    @JsonProperty("status_envio")
    private StatusEnvio  statusEnvio;
}

