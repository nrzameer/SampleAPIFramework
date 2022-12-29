package com.test.api.wrapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * This class has the common methods and methods to validate the response 
 * @author Roshan Zameer
 * 
 */

public class Validators {
	
	public static int checkSuccessCode(String uri) {
		int statusCode = RestAssured.given()
				.get(uri).andReturn().statusCode();
		return statusCode;
	}
	
	public static String checkExpectedValue(String uri, String key) {
		Response response = RestAssured.given().get(uri).andReturn();
		JsonPath jp = response.jsonPath();
		System.out.println("response is " + response);
		String expectedValue = jp.get(key);
		return expectedValue;
		
	}
	
	public static Response hitpostMethod(String uri, Object body) {
		Response response = RestAssured.given().contentType("application/json").and().body(body).post(uri);
		return response;
		
	}

}
