package io.github.jmgloria07.toktive.web.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.Toktive;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.ToktiveError;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;
import io.github.jmgloria07.toktive.web.objects.SocialNetworkResponse;
import io.github.jmgloria07.toktive.web.objects.SocialNetworkWeb;
import io.github.jmgloria07.toktive.web.objects.ToktiveCallWeb;
import io.github.jmgloria07.toktive.web.objects.ToktiveWebResponse;
import io.github.jmgloria07.toktive.web.objects.ToktiveWebResponse.Status;
import io.github.jmgloria07.toktive.web.objects.exceptions.ToktiveWebSocialNetworkNotFoundException;

@Component
public class ToktiveWebServiceImpl implements ToktiveWebService {

	@Autowired
	Toktive toktive;
	
	@Override
	public ToktiveWebResponse share(String message, List<String> networks) {
		//use Toktive API to share a post to all networks
		//TODO: catch runtime exceptions from the API
		List<ToktiveResponse> apiResponseList = toktive.share(message, new HashSet<>(networks));
		
		//parse callList from the response from the API
		List<ToktiveCallWeb> callList = apiResponseList.stream()
				.map(ToktiveWebServiceImpl::buildCallList)
				.collect(Collectors.toList());
		
		//set other data based from parsed callList to create response
		ToktiveWebResponse webResponse = new ToktiveWebResponse();
		webResponse.setPost(message);
		webResponse.setCalls(callList);
		webResponse.setCount(callList.size());
		webResponse.setStatus(parseStatus(callList));
		
		return webResponse;
	}

	//getSocialNetwork implementation which basically parses SocialNetwork enum from the API
	//to a SocialNetworkResponse object
	@Override
	public SocialNetworkResponse getSocialNetworks() {
		SocialNetworkResponse response = new SocialNetworkResponse();
		
		//create the list of social networks
		List<SocialNetworkWeb> socialNetworks = Arrays.stream(SocialNetwork.values())
				.map(ToktiveWebServiceImpl::buildSnResponse)
				.collect(Collectors.toList());
		
		//use the created list to generate the other data
		response.setSocialNetworks(socialNetworks);
		response.setCount(socialNetworks.size());
		response.setDeprecatedCount(
					(int) socialNetworks.stream()
					.filter(SocialNetworkWeb::isDeprecated)
					.count()
				);
		
		return response;
	}
	
	//single getSocialNetwork implementation which basically parses SocialNetwork enum from the API
	//to a SocialNetworkWeb object
	@Override
	public SocialNetworkWeb getSocialNetworks(String network) {
		return Arrays.stream(SocialNetwork.values())
				.filter(networkFromEnum -> networkFromEnum.toString().equalsIgnoreCase(network))
				.findFirst()
				.map(ToktiveWebServiceImpl::buildSnResponse)
				.orElseThrow(() -> new ToktiveWebSocialNetworkNotFoundException(network));
	}
	
	//utility methods used in this class
	
	//mapper method for ToktiveWebResponse
	private static ToktiveCallWeb buildCallList(ToktiveResponse apiCall) {
		ToktiveCallWeb webCall = new ToktiveCallWeb();
		webCall.setLink(apiCall.getUrl());
		webCall.setErrorMessage(
				Optional.ofNullable(apiCall.getError())
					.map(ToktiveError::getErrorMessage)
					.orElse(null));
		webCall.setStatus(
				Optional.ofNullable(apiCall.getStatus())
				.map(status -> ToktiveCallWeb.Status.valueOf(status.toString()))
				.orElse(null));
		return webCall;
	}
	
	//mapper method for SocialNetworkWeb
	private static SocialNetworkWeb buildSnResponse(SocialNetwork socialNetwork) {
		SocialNetworkWeb response = new SocialNetworkWeb();
		response.setDeprecated(socialNetwork.isDeprecated());
		response.setDisplayName(socialNetwork.getDisplayName());
		response.setValue(socialNetwork.toString());
		return response;
	}
	
	//method to create a status enum value
	private static Status parseStatus(List<ToktiveCallWeb> callResponses) {
		long successCount = callResponses.stream()
				.map(ToktiveCallWeb::getStatus)
				.filter(status -> status == ToktiveCallWeb.Status.SUCCESS)
				.count();
		long count = callResponses.size();
		
		if (count == successCount) return Status.SUCCESS;
		else if (successCount > 0) return Status.PARTIAL;
		else return Status.FAIL;
	}
	
	//spring beans	
	@Bean
	public Toktive toktive() {
		return Toktive.getInstance();
	}



}
