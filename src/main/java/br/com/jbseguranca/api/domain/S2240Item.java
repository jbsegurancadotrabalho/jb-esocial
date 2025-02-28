package br.com.jbseguranca.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class S2240Item {

	@NotNull(message = "O campo 'indRetif_4' não pode ser vazio")
	@JsonProperty("indRetif_4")
	private String indRetif4;

	@NotNull(message = "O campo 'nrRecibo_5' não pode ser vazio")
	@Size(max = 23, message = "Recibo deve ter no máximo 23 caracteres")
	@JsonProperty("nrRecibo_5")
	private String nrRecibo5;

	@NotNull(message = "O campo 'tpAmb_6' não pode ser vazio")
	@JsonProperty("tpAmb_6")
	private String tpAmb6;

	@NotNull(message = "O campo 'procEmi_7' não pode ser vazio")
	@JsonProperty("procEmi_7")
	private String procEmi7;

	@NotNull(message = "O campo 'verProc_8' não pode ser vazio")
	@JsonProperty("verProc_8")
	private String verProc8;

	@NotNull(message = "O campo 'tpInsc_10' não pode ser vazio")
	@Size(min = 1, max = 1)
	@JsonProperty("tpInsc_10")
	private String tpInsc10;

	@NotNull(message = "O campo 'nrInsc_11' não pode ser vazio")
	@Size(min = 8, max = 14, message = "deve ter entre 8 e 14 caracteres")
	@JsonProperty("nrInsc_11")
	private String nrInsc11;

	@NotNull(message = "O campo 'cpfTrab_13' não pode ser vazio")
	@Size(min = 11, max = 11, message = "deve ter 11 caracteres")
	@JsonProperty("cpfTrab_13")
	private String cpfTrab13;

	@NotNull(message = "O campo 'matricula_15' não pode ser vazio")
	@Size(min = 1, max = 30, message = "deve ter no minimo 1 e no máximo 30 caracteres")
	@JsonProperty("matricula_15")
	private String matricula15;

	@Size(min = 3, max = 33, message = "deve ter 3 caracteres")
	@JsonProperty("codCateg_85")
	private String codCateg85;

	@NotNull(message = "O campo 'dtIniCondicao_18' não pode ser vazio")
	@JsonProperty("dtIniCondicao_18")
	private String dtIniCondicao18;

	@JsonProperty("dtFimCondicao_113")
	private String dtFimCondicao113;

	@NotNull(message = "O campo 'dscAtivDes_22' não pode ser vazio")
	@JsonProperty("dscAtivDes_22")
	private String dscAtivDes22;

	@NotNull(message = "O campo 'obsCompl_84' não pode ser vazio")
	@JsonProperty("obsCompl_84")
	private String obsCompl84;

	@JsonProperty("agnoc_150")
	private List<Agnoc150> agnoc150;

}
