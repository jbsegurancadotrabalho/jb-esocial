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
public class Agnoc150 {

	@NotNull(message = "O campo 'codAgNoc_94' não pode ser vazio")
	@Size(min = 9, max = 9, message = "deve ter 9 caracteres numerico")
	@JsonProperty("codAgNoc_94")
	private String codAgNoc94;
	
	@Size(min = 1, max = 100, message = "deve ter no minimo 1 e no máximo 100 caracteres")
	@JsonProperty("dscAgNoc_95")
	private String dscAgNoc95;
	
	@Size(min = 1, max = 1, message = "deve ter 1 caractere numerico")
	@JsonProperty("tpAval_96")
	private String tpAval96;
	
	@Size(min = 1, max = 10, message = "deve ter 1 caractere numerico OBS: campos decimais")
	@JsonProperty("intConc_97")
	private String intConc97;
	
	@Size(min = 1, max = 10, message = "deve ter 1 caractere numerico OBS: campos decimais")
	@JsonProperty("limTol_98")
	private String limTol98;
	
	@Size(min = 1, max = 2, message = "deve ter no minimo 1 e no máximo 2 caracteres")
	@JsonProperty("unMed_99")
	private String unMed99;
	
	@Size(min = 1, max = 40, message = "deve ter no minimo 1 e no máximo 40 caracteres")
	@JsonProperty("tecMedicao_100")
	private String tecMedicao100;

	@NotNull(message = "O campo 'utilizEPC_101' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere numerico. 0 - Não se aplica, 1 - Não implementa e 2 - Implementa")
	@JsonProperty("utilizEPC_101")
	private String utilizEPC101;

	@Size(min = 1, max = 1, message = "deve ter 1 caractere alfanumerico S = Sim e N = Não")
	@JsonProperty("eficEpc_102")
	private String eficEpc102;

	@NotNull(message = "O campo 'utilizEPI_103' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caracteres numerico. 0 - Não se aplica, 1 - Não utilizado e 2 - Utilizado")
	@JsonProperty("utilizEPI_103")
	private String utilizEPI103;

	@Size(min = 1, max = 1, message = "deve ter 1 caractere alfanumerico S = Sim e N = Não")
	@JsonProperty("eficEpi_112")
	private String eficEpi112;

	@JsonProperty("epi_151")
	private List<Epi151> epi151;

	@NotNull(message = "O campo 'medProtecao_104' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere alfanumerico S = Sim e N = Não")
	@JsonProperty("medProtecao_104")
	private String medProtecao104;
	
	@NotNull(message = "O campo 'condFuncto_105' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere alfanumerico S = Sim e N = Não")
	@JsonProperty("condFuncto_105")
	private String condFuncto105;

	@NotNull(message = "O campo 'usoInint_106' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere alfanumerico S = Sim e N = Não")	
	@JsonProperty("usoInint_106")
	private String usoInint106;

	
	@NotNull(message = "O campo 'przValid_107' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere alfanumerico S = Sim e N = Não")
	@JsonProperty("przValid_107")
	private String przValid107;

	
	@NotNull(message = "O campo 'periodicTroca_108' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere alfanumerico S = Sim e N = Não")
	@JsonProperty("periodicTroca_108")
	private String periodicTroca108;

	
	@NotNull(message = "O campo 'higienizacao_109' não pode ser vazio")
	@Size(min = 1, max = 1, message = "deve ter 1 caractere alfanumerico S = Sim e N = Não")
	@JsonProperty("higienizacao_109")
	private String higienizacao109;

	@JsonProperty("respreg_152")
	private List<Respreg152> respreg152;

	@JsonProperty("infoamb_153")
	private List<Infoamb153> infoamb153;

}
