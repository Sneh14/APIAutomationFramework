package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequestModel;

import io.restassured.response.Response;


public class AccountCreationTest {

	@Test
	public void createAccountTest() {
		
		SignUpRequestModel signUpRequestModel= new SignUpRequestModel.Builder()
		.userName("Jerry2")
		.email("Jerry2@Yahoo.com")
		.firstName("Jerry2")
		.lastName("Jerry2")
		.password("Jerry2222")
		.mobileNumber("8569423715")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequestModel);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}
}
