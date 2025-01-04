package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S2230Item {
	
	@NotNull(message = "O campo 'indRetif_4' não pode ser vazio")
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
	@Size(min = 1, max = 1)
    @JsonProperty("procEmi_7")
    private String procEmi_7;
	@NotNull(message = "O campo 'verProc_8' não pode ser vazio")
	@Size(min = 1, max = 20)
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
	@Size(min = 1, max = 3)
    @JsonProperty("codCateg_60")
    private String codCateg_60;
	@NotNull(message = "O campo 'dtIniAfast_18' não pode ser vazio")
    @JsonProperty("dtIniAfast_18")
    private String dtIniAfast_18;
	@NotNull(message = "O campo 'codMotAfast_19' não pode ser vazio")
	@Size(min = 2, max = 2, message = "deve ter no minimo 2 caractere")
    @JsonProperty("codMotAfast_19")
    private String codMotAfast_19;
	@Size(min = 1, max = 1, message = "deve ter no minimo 1 caractere")
    @JsonProperty("infoMesmoMtv_20")
    private String infoMesmoMtv_20;
	@Size(min = 1, max = 1, message = "deve ter no minimo 1 caractere")
    @JsonProperty("tpAcidTransito_21")
    private String tpAcidTransito_21;
	@Size(min = 1, max = 255, message = "deve ter no minimo 1 e no máximo 255 caractere")
    @JsonProperty("observacao_22")
    private String observacao_22;
	@NotNull(message = "O campo 'dtInicio_61' não pode ser vazio")
    @JsonProperty("dtInicio_61")
    private String dtInicio_61;
    @JsonProperty("dtFim_62")
    private String dtFim_62;
    @NotNull(message = "O campo 'cnpjCess_32' não pode ser vazio")
	@Size(min = 14, max = 14, message = "deve ter no minimo 14 caractere")
    @JsonProperty("cnpjCess_32")
    private String cnpjCess_32;
    @NotNull(message = "O campo 'infOnus_33' não pode ser vazio")
   	@Size(min = 1, max = 1, message = "deve ter no minimo 1 caractere")
    @JsonProperty("infOnus_33")
    private String infOnus_33;
    @NotNull(message = "O campo 'cnpjSind_35' não pode ser vazio")
   	@Size(min = 14, max = 14, message = "deve ter no minimo 14 caractere")
    @JsonProperty("cnpjSind_35")
    private String cnpjSind_35;
    @NotNull(message = "O campo 'infOnusRemun_36' não pode ser vazio")
   	@Size(min = 1, max = 1, message = "deve ter no minimo 1 caractere")
    @JsonProperty("infOnusRemun_36")
    private String infOnusRemun_36;
    @NotNull(message = "O campo 'cnpjMandElet_63' não pode ser vazio")
   	@Size(min = 14, max = 14, message = "deve ter no minimo 14 caractere")
    @JsonProperty("cnpjMandElet_63")
    private String cnpjMandElet_63;
    @Size(min = 1, max = 1, message = "deve ter no minimo 1 caractere")
    @JsonProperty("indRemunCargo_64")
    private String indRemunCargo_64;
    @NotNull(message = "O campo 'origRetif_57' não pode ser vazio")
   	@Size(min = 1, max = 1, message = "deve ter no minimo 1 caractere")
    @JsonProperty("origRetif_57")
    private String origRetif_57;
   	@Size(min = 1, max = 1, message = "deve ter no minimo 1 caractere")
    @JsonProperty("tpProc_58")
    private String tpProc_58;
   	@Size(min = 10, max = 21, message = "deve ter no minimo 10 e no máximo 21 caractere")
    @JsonProperty("nrProc_59")
    private String nrProc_59;
   	@NotNull(message = "O campo 'dtTermAfast_53' não pode ser vazio")
    @JsonProperty("dtTermAfast_53")
    private String dtTermAfast_53;

}
