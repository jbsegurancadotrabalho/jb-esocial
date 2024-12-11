package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exame {

	@NotNull(message = "O campo 'dtExm_21' não pode ser vazio")
	@JsonProperty("dtExm_21")
	private String dtExm_21;
	@NotNull(message = "O campo 'procRealizado_22' não pode ser vazio")
	@Size(min = 4, max = 4)
	@JsonProperty("procRealizado_22")
	private String procRealizado_22;
	@Size(min = 1, max = 999)
	@JsonProperty("obsProc_23")
	private String obsProc_23;
	@Size(min = 1, max = 1)
	@JsonProperty("ordExame_25")
	private String ordExame_25;
	@Size(min = 1, max = 1)
	@JsonProperty("indResult_28")
	private String indResult_28;

}
