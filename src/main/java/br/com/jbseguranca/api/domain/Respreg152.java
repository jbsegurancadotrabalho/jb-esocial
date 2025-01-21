package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Respreg152 {
	 @JsonProperty("cpfResp_86")
	    private String cpfResp86;

	    @JsonProperty("ideOC_88")
	    private String ideOC88;

	    @JsonProperty("dscOC_89")
	    private String dscOC89;

	    @JsonProperty("nrOC_73")
	    private String nrOC73;

	    @JsonProperty("ufOC_74")
	    private String ufOC74;
}
