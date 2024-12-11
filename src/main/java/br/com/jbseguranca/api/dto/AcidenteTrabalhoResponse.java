package br.com.jbseguranca.api.dto;

import lombok.Data;

@Data
public class AcidenteTrabalhoResponse {
    private String id;
    private Status status;
    private String recibo;

    @Data
    public static class Status {
        private String codigo;
        private String mensagem;
    }
}

