package br.com.jbseguranca.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

import br.com.jbseguranca.api.dto.StatusEnvio;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<String> handleRestClientException(RestClientException ex) {
		ex.printStackTrace();
		return new ResponseEntity<>("Erro ao consumir a API externa.", HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		ex.printStackTrace();
		return new ResponseEntity<>("Ocorreu um erro interno.", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StatusEnvio> handleResourceNotFound(ResourceNotFoundException ex) {
	    StatusEnvio error = new StatusEnvio(
	        HttpStatus.NOT_FOUND.value(),
	        ex.getMessage()
	    );
	    return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body(error);
	}

	@ExceptionHandler(JbException.class)
	public ResponseEntity<StatusEnvio> handleJbException(JbException ex) {
		if (ex.getMessage().contains("não encontrado")) {
			StatusEnvio error = new StatusEnvio(HttpStatus.NOT_FOUND.value(), ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		} else {
			StatusEnvio error = new StatusEnvio(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}

}
