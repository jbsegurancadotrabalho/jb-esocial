package br.com.jbseguranca.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agnoc150 {
	
	@JsonProperty("codAgNoc_94")
    private String codAgNoc94;

    @JsonProperty("dscAgNoc_95")
    private String dscAgNoc95;

    @JsonProperty("tpAval_96")
    private String tpAval96;

    @JsonProperty("intConc_97")
    private String intConc97;

    @JsonProperty("limTol_98")
    private String limTol98;

    @JsonProperty("unMed_99")
    private String unMed99;

    @JsonProperty("tecMedicao_100")
    private String tecMedicao100;

    @JsonProperty("utilizEPC_101")
    private String utilizEPC101;

    @JsonProperty("eficEpc_102")
    private String eficEpc102;

    @JsonProperty("utilizEPI_103")
    private String utilizEPI103;

    @JsonProperty("eficEpi_112")
    private String eficEpi112;

    @JsonProperty("epi_151")
    private List<Epi151> epi151;

    @JsonProperty("medProtecao_104")
    private String medProtecao104;

    @JsonProperty("condFuncto_105")
    private String condFuncto105;

    @JsonProperty("usoInint_106")
    private String usoInint106;

    @JsonProperty("przValid_107")
    private String przValid107;

    @JsonProperty("periodicTroca_108")
    private String periodicTroca108;

    @JsonProperty("higienizacao_109")
    private String higienizacao109;

    @JsonProperty("respreg_152")
    private List<Respreg152> respreg152;

    @JsonProperty("infoamb_153")
    private List<Infoamb153> infoamb153;


}
