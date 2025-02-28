package br.com.jbseguranca.api.dto.response;

import br.com.jbseguranca.api.dto.DataResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseGet {
	
	private String message;
    private DataResponse data;

}
