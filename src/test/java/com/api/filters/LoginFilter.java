package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoginFilter implements Filter{

	private static final Logger logger = LogManager.getLogger(LoginFilter.class);
	
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI: "+requestSpec.getBaseUri());
		logger.info("Request Header: "+requestSpec.getHeaders());
		logger.info("Request Payload: "+requestSpec.getBody());
	}
	
	public void logResponse(Response response) {
		logger.info("BASE URI: "+response.getStatusCode());
		logger.info("Request Header: "+response.getHeaders());
		logger.info("Request Payload: "+response.getBody().prettyPrint());
	}

}
