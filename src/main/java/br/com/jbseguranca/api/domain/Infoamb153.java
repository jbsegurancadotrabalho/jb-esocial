package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Infoamb153 {
	 @JsonProperty("localAmb_90")
	    private String localAmb90;

	    @JsonProperty("dscSetor_91")
	    private String dscSetor91;

	    @JsonProperty("tpInsc_92")
	    private String tpInsc92;

	    @JsonProperty("nrInsc_93")
	    private String nrInsc93;

}
