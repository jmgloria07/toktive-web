package io.github.jmgloria07.toktive.web.service;

import java.util.List;

import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

public interface ToktiveWebService {
	//TODO: make use of a proper response object
	public List<ToktiveResponse> share(String message, List<String> networks);
}
