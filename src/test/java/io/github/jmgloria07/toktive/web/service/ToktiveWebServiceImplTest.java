package io.github.jmgloria07.toktive.web.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.api.Toktive;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

public class ToktiveWebServiceImplTest {

	private static ToktiveWebServiceImpl unit;
	
	private static final String TEST_MESSAGE = "This is a test message";
	private static final List<ToktiveResponse> MOCK_API_RESPONSE = Arrays.asList(new ToktiveResponse());
	private static final List<String> MOCK_NETWORKS = Arrays.asList("FB", "TW");
	
	@BeforeAll
	public static void init() {
		unit = new ToktiveWebServiceImpl();
		unit.toktive = mock(Toktive.class);
		
		doReturn(MOCK_API_RESPONSE).when(unit.toktive).share(anyString(), anySet());
	}
	
	@Test
	public void testShare() {
		assertNotNull(unit.share(TEST_MESSAGE, MOCK_NETWORKS));
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
