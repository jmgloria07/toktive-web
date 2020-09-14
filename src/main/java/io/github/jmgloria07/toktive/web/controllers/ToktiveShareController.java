package io.github.jmgloria07.toktive.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.toktive.web.objects.SocialNetworkResponse;
import io.github.jmgloria07.toktive.web.objects.SocialNetworkWeb;
import io.github.jmgloria07.toktive.web.objects.ToktiveWebResponse;
import io.github.jmgloria07.toktive.web.service.ToktiveWebService;

@RestController
public class ToktiveShareController {

	@Autowired
	ToktiveWebService toktiveWebService;
	
	@PostMapping(value = "/toktive")
	public ToktiveWebResponse share(@RequestParam String message, 
			@RequestParam List<String> networks) {
		return toktiveWebService.share(message, networks);
	}
	
	@GetMapping(value = "/toktive")
	public SocialNetworkResponse getSocialNetworkData() {
		return toktiveWebService.getSocialNetworks();
	}
	
	@GetMapping(value = "/toktive/{network}")
	public SocialNetworkWeb getSocialNetworkData(@PathVariable String network) {
		return toktiveWebService.getSocialNetworks(network);
		
	}
	
	
}
