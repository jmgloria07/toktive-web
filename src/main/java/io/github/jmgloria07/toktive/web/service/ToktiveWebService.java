package io.github.jmgloria07.toktive.web.service;

import java.util.List;

import io.github.jmgloria07.toktive.web.objects.SocialNetworkResponse;
import io.github.jmgloria07.toktive.web.objects.SocialNetworkWeb;
import io.github.jmgloria07.toktive.web.objects.ToktiveWebResponse;

public interface ToktiveWebService {
	
	public ToktiveWebResponse share(String message, List<String> networks);
	
	public SocialNetworkResponse getSocialNetworks();
	
	public SocialNetworkWeb getSocialNetworks(String network);
}
