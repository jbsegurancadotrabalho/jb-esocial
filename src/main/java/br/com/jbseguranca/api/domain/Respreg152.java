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
public class Respreg152 {

	@NotNull(message = "O campo 'cpfResp_86' não pode ser vazio")
	@Size(min = 11, max = 11, message = "deve ter 11 caractere numericos")
	@JsonProperty("cpfResp_86")
	private String cpfResp86;

	@Size(min = 1, max = 1, message = "deve ter 1 caracteres numerico. 1 - Conselho Regional de Medicina - CRM, 4 -Conselho Regional de Engenharia e Agronomia - CREA e 9 - Outros")
	@JsonProperty("ideOC_88")
	private String ideOC88;

	@Size(min = 1, max = 20, message = "deve ter no minimo 1 e no máximo 20 caracteres")
	@JsonProperty("dscOC_89")
	private String dscOC89;

	@Size(min = 1, max = 14, message = "deve ter no minimo 1 e no máximo 14 caracteres")
	@JsonProperty("nrOC_73")
	private String nrOC73;
	
	@Size(min = 2, max = 2, message = "deve ter no minimo 1 e no máximo 2 caracteres alfanumerico")
	@JsonProperty("ufOC_74")
	private String ufOC74;
}
