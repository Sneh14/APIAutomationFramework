package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.reponse.LoginResponse;
import com.api.models.reponse.UserProfileResponse;
import com.api.models.requests.LoginRequestModel;
import com.api.models.requests.ProfileRequestModel;

import io.restassured.response.Response;

public class UpdateProfileTests {

	@Test
	public void updateProfile() {
		AuthService authService = new AuthService();
		Response response = authService.Login(new LoginRequestModel("Tom111", "password111"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		UserManagementService userManagementService = new UserManagementService();
		ProfileRequestModel profileRequestModel = new ProfileRequestModel.Builder()
				.firstName("Tom1114")
				.lastName("Tom1114")
				.mobileNumber("7777777777")
				.email("Tom1114@gmail.com")
				.build();
		response = userManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		response = userManagementService.updateProfile(loginResponse.getToken(), profileRequestModel);
		System.out.println(response.asPrettyString());
	}
}
