package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S2210Item {

    private String indRetif4;

    private String nrRecibo5;

    private String tpAmb;

    private String procEmi;

    private String verProc;

    private String tpInsc;

    private String nrInsc;

    private String cpfTrab;

    private String matricula;

    private String codCateg;

    private String dtAcid;

    private String tpAcid;

    private String hrAcid;

    private String hrsTrabAntesAcid;

    private String tpCat;

    private String indCatObito;

    private String dtObito;

    private String indComunPolicia;

    private String codSitGeradora;

    private String iniciatCAT;

    private String obsCAT;

    private String ultDiaTrab;

    private String houveAfast;

    private String tpLocal;

    private String dscLocal;

    private String tpLograd;

    private String dscLograd;

    private String nrLograd;

    private String complemento;

    private String bairro;

    private String cep;

    private String codMunic;

    private String uf;

    private String pais;

    private String codPostal;

    private String tpInsc77;

    private String nrInsc78;

    private String codParteAting;

    private String lateralidade;

    private String codAgntCausador;

    private String dtAtendimento;

    private String hrAtendimento;

    private String indInternacao;

    private String durTrat;

    private String indAfast;

    private String dscLesao;

    private String dscCompLesao;

    private String diagProvavel;

    private String codCID;
    private String observacao;

    private String nmEmit;

    private String ideOC;

    private String nrOC;

    private String ufOC;

    private String nrRecCatOrig;

    @JsonCreator
	public S2210Item(String indRetif4, String nrRecibo5, String tpAmb, String procEmi, String verProc, String tpInsc,
			String nrInsc, String cpfTrab, String matricula, String codCateg, String dtAcid, String tpAcid,
			String hrAcid, String hrsTrabAntesAcid, String tpCat, String indCatObito, String dtObito,
			String indComunPolicia, String codSitGeradora, String iniciatCAT, String obsCAT, String ultDiaTrab,
			String houveAfast, String tpLocal, String dscLocal, String tpLograd, String dscLograd, String nrLograd,
			String complemento, String bairro, String cep, String codMunic, String uf, String pais, String codPostal,
			String tpInsc77, String nrInsc78, String codParteAting, String lateralidade, String codAgntCausador,
			String dtAtendimento, String hrAtendimento, String indInternacao, String durTrat, String indAfast,
			String dscLesao, String dscCompLesao, String diagProvavel, String codCID, String observacao, String nmEmit,
			String ideOC, String nrOC, String ufOC, String nrRecCatOrig) {
		super();
		this.indRetif4 = indRetif4;
		this.nrRecibo5 = nrRecibo5;
		this.tpAmb = tpAmb;
		this.procEmi = procEmi;
		this.verProc = verProc;
		this.tpInsc = tpInsc;
		this.nrInsc = nrInsc;
		this.cpfTrab = cpfTrab;
		this.matricula = matricula;
		this.codCateg = codCateg;
		this.dtAcid = dtAcid;
		this.tpAcid = tpAcid;
		this.hrAcid = hrAcid;
		this.hrsTrabAntesAcid = hrsTrabAntesAcid;
		this.tpCat = tpCat;
		this.indCatObito = indCatObito;
		this.dtObito = dtObito;
		this.indComunPolicia = indComunPolicia;
		this.codSitGeradora = codSitGeradora;
		this.iniciatCAT = iniciatCAT;
		this.obsCAT = obsCAT;
		this.ultDiaTrab = ultDiaTrab;
		this.houveAfast = houveAfast;
		this.tpLocal = tpLocal;
		this.dscLocal = dscLocal;
		this.tpLograd = tpLograd;
		this.dscLograd = dscLograd;
		this.nrLograd = nrLograd;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.codMunic = codMunic;
		this.uf = uf;
		this.pais = pais;
		this.codPostal = codPostal;
		this.tpInsc77 = tpInsc77;
		this.nrInsc78 = nrInsc78;
		this.codParteAting = codParteAting;
		this.lateralidade = lateralidade;
		this.codAgntCausador = codAgntCausador;
		this.dtAtendimento = dtAtendimento;
		this.hrAtendimento = hrAtendimento;
		this.indInternacao = indInternacao;
		this.durTrat = durTrat;
		this.indAfast = indAfast;
		this.dscLesao = dscLesao;
		this.dscCompLesao = dscCompLesao;
		this.diagProvavel = diagProvavel;
		this.codCID = codCID;
		this.observacao = observacao;
		this.nmEmit = nmEmit;
		this.ideOC = ideOC;
		this.nrOC = nrOC;
		this.ufOC = ufOC;
		this.nrRecCatOrig = nrRecCatOrig;
	}
    
    
}
