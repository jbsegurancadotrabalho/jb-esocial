package br.com.jbseguranca.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class S2240Item {
	
	 @JsonProperty("indRetif_4")
	    private String indRetif4;

	    @JsonProperty("nrRecibo_5")
	    private String nrRecibo5;

	    @JsonProperty("tpAmb_6")
	    private String tpAmb6;

	    @JsonProperty("procEmi_7")
	    private String procEmi7;

	    @JsonProperty("verProc_8")
	    private String verProc8;

	    @JsonProperty("tpInsc_10")
	    private String tpInsc10;

	    @JsonProperty("nrInsc_11")
	    private String nrInsc11;

	    @JsonProperty("cpfTrab_13")
	    private String cpfTrab13;

	    @JsonProperty("matricula_15")
	    private String matricula15;

	    @JsonProperty("codCateg_85")
	    private String codCateg85;

	    @JsonProperty("dtIniCondicao_18")
	    private String dtIniCondicao18;

	    @JsonProperty("dtFimCondicao_113")
	    private String dtFimCondicao113;

	    @JsonProperty("dscAtivDes_22")
	    private String dscAtivDes22;

	    @JsonProperty("obsCompl_84")
	    private String obsCompl84;

	    @JsonProperty("agnoc_150")
	    private List<Agnoc150> agnoc150;


}
