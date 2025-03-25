package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.reponse.LoginResponse;
import com.api.models.requests.LoginRequestModel;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//@Listeners(com.api.listener.TestListener.class)
public class LoginTest {
	
	
	@Test(description = "Verify if Login API is working")
	public void loginTest() {
		AuthService authService = new AuthService();
		LoginRequestModel loginRequest = new LoginRequestModel("Tom1114", "Tom1114");
		Response response = authService.Login(loginRequest);
	    LoginResponse loginResponse =  response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "Tom1114@gmail.com");
		//Assert.assertEquals(loginResponse.getId(), 3);
	}
}
