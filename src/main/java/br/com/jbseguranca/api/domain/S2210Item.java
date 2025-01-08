package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class S2210Item {
	@NotNull(message = "não pode ser nulo")
    @JsonProperty("indRetif_4")
    private String indRetif_4;

    @NotNull(message = "não pode ser nulo")
    @Size(max = 23, message = "Recibo deve ter no máximo 23 caracteres")
    @JsonProperty("nrRecibo_5")
    private String nrRecibo_5;

    @NotNull(message = "não pode ser nulo")
    @Size(max = 1)
    @JsonProperty("tpAmb_6")
    private String tpAmb_6;

    @NotNull(message = "não pode ser nulo")
    @Size(min = 1, max = 2)
    @JsonProperty("procEmi_7")
    private String procEmi_7;

    @NotNull(message = "não pode ser nulo")
    @Size(min = 1, max = 20)
    @JsonProperty("verProc_8")
    private String verProc_8;

    @NotNull(message = "não pode ser nulo")
    @Size(max = 1)
    @JsonProperty("tpInsc_14")
    private String tpInsc_14;

    @Size(min = 8, max = 14, message = "deve ter entre 8 e 14 caracteres")
    @JsonProperty("nrInsc_15")
    private String nrInsc_15;

    @Size(max = 11, message = "deve ter no máximo 11 caracteres")
    @JsonProperty("cpfTrab_66")
    private String cpfTrab_66;

    @Size(min = 1, max = 30, message = "deve ter entre 1 e 30 caracteres")
    @JsonProperty("matricula_68")
    private String matricula_68;

    @Size(max = 3)
    @JsonProperty("codCateg_69")
    private String codCateg_69;

    @NotNull(message = "não pode ser nulo")
    @JsonProperty("dtAcid_20")
    private String dtAcid_20;
	@NotNull(message = "não pode ser nulo")
	@Size(max = 1)
	@JsonProperty("tpAcid_21")
    private String tpAcid_21;
	@NotNull(message = "não pode ser nulo")
	@Size(max = 4)
	@JsonProperty("hrAcid_22")
    private String hrAcid_22;
	@Size(max = 4)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("hrsTrabAntesAcid_23")
    private String hrsTrabAntesAcid_23;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("tpCat_24")
    private String tpCat_24;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("indCatObito_25")
	private String indCatObito_25;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("dtObito_26")
    private String dtObito_26;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("indComunPolicia_27")
    private String indComunPolicia_27;
	@Size(max = 9)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("codSitGeradora_28")
    private String codSitGeradora_28;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("iniciatCAT_29")
    private String iniciatCAT_29;
	@Size(min=1,max = 999)
	@JsonProperty("obsCAT_30")
    private String obsCAT_30;
	@JsonProperty("ultDiaTrab_79")
    private String ultDiaTrab_79;
    @NotNull(message = "não pode ser nulo")
    @Size(max = 1)
	@JsonProperty("indRetif_80")
    private String houveAfast_80;
    @Size(max = 1)
    @NotNull(message = "não pode ser nulo")
    @JsonProperty("tpLocal_32")
    private String tpLocal_32;
	@Size(min = 1, max = 255)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("dscLocal_33")
    private String dscLocal_33;
	@Size(min = 1, max = 4)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("tpLograd_76")
    private String tpLograd_76;
	@Size(min = 1, max = 100)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("dscLograd_34")
    private String dscLograd_34;
	@Size(min = 1, max = 10)
	@JsonProperty("nrLograd_35")
    private String nrLograd_35;
	
	@Size(min = 1, max = 30)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("complemento_73")
    private String complemento_73;
	@Size(min = 1, max = 90)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("bairro_74")
    private String bairro_74;
	@Size(min = 1, max = 8)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("cep_75")
    private String cep_75;
	@Size(min = 1, max = 7)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("codMunic_36")
    private String codMunic_36;
	@Size(min = 1, max = 2)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("uf_37")
    private String uf_37;
	@Size(min = 1, max = 3)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("pais_39")
    private String pais_39;
	@Size(min = 4, max = 12)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("codPostal_40")
    private String codPostal_40;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("tpInsc_77")
    private String tpInsc_77;
	@Size(max = 14)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("nrInsc_78")
    private String nrInsc_78;
	@Size(max = 9)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("codParteAting_42")
    private String codParteAting_42;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("indParteAting_43")
    private String lateralidade_43;
	@Size(max = 9)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("codAgntCausador_45")
    private String codAgntCausador_45;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("dtAtendimento_48")
    private String dtAtendimento_48;
	@Size(max = 4)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("hrAtendimento_49")
    private String hrAtendimento_49;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("indInternacao_50")
    private String indInternacao_50;
	@Size(min=1,max=4)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("durTrat_51")
    private String durTrat_51;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("indAfast_52")
    private String indAfast_52;
	@Size(max = 9)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("dscLesao_53")
    private String dscLesao_53;
	@Size(min=1, max = 200)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("dscCompLesao_54")
    private String dscCompLesao_54;
	@Size(min= 1,max = 100)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("diagProvavel_55")
    private String diagProvavel_55;
	@Size(min= 3,max = 4)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("codCID_56")
    private String codCID_56;
	@Size(min = 1, max=255)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("observacao_57")
    private String observacao_57;
	@Size(min = 2, max = 70)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("nmEmit_59")
    private String nmEmit_59;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("indIEmit_60")
    private String ideOC_60;
	@Size(min = 1, max = 14)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("nrOC_61")
    private String nrOC_61;
	@Size(min = 1, max = 2)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("ufOC_62")
    private String ufOC_62;
	@Size(max = 23)
	@NotNull(message = "não pode ser nulo")
	@JsonProperty("nrRecCatOrig_65")
    private String nrRecCatOrig_65;
    
    
    
}
