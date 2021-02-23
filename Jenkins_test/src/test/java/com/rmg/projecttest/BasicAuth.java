package com.rmg.projecttest;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BasicAuth 
{
   @Test
   public void basicAuthGet()
   {
	   given()
	   .baseUri("https://api.github.com")
	   .pathParam("owner", "Keerthiashok30")
	   .pathParam("repo", "sdet")
	   .auth().basic("Keerthiashok30", "askk@9394")
	   
	   //actual test
	   .when()
	   .get("/repos/{owner}/{repo}")
	   
	   .then()
	   .log().all()
	    .statusCode(200)
	    .and()
	   .body("name",Matchers.equalToIgnoringCase("sdet"))
.and()
.time(Matchers.lessThan(3l), TimeUnit.SECONDS);
   }
}
