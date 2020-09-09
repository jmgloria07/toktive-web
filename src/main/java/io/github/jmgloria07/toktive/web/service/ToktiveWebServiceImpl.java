package io.github.jmgloria07.toktive.web.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.Toktive;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;
import io.github.jmgloria07.toktive.web.objects.SocialNetworkResponse;

@Component
public class ToktiveWebServiceImpl implements ToktiveWebService {

	@Override
	public List<ToktiveResponse> share(String message, List<String> networks) {
		Toktive toktive = Toktive.getInstance();
		return toktive.share(message, new HashSet<>(networks));
	}

	@Override
	public List<SocialNetworkResponse> getSocialNetworks() {
		return Arrays.stream(SocialNetwork.values())
				.map(ToktiveWebServiceImpl::buildSnResponse)
				.collect(Collectors.toList());
	}
	
	//mapper method for SocialNetworkResponse
	private static SocialNetworkResponse buildSnResponse(SocialNetwork socialNetwork) {
		SocialNetworkResponse response = new SocialNetworkResponse();
		response.setDeprecated(socialNetwork.isDeprecated());
		response.setDisplayName(socialNetwork.getDisplayName());
		response.setValue(socialNetwork.toString());
		return response;
	}

}
