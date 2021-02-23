package com.rmg.projecttest;

import java.io.File;

import org.codehaus.groovy.reflection.android.AndroidSupport;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectBDD 
{
	@Test
	public void createprojectbdd()
	{
		File file=new File("./Data.json");
		
		//precondition
		given()
		.contentType(ContentType.JSON)
		.body(file)
		
		//test
		.when()
		.post("http://localhost:8084/addProject")
		
		//postcondition
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON);
		
		
	}

}
