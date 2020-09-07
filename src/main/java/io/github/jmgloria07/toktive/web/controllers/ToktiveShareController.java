package io.github.jmgloria07.toktive.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;
import io.github.jmgloria07.toktive.web.service.ToktiveWebService;

@RestController
public class ToktiveShareController {

	@Autowired
	ToktiveWebService toktiveWebService;
	
	//TODO create a proper request-response object
	@PostMapping(value = "/share")
	public List<ToktiveResponse> share(@RequestParam String message, 
			@RequestParam List<String> networks) {
		return toktiveWebService.share(message, networks);
	}
	
	@GetMapping(value = "/share")
	public String loadPage() {
		return "Please use POST";
	}
	
}
