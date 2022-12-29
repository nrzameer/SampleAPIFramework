package com.test.testcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.test.api.utils.ConfigFileProcess;
import com.test.api.utils.EndPoints;
import com.test.mock.MockServices;


public class BaseTest {
	MockServices m ;
	
	@BeforeSuite
	public String init() throws IOException {
		m = new MockServices();
		m.initServer();
		m.getAirlinesMock(EndPoints.getAirlinesEndpoint);
		
		ConfigFileProcess config = new ConfigFileProcess();
		String baseUrl = config.loadPropertiesFile("config.properties", "api.baseurl");
	    return baseUrl;
	}
	
	@AfterSuite
	public void afterSuite() {
		m.closeServer();
	}

}
