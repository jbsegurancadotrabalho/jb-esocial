package br.com.jbseguranca.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcidenteTrabalho {
	
	    private String cpfCnpjTransmissor;
	    private String cpfCnpjEmpregador;
	    
	    private String idGrupoEventos;
	    
	    private String versaoManual;
	    
	    private String ambiente;
	    
	    private S2210Item s2210;

}