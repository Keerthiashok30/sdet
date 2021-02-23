package com.rmg.projecttest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Oauth2 
{
	@Test
	public void oauth2prog()
	{
		
	 Response resp = given()	
				.formParam("client_id", "sdet")
				.formParam("client_secret", "66228b95f7c78bc53773f2e0677427f6")
				.formParam("grant_type", "client_credentials")
				.formParam("code", "authorization_code")
				
				.when()
				.post("http://coop.apps.symfonycasts.com/token");
				
				resp.then()
				.log().all();
				String token = resp.jsonPath().get("access_token");
				
				
				given()
				.contentType(ContentType.JSON)
				.baseUri("http://coop.apps.symfonycasts.com/")
				.pathParam("USER_ID", 1721)
				.auth().oauth2(token)
				
				.when()
				.post("/api/{USER_ID}/eggs-count")
				
				.then()
				.log().all();
	}

}
