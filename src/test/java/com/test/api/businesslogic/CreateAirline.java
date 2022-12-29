package com.test.api.businesslogic;

import com.test.api.requestpojos.CreateAirlineRequest;
import com.test.api.wrapper.Validators;

import io.qameta.allure.Step;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

/**
 * This class has the business logic for creation of Airlines 
 * @author Roshan Zameer
 * 
 */

public class CreateAirline {
	CreateAirlineRequest createairlinerequest;
	
	@Step("Creation of Airline")
	public Response createAirline(String uri, int id, String name, String country, String logo,
			String slogan, String hq, String website, String estb) throws JsonProcessingException {
		createairlinerequest = new CreateAirlineRequest();
		createairlinerequest.setId(id);
		createairlinerequest.setName(name);
		createairlinerequest.setCountry(country);
		createairlinerequest.setLogo(logo);
		createairlinerequest.setSlogan(slogan);
		createairlinerequest.setHeadQuaters(hq);
		createairlinerequest.setWebsite(website);
		createairlinerequest.setEstablished(estb);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String createAirlineJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createairlinerequest);
		System.out.println(createAirlineJson);
		Response resp = Validators.hitpostMethod(uri, createAirlineJson);
		return resp;
		
	}

}
