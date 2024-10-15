package br.com.jbseguranca.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handleRestClientException(RestClientException ex) {
        // Log da exceção
        ex.printStackTrace();
        return new ResponseEntity<>("Erro ao consumir a API externa.", HttpStatus.BAD_GATEWAY);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Log da exceção
        ex.printStackTrace();
        return new ResponseEntity<>("Ocorreu um erro interno.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
