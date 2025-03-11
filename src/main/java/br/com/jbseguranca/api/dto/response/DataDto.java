package br.com.jbseguranca.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DataDto {
	
	 @JsonProperty("cpfCnpj")
     private String cpfCnpj;
     
     @JsonProperty("status")
     private String status;

}
