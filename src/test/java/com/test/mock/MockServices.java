package com.test.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.test.api.utils.EndPoints;


/**
 * This class the mock services details like to start and stop the mock server, 
 * mock the getAirlines
 * @author Roshan Zameer
 * 
 */
public class MockServices {
	
	private static final String host = "localhost";
	private static final int port = 8080;
	private static WireMockServer server = new WireMockServer();

	public void initServer() {
		server.start();
	}
	
	public void closeServer() {
		server.shutdownServer();
	}
	
	public void getAirlinesMock(String endpoint) {
		WireMock.configureFor(host, port);
		ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
		mockResponse.withStatus(200);
		mockResponse.withBodyFile("/index.json");
		WireMock.stubFor(WireMock.get(endpoint).willReturn(mockResponse));
	}
	
}
