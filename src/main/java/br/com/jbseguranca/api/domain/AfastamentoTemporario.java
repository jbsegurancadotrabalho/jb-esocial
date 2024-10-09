package br.com.jbseguranca.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AfastamentoTemporario {
	
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
