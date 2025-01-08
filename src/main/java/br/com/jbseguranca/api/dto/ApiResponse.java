package br.com.jbseguranca.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
	
	private String message;
    private DataResponse data;

}
