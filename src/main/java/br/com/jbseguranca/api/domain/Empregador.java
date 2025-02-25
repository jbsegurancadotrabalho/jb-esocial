package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Empregador {

	@NotNull(message = "O CPF ou o CNPJ do empregador tem que ser informado")
    @JsonProperty("empregador")
    private String empregador = "66231931000109";

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

    @NotNull(message = "A Razão social tem que ser informada.")
    @JsonProperty("razaosocial")
    private String razaosocial;
}

