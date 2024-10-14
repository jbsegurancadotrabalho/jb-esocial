package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S2230Item {
	
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

    @JsonProperty("codCateg_60")
    private String codCateg_60;

    @JsonProperty("dtIniAfast_18")
    private String dtIniAfast_18;

    @JsonProperty("codMotAfast_19")
    private String codMotAfast_19;

    @JsonProperty("infoMesmoMtv_20")
    private String infoMesmoMtv_20;

    @JsonProperty("tpAcidTransito_21")
    private String tpAcidTransito_21;

    @JsonProperty("observacao_22")
    private String observacao_22;

    @JsonProperty("dtInicio_61")
    private String dtInicio_61;

    @JsonProperty("dtFim_62")
    private String dtFim_62;

    @JsonProperty("cnpjCess_32")
    private String cnpjCess_32;

    @JsonProperty("infOnus_33")
    private String infOnus_33;

    @JsonProperty("cnpjSind_35")
    private String cnpjSind_35;

    @JsonProperty("infOnusRemun_36")
    private String infOnusRemun_36;

    @JsonProperty("cnpjMandElet_63")
    private String cnpjMandElet_63;

    @JsonProperty("indRemunCargo_64")
    private String indRemunCargo_64;

    @JsonProperty("origRetif_57")
    private String origRetif_57;

    @JsonProperty("tpProc_58")
    private String tpProc_58;

    @JsonProperty("nrProc_59")
    private String nrProc_59;

    @JsonProperty("dtTermAfast_53")
    private String dtTermAfast_53;

}
