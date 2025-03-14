package br.com.jbseguranca.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultaEmpregadorDto {

	 @JsonProperty("message")
	    private String message;

	    @JsonProperty("data")
	    private EmpregadorDataDto data;
	
}
