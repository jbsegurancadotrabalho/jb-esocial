package br.com.jbseguranca.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentesNocivos {
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
	 @JsonProperty("s2240")
	 private List <S2240Item> s2240;

}
