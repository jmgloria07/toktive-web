package io.github.jmgloria07.toktive.web.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.Toktive;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

@Component
public class ToktiveWebServiceImpl implements ToktiveWebService {

	@Override
	public List<ToktiveResponse> share(String message, List<String> networks) {
		Toktive toktive = Toktive.getInstance();
		return toktive.share(message, new HashSet<>(networks));
	}

}
