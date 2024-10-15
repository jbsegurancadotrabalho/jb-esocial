package br.com.jbseguranca.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class JbException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JbException(String mensagem) {
		super(mensagem);
	}
}
