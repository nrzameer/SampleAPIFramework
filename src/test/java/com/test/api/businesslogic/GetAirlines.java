package com.test.api.businesslogic;

import com.test.api.wrapper.Validators;

import io.qameta.allure.Step;

public class GetAirlines {
	
	@Step("Validation of GetAirlines status code")
	public int validateGetAirlineStatus(String uri) {
		int getAirlinesStatusCode = Validators
				.checkSuccessCode(uri);
		return getAirlinesStatusCode;
	}
	
	@Step("Validation of Name of GetAirlines API")
	public String ValidateNameOfAirliness(String uri, String key) {
		return Validators.checkExpectedValue(uri, key);
	}
}
