package io.github.jmgloria07.toktive.web.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.Toktive;

@Component
public class ToktiveWebServiceImpl implements ToktiveWebService {

	@Override
	public String share(String message, List<String> networks) {
		Toktive toktive = Toktive.getInstance();
		toktive.share(message, new HashSet<>(networks));
		return "SUCCESS";
	}

}
