package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Epi151 {
	@NotNull(message = "O campo 'docAval_110' não pode ser vazio")
	@Size(min = 1, max = 255, message = "deve ter no minimo 1 e no máximo 255 caracteres")
	@JsonProperty("docAval_110")
	private String docAval110;

}
