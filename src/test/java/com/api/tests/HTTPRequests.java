package com.api.tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {

	int id;
	
	@Test(priority = 1)
	public void getUser() {
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).body("page",equalTo(2)).log().all();
	}
	
	@Test(priority =2)
	public void createUser() {
		
		HashMap<String,String> data = new HashMap();
		data.put("name", "Tom");
		data.put("job", "Tester");
		
	id = given().contentType("application/json").body(data)
		
		.when().post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		//.then().statusCode(201).body("name", equalTo("Tom")).log().all();
	}
	
	@Test(priority =3 , dependsOnMethods  = {"createUser"})
	public void updateUser() {
		
		HashMap<String,String> data = new HashMap();
		data.put("name", "Tom");
		data.put("job", "Developer");
		
		given().contentType("Application/JSON")
		.body(data)
		
		.when().put("https://reqres.in/api/users/"+id)
		
		.then().statusCode(200).log().all();
	}
	
	@Test(priority = 4)
	public void deleteUser() {
		given()
		
		.when().delete("https://reqres.in/api/users/"+id)
		
		.then().statusCode(204).log().all();
	}
}
