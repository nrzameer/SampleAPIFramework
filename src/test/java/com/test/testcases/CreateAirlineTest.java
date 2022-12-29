package com.test.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.api.businesslogic.CreateAirline;
import com.test.api.requestpojos.CreateAirlineRequest;
import com.test.api.utils.EndPoints;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

@Feature("This is the feature to validate the creation of Airline API")
	public class CreateAirlineTest extends BaseTest{

	CreateAirline createAirline;
	CreateAirlineRequest createairlinerequest;
	Response response;
	
	@Test (priority=1)
	@Description("Create Airline using data provided")
	public void validateCreateAirline() throws JsonProcessingException, IOException {
		createAirline = new CreateAirline();
		response = createAirline.createAirline(init()+EndPoints.createAirlineEndpoint, 10000456, "Roshan Airway", "India",
				 "Sample logo", "From India", "India", "http:qacrunch.com", "2022");
	  Assert.assertEquals(response.statusCode(), 201);
	}
}
