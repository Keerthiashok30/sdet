package com.rmg.projecttest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PathParameters
{
	//@Test
	public void pathParamGet()
	{
		/**
		 * using pathparam we are using project ID to display That project
		 */
		given()
		.contentType(ContentType.JSON)
		.pathParam("projectId", "TY_PROJ_808")
		.baseUri("http://localhost:8084/")
		
		.when()
		.get("projects/{projectId}")
		
		.then()
		.log().all()
		.assertThat().statusCode(200);
		
	}
	
	//@Test
	public void pathParamDelete()
	{
		/**
		 * using pathparam we are using project ID to delete That project
		 */
		given()
		.contentType(ContentType.JSON)
		.pathParam("projectId", "TY_PROJ_009")
		
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		
		.then()
		.log().all()
		.assertThat().statusCode(204);
		
	}
	
	@Test
	public void pathParamPost()
	{
		/**
		 * using pathparam we are using project ID to delete That project
		 */
		JSONObject json = new JSONObject();
		json.put("createdBy", "keerthi");
		json.put("projectId", "TY_PROJ_0430");
		json.put("projectName", "nkw");
		json.put("status", "completed");
		json.put("teamSize", 4);
		given()
		.contentType(ContentType.JSON)
		.body(json)
		//.pathParam("projectId", "TY_PROJ_0430")
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.log().all()
		.assertThat().statusCode(201);
		
	}
}
