package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exame {
	
	   @JsonProperty("dtExm_21")
       private String dtExm_21;

       @JsonProperty("procRealizado_22")
       private String procRealizado_22;

       @JsonProperty("obsProc_23")
       private String obsProc_23;

       @JsonProperty("ordExame_25")
       private String ordExame_25;

       @JsonProperty("indResult_28")
       private String indResult_28;

}
