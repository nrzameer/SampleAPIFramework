package com.test.api.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Config class to process the config file and to set the profiles
 * @author Roshan Zameer
 * 
 */
public class ConfigFileProcess {

	
	public String loadPropertiesFile(String filePath, String key) throws IOException {
		Properties prop = new Properties();
	    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
	    if (inputStream == null) {
	        throw new FileNotFoundException("Property File '" + filePath + "' not found in the classpath");
	    }
	    prop.load(inputStream);
	    String value = prop.getProperty(key);
	    inputStream.close();
		return value;
    }
	
}
