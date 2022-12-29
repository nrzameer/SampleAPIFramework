package com.test.testcases;

import java.io.IOException;
import org.testng.annotations.BeforeSuite;
import com.test.api.utils.ConfigFileProcess;


public class BaseTest {
	
	@BeforeSuite
	public String init() throws IOException {
		ConfigFileProcess config = new ConfigFileProcess();
		String baseUrl = config.loadPropertiesFile("config.properties", "api.baseurl");
	    return baseUrl;
	}

}
