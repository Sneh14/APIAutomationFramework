package com.api.base;

import java.util.HashMap;

import com.api.models.requests.LoginRequestModel;
import com.api.models.requests.SignUpRequestModel;

import io.restassured.response.Response;

public class AuthService extends BaseService{

	private static final String BASE_PATH = "/api/auth/";
	
	public Response Login(LoginRequestModel payload) {
		return postRequest(payload, BASE_PATH+"login");
	}
	
	public Response signUp(SignUpRequestModel payload) {
		return postRequest(payload, BASE_PATH+"signup");
	}
	
	public Response forgotPassword(String emailAddress) {
		HashMap<String,String> payload = new HashMap<String, String>();
		payload.put("email", emailAddress);
		return postRequest(payload, BASE_PATH+"forgot-password");
	}
}
