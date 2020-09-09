package io.github.jmgloria07.toktive.web.service;

import java.util.List;

import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;
import io.github.jmgloria07.toktive.web.objects.SocialNetworkResponse;

public interface ToktiveWebService {
	
	public List<ToktiveResponse> share(String message, List<String> networks);
	
	public List<SocialNetworkResponse> getSocialNetworks();
}
