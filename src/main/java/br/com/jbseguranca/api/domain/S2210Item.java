package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S2210Item {
	@NotNull(message = "não pode ser nulo")
	private String indRetif_4;
	@NotNull(message = "não pode ser nulo")
	@Size(max = 23, message = "Recibo deve ter no máximo 23 caracteres")
    private String nrRecibo_5;
	@NotNull(message = "não pode ser nulo")
	@Size(max = 1)
    private String tpAmb_6;
	@NotNull(message = "não pode ser nulo")
	@Size(min = 1, max = 2)
    private String procEmi_7;
	@NotNull(message = "não pode ser nulo")
	@Size(min = 1, max = 20)
    private String verProc_8;
	@NotNull(message = "não pode ser nulo")
	@Size(max = 1)
    private String tpInsc_14;
	@Size( min = 8, max = 14, message = "deve ter entre 8 e 14 caracteres")
    private String nrInsc_15;
	@Size(max = 11, message = "deve ter no máximo 11 caracteres")
    private String cpfTrab_66;
	@Size(min=1, max=30, message = "deve ter entre 1 e 30 caracteres")
    private String matricula_68;
	@Size(max=3)
    private String codCateg_69;
	@NotNull(message = "não pode ser nulo")
    private String dtAcid_20;
	@NotNull(message = "não pode ser nulo")
	@Size(max = 1)
    private String tpAcid_21;
	@NotNull(message = "não pode ser nulo")
	@Size(max = 4)
    private String hrAcid_22;
	@Size(max = 4)
	@NotNull(message = "não pode ser nulo")
    private String hrsTrabAntesAcid_23;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String tpCat_24;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
	private String indCatObito_25;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String dtObito_26;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String indComunPolicia_27;
	@Size(max = 9)
	@NotNull(message = "não pode ser nulo")
    private String codSitGeradora_28;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String iniciatCAT_29;
	@Size(min=1,max = 999)
    private String obsCAT_30;
	
    private String ultDiaTrab_79;
    @NotNull(message = "não pode ser nulo")
    @Size(max = 1)
    private String houveAfast_80;
    @Size(max = 1)
    @NotNull(message = "não pode ser nulo")
    private String tpLocal_32;
	@Size(min = 1, max = 255)
	@NotNull(message = "não pode ser nulo")
    private String dscLocal_33;
	@Size(min = 1, max = 4)
	@NotNull(message = "não pode ser nulo")
    private String tpLograd_76;
	@Size(min = 1, max = 100)
	@NotNull(message = "não pode ser nulo")
    private String dscLograd_34;
	@Size(min = 1, max = 10)
    private String nrLograd_35;
	@Size(min = 1, max = 30)
	@NotNull(message = "não pode ser nulo")
    private String complemento_73;
	@Size(min = 1, max = 90)
	@NotNull(message = "não pode ser nulo")
    private String bairro_74;
	@Size(min = 1, max = 8)
	@NotNull(message = "não pode ser nulo")
    private String cep_75;
	@Size(min = 1, max = 7)
	@NotNull(message = "não pode ser nulo")
    private String codMunic_36;
	@Size(min = 1, max = 2)
	@NotNull(message = "não pode ser nulo")
    private String uf_37;
	@Size(min = 1, max = 3)
	@NotNull(message = "não pode ser nulo")
    private String pais_39;
	@Size(min = 4, max = 12)
	@NotNull(message = "não pode ser nulo")
    private String codPostal_40;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String tpInsc_77;
	@Size(max = 14)
	@NotNull(message = "não pode ser nulo")
    private String nrInsc_78;
	@Size(max = 9)
	@NotNull(message = "não pode ser nulo")
    private String codParteAting_42;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String lateralidade_43;
	@Size(max = 9)
	@NotNull(message = "não pode ser nulo")
    private String codAgntCausador_45;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String dtAtendimento_48;
	@Size(max = 4)
	@NotNull(message = "não pode ser nulo")
	@NotNull(message = "não pode ser nulo")
    private String hrAtendimento_49;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String indInternacao_50;
	@Size(min=1,max=4)
	@NotNull(message = "não pode ser nulo")
    private String durTrat_51;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String indAfast_52;
	@Size(max = 9)
	@NotNull(message = "não pode ser nulo")
    private String dscLesao_53;
	@Size(min=1, max = 200)
	@NotNull(message = "não pode ser nulo")
    private String dscCompLesao_54;
	@Size(min= 1,max = 100)
	@NotNull(message = "não pode ser nulo")
    private String diagProvavel_55;
	@Size(min= 3,max = 4)
	@NotNull(message = "não pode ser nulo")
    private String codCID_56;
	@Size(min = 1, max=255)
	@NotNull(message = "não pode ser nulo")
    private String observacao_57;
	@Size(min = 2, max = 70)
	@NotNull(message = "não pode ser nulo")
    private String nmEmit_59;
	@Size(max = 1)
	@NotNull(message = "não pode ser nulo")
    private String ideOC_60;
	@Size(min = 1, max = 14)
	@NotNull(message = "não pode ser nulo")
    private String nrOC_61;
	@Size(min = 1, max = 2)
	@NotNull(message = "não pode ser nulo")
    private String ufOC_62;
	@Size(max = 23)
	@NotNull(message = "não pode ser nulo")
    private String nrRecCatOrig_65;
    
    @JsonCreator
	public S2210Item(String indRetif_4, String nrRecibo_5, String tpAmb_6, String procEmi_7, String verProc_8,
			String tpInsc_14, String nrInsc_15, String cpfTrab_66, String matricula_68, String codCateg_69,
			String dtAcid_20, String tpAcid_21, String hrAcid_22, String hrsTrabAntesAcid_23, String tpCat_24,
			String indCatObito_25, String dtObito_26, String indComunPolicia_27, String codSitGeradora_28,
			String iniciatCAT_29, String obsCAT_30, String ultDiaTrab_79, String houveAfast_80, String tpLocal_32,
			String dscLocal_33, String tpLograd_76, String dscLograd_34, String nrLograd_35, String complemento_73,
			String bairro_74, String cep_75, String codMunic_36, String uf_37, String pais_39, String codPostal_40,
			String tpInsc_77, String nrInsc_78, String codParteAting_42, String lateralidade_43,
			String codAgntCausador_45, String dtAtendimento_48, String hrAtendimento_49, String indInternacao_50,
			String durTrat_51, String indAfast_52, String dscLesao_53, String dscCompLesao_54, String diagProvavel_55,
			String codCID_56, String observacao_57, String nmEmit_59, String ideOC_60, String nrOC_61, String ufOC_62,
			String nrRecCatOrig_65) {
		super();
		this.indRetif_4 = indRetif_4;
		this.nrRecibo_5 = nrRecibo_5;
		this.tpAmb_6 = tpAmb_6;
		this.procEmi_7 = procEmi_7;
		this.verProc_8 = verProc_8;
		this.tpInsc_14 = tpInsc_14;
		this.nrInsc_15 = nrInsc_15;
		this.cpfTrab_66 = cpfTrab_66;
		this.matricula_68 = matricula_68;
		this.codCateg_69 = codCateg_69;
		this.dtAcid_20 = dtAcid_20;
		this.tpAcid_21 = tpAcid_21;
		this.hrAcid_22 = hrAcid_22;
		this.hrsTrabAntesAcid_23 = hrsTrabAntesAcid_23;
		this.tpCat_24 = tpCat_24;
		this.indCatObito_25 = indCatObito_25;
		this.dtObito_26 = dtObito_26;
		this.indComunPolicia_27 = indComunPolicia_27;
		this.codSitGeradora_28 = codSitGeradora_28;
		this.iniciatCAT_29 = iniciatCAT_29;
		this.obsCAT_30 = obsCAT_30;
		this.ultDiaTrab_79 = ultDiaTrab_79;
		this.houveAfast_80 = houveAfast_80;
		this.tpLocal_32 = tpLocal_32;
		this.dscLocal_33 = dscLocal_33;
		this.tpLograd_76 = tpLograd_76;
		this.dscLograd_34 = dscLograd_34;
		this.nrLograd_35 = nrLograd_35;
		this.complemento_73 = complemento_73;
		this.bairro_74 = bairro_74;
		this.cep_75 = cep_75;
		this.codMunic_36 = codMunic_36;
		this.uf_37 = uf_37;
		this.pais_39 = pais_39;
		this.codPostal_40 = codPostal_40;
		this.tpInsc_77 = tpInsc_77;
		this.nrInsc_78 = nrInsc_78;
		this.codParteAting_42 = codParteAting_42;
		this.lateralidade_43 = lateralidade_43;
		this.codAgntCausador_45 = codAgntCausador_45;
		this.dtAtendimento_48 = dtAtendimento_48;
		this.hrAtendimento_49 = hrAtendimento_49;
		this.indInternacao_50 = indInternacao_50;
		this.durTrat_51 = durTrat_51;
		this.indAfast_52 = indAfast_52;
		this.dscLesao_53 = dscLesao_53;
		this.dscCompLesao_54 = dscCompLesao_54;
		this.diagProvavel_55 = diagProvavel_55;
		this.codCID_56 = codCID_56;
		this.observacao_57 = observacao_57;
		this.nmEmit_59 = nmEmit_59;
		this.ideOC_60 = ideOC_60;
		this.nrOC_61 = nrOC_61;
		this.ufOC_62 = ufOC_62;
		this.nrRecCatOrig_65 = nrRecCatOrig_65;
	}
    
    
}
