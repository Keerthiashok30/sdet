package com.rmg.projecttest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetDeleteProject 
{
	@Test
	public void getAllPrjectTest()
	{
		/*Response respo = RestAssured.get("http://localhost:8084/projects");
		//to print the content
		System.out.println(respo.asString());
		
		//to get response in organized manner
		respo.prettyPrint();
		
		//to print the status code
		respo.then().log().all();*/
		
		//projectId": "TY_PROJ_001",
		
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//to print he response
		resp.prettyPrint();
		
		//to get status code
		int code = resp.statusCode();
		System.out.println(code);
		
		//validating the status code
		Assert.assertEquals(code, 200);
		
		//to get content type
		String ctype = resp.contentType();
		System.out.println(ctype);
		
		//capture the 1st project ID;
		String proj = resp.jsonPath().get("[0].projectId");
		System.out.println(proj);
		
		Assert.assertEquals(proj, "TY_PROJ_001");
	}

	
	@Test
	public void deleteProject()
	{
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_606");
		int code = resp.statusCode();
		System.out.println(code);
	}
}
