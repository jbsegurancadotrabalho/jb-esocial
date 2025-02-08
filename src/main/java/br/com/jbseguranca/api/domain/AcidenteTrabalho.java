package br.com.jbseguranca.api.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "acidente_trabalho")
public class AcidenteTrabalho {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@ApiModelProperty(value = "CPF/CNPJ do transmissor", required = true)
	@JsonProperty("cpfcnpjtransmissor")
	private String cpfCnpjTransmissor;
	@JsonProperty("cpfcnpjempregador")
	private String cpfCnpjEmpregador;
	@JsonProperty("idgrupoeventos")
	private String idGrupoEventos;
	@JsonProperty("versaomanual")
	private String versaoManual;
	@JsonProperty("ambiente")
	private String ambiente;
	@JsonProperty("s2210")
	@OneToMany(mappedBy = "acidenteTrabalho", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<S2210Item> s2210 = new HashSet<>();
}
