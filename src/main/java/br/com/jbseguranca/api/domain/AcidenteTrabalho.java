package br.com.jbseguranca.api.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class AcidenteTrabalho {
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
	@JsonProperty("s2210")
	private Set<S2210Item> s2210 = new HashSet<>();
}
