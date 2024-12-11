package br.com.jbseguranca.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S2220Item {
	
	@NotNull(message = "O campo 'indRetif_4' não pode ser vazio\"")
	@JsonProperty("indRetif_4")
	private String indRetif_4;
	@NotNull(message = "O campo 'nrRecibo_5' não pode ser vazio")
	@Size(max = 23, message = "Recibo deve ter no máximo 23 caracteres")
	@JsonProperty("nrRecibo_5")
	private String nrRecibo_5;
	@NotNull(message = "O campo 'tpAmb_6' não pode ser vazio")
	@Size(max = 1)
	@JsonProperty("tpAmb_6")
	private String tpAmb_6;
	@NotNull(message = "O campo 'procEmi_7' não pode ser vazio")
	@Size(min = 1, max = 2)
	@JsonProperty("procEmi_7")
	private String procEmi_7;
	@NotNull(message = "O campo 'verProc_8' não pode ser vazio")
	@Size(min = 1, max = 20)
	@JsonProperty("verProc_8")
	private String verProc_8;
	@NotNull(message = "O campo 'tpInsc_10' não pode ser vazio")
	@Size(min = 1, max = 1)
	@JsonProperty("tpInsc_10")
	private String tpInsc_10;
	@NotNull(message = "O campo 'nrInsc_11' não pode ser vazio")
	@Size(min = 8, max = 14, message = "deve ter entre 8 e 14 caracteres")
	@JsonProperty("nrInsc_11")
	private String nrInsc_11;
	@NotNull(message = "O campo 'cpfTrab_13' não pode ser vazio")
	@Size(min = 11, max = 11, message = "deve ter 11 caracteres")
	@JsonProperty("cpfTrab_13")
	private String cpfTrab_13;
	@NotNull(message = "O campo 'matricula_15' não pode ser vazio")
	@Size(min = 1, max = 30, message = "deve ter no minimo 1 e no máximo 30 caracteres")
	@JsonProperty("matricula_15")
	private String matricula_15;
	@Size(min = 3, max = 3, message = "deve ter 3 caracteres")
	@JsonProperty("codCateg_49")
	private String codCateg_49;
	@NotNull(message = "O campo 'tpExameOcup_42' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caracteres")
	@JsonProperty("tpExameOcup_42")
	private String tpExameOcup_42;
	@NotNull(message = "O campo 'dtAso_17' não pode ser vazio")
	@JsonProperty("dtAso_17")
	private String dtAso_17;
	@NotNull(message = "O campo 'resAso_19' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caracteres")
	@JsonProperty("resAso_19")
	private String resAso_19;
	@NotNull(message = "O campo 'dtExm_21' não pode ser vazio")
	private String dtExm_21;
	@NotNull(message = "O campo 'procRealizado_22' não pode ser vazio")
	@Size(min = 4, max = 4, message = "deve ter 4 caracteres")
	private String procRealizado_22;
	@Size(min = 1, max = 1, message = "deve ter 1 caracteres")
	private String obsProc_23;
	@Size(min = 1, max = 1, message = "deve ter 1 caracteres")
	private String ordExame_25;
	@Size(min = 1, max = 1, message = "deve ter 1 caracteres")
	private String indResult_28;
	@NotNull(message = "O campo 'nmMed_38' não pode ser vazio")
	@Size(min = 2, max = 70, message = "deve ter entre 2 a 70 caracteres")
	@JsonProperty("nmMed_38")
	private String nmMed_38;
	@NotNull(message = "O campo 'nrCRM_40' não pode ser vazio")
	@Size(min = 1, max = 10, message = "deve ter entre 1 a 10 caracteres")
	@JsonProperty("nrCRM_40")
	private String nrCRM_40;
	@NotNull(message = "O campo 'ufCRM_41' não pode ser vazio")
	@Size(min = 2, max = 2, message = "UF do CRM do médico")
	@JsonProperty("ufCRM_41")
	private String ufCRM_41;
	@Size(min = 11, max = 11, message = "CPF do medico")
	@JsonProperty("cpfResp_45")
	private String cpfResp_45;
	@NotNull(message = "O campo 'nmResp_46' não pode ser vazio")
	@Size(min = 2, max = 70, message = "deve ter entre 1 a 70 caracteres")
	@JsonProperty("nmResp_46")
	private String nmResp_46;
	@NotNull(message = "O campo 'nrCRM_50' não pode ser vazio")
	@Size(min = 2, max = 70, message = "deve ter entre 1 a 10 caracteres")
	@JsonProperty("nrCRM_50")
	private String nrCRM_50;
	@NotNull(message = "O campo 'ufCRM_51' não pode ser vazio")
	@Size(min = 2, max = 2, message = "UF do CRM do médico")
	@JsonProperty("ufCRM_51")
	private String ufCRM_51;

	    @JsonProperty("EXAME_60")
	    private List<Exame> exame60;

}
