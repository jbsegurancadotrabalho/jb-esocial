package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Infoamb153 {
	
	@NotNull(message = "O campo 'localAmb_90' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere numerico")
	@JsonProperty("localAmb_90")
	private String localAmb90;
	
	@NotNull(message = "O campo 'dscSetor_91' não pode ser vazio")
	@JsonProperty("dscSetor_91")
	private String dscSetor91;
	
	@NotNull(message = "O campo 'tpInsc_92' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere numerico")
	@JsonProperty("tpInsc_92")
	private String tpInsc92;

	@NotNull(message = "O campo 'nrInsc_93' não pode ser vazio")
	@Size(min = 12, max = 14, message = "deve ter no minimo 12 e no máximo 14 caracteres")
	@JsonProperty("nrInsc_93")
	private String nrInsc93;

}
