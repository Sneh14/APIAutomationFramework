package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.reponse.LoginResponse;
import com.api.models.reponse.UserProfileResponse;
import com.api.models.requests.LoginRequestModel;

import io.restassured.response.Response;

@Listeners(com.api.listener.TestListener.class)
public class GetProfileRequestTest {

	@Test
	public void getProfileInfo(){
		AuthService authService = new AuthService();
		Response response = authService.Login(new LoginRequestModel("Tom111", "password111"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
	}
}
