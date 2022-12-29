package com.test.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.api.businesslogic.GetAirlines;
import com.test.api.utils.EndPoints;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("This is the feature to validate the get Airlines API")
public class GetAirlinesTest extends BaseTest{
	GetAirlines getAirlines;
	
	@Test (priority=1)
	@Description("Airlines API validation")
	public void validateStatusCode() throws IOException {
		getAirlines = new GetAirlines();
		int actualStatusCode = getAirlines.validateGetAirlineStatus(init()+EndPoints.getAirlinesEndpoint);
		org.testng.Assert.assertEquals(actualStatusCode, 200);
	}
	
	@Test (priority=2)
	@Description("Airlines Name attribute validation")
	public void validateName() throws IOException {
	String name = getAirlines.ValidateNameOfAirliness(init()+EndPoints.getAirlinesEndpoint, "name");
    Assert.assertEquals(name, "Quatar Airways");		
	}
			
	
	
}
