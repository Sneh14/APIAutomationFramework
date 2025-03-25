package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForGotPassword {

	@Test
	public  void forgotPassword() {
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("Jerry2@Yahoo.com");
		System.out.println(response.asPrettyString());
	}
}
