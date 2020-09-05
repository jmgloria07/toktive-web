package io.github.jmgloria07.toktive.web.service;

import java.util.List;

public interface ToktiveWebService {
	//TODO: make use of a proper response object
	public String share(String message, List<String> networks);
}
