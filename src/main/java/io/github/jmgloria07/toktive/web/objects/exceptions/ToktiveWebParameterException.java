package io.github.jmgloria07.toktive.web.objects.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ToktiveWebParameterException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6625064972045902834L;
	private static final String ERROR_MESSAGE = "Invalid Parameter";
	
	public ToktiveWebParameterException() {
		super(ERROR_MESSAGE);
	}
	
	public ToktiveWebParameterException(String field) {
		super(ERROR_MESSAGE + ": " + field);
	}
}
