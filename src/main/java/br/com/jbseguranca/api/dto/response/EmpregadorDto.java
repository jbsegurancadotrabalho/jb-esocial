package br.com.jbseguranca.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmpregadorDto {
	@JsonProperty("message")
	private String message;

	@JsonProperty("data")
	private DataDto data;
}
