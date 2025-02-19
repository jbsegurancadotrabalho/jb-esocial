package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Empregador {

    @JsonProperty("empregador")
    private String empregador;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("logradouro")
    private String logradouro;

    @JsonProperty("numero")
    private String numero;

    @JsonProperty("complemento")
    private String complemento;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("codigoibge")
    private String codigoibge;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("razaosocial")
    private String razaosocial;
}

