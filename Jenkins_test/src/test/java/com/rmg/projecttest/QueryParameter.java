package com.rmg.projecttest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class QueryParameter 
{
	//@Test
	public void queryParamGet()
	{
		given()
		.contentType(ContentType.JSON)
		.queryParam("page","3")
		.baseUri("https://reqres.in/")
		
		.when()
		.get("api/users")
		
		.then()
		.log().all()
		.assertThat().statusCode(200);

	}
	
	

	@Test
	public void validateQueryParamGet()
	{
		Response res = given()
		.contentType(ContentType.JSON)
		.queryParam("page",2)
		.baseUri("https://reqres.in/")
		
		.when()
		.get("api/users");
		
		//int val=res.jsonPath().get("page");
		ArrayList<String> val=res.jsonPath().get("data.first_name");
		for(String str:val)
		{
		System.out.println(str);
		}

	}
}
