package br.com.jbseguranca.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S2220Item {
	
	 @JsonProperty("indRetif_4")
	    private String indRetif_4;

	    @JsonProperty("nrRecibo_5")
	    private String nrRecibo_5;

	    @JsonProperty("tpAmb_6")
	    private String tpAmb_6;

	    @JsonProperty("procEmi_7")
	    private String procEmi_7;

	    @JsonProperty("verProc_8")
	    private String verProc_8;

	    @JsonProperty("tpInsc_10")
	    private String tpInsc_10;

	    @JsonProperty("nrInsc_11")
	    private String nrInsc_11;

	    @JsonProperty("cpfTrab_13")
	    private String cpfTrab_13;

	    @JsonProperty("matricula_15")
	    private String matricula_15;

	    @JsonProperty("codCateg_49")
	    private String codCateg_49;

	    @JsonProperty("tpExameOcup_42")
	    private String tpExameOcup_42;

	    @JsonProperty("dtAso_17")
	    private String dtAso_17;

	    @JsonProperty("resAso_19")
	    private String resAso_19;

	    @JsonProperty("nmMed_38")
	    private String nmMed_38;

	    @JsonProperty("nrCRM_40")
	    private String nrCRM_40;

	    @JsonProperty("ufCRM_41")
	    private String ufCRM_41;

	    @JsonProperty("cpfResp_45")
	    private String cpfResp_45;

	    @JsonProperty("nmResp_46")
	    private String nmResp_46;

	    @JsonProperty("nrCRM_50")
	    private String nrCRM_50;

	    @JsonProperty("ufCRM_51")
	    private String ufCRM_51;

	    @JsonProperty("EXAME_60")
	    private List<Exame> exame60;

}
