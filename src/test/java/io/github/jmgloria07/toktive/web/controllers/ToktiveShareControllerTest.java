package io.github.jmgloria07.toktive.web.controllers;

import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.web.service.ToktiveWebService;

public class ToktiveShareControllerTest {
	private static ToktiveShareController unit;
	
	private static final String TEST_MESSAGE = "This is a test message";
	private static final List<String> MOCK_NETWORKS = Arrays.asList("FB", "TW");
	
	@BeforeAll
	public static void init() {
		unit = new ToktiveShareController();
		unit.toktiveWebService = mock(ToktiveWebService.class);
	}
	
	@Test
	public void testShare() {
		unit.share(TEST_MESSAGE, MOCK_NETWORKS);
	}
	
	@Test
	public void testGetSocialNetworks() {
		unit.getSocialNetworkData();
	}
	
	@Test
	public void testGetSingleSocialNetwork() {
		unit.getSocialNetworkData(MOCK_NETWORKS.get(0));
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
