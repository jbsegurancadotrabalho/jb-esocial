package br.com.jbseguranca.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AfastamentoTemporario {
	@ApiModelProperty(value = "CPF/CNPJ do transmissor", required = true)
	@JsonProperty("cpfcnpjtransmissor")
    private String cpfCnpjTransmissor;
    
    @JsonProperty("cpfcnpjempregador")
    private String cpfCnpjEmpregador;
    
    @JsonProperty("idgrupoeventos")
    private String idGrupoEventos;
    
    @JsonProperty("versaomanual")
    private String versaoManual;
    
    @JsonProperty("ambiente")
    private String ambiente;
    
    @JsonProperty("s2230")
    private List<S2230Item> s2230;


}
