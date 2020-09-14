package io.github.jmgloria07.toktive.web.objects.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToktiveWebSocialNetworkNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5458489650013194347L;
	private static final String ERROR_MESSAGE = "Social Network not found";
	
	public ToktiveWebSocialNetworkNotFoundException() {
		super(ERROR_MESSAGE);
	}
	
	public ToktiveWebSocialNetworkNotFoundException(String socialNetwork) {
		super(ERROR_MESSAGE + ": " + socialNetwork);
	}

}
