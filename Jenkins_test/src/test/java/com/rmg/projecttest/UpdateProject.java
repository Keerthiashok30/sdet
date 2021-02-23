package com.rmg.projecttest;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject
{

	
	//@Test
	public void updateProjectPut()
	{
		/**
		 * update project using put method
		 */
		
		HashMap map=new HashMap();
		map.put("createdBy", "keerthi");
		map.put("projectName", "nk");
		map.put("status", "Created");
		map.put("teamSize", 4);
		
		RequestSpecification restspec = RestAssured.given();
		
		//add the content type
		restspec.contentType(ContentType.JSON);
		restspec.body(map);
		
		Response res = restspec.put("http://localhost:8084/projects/TY_PROJ_607");

		res.prettyPrint();
		
		int code = res.statusCode();
		System.out.println(code);
	}
	
	
	@Test
	public void updateProjectPatch()
	{
		/**
		 * update project using patch method
		 */
		
		JSONObject json = new JSONObject();
		json.put("projectName", "nkwkak");
		
RequestSpecification restspec = RestAssured.given();
		
		//add the content type
		restspec.contentType(ContentType.JSON);
		restspec.body(json);
		
		Response res = restspec.patch("http://localhost:8084/projects/TY_PROJ_606");

		res.prettyPrint();
		
		int code = res.statusCode();
		System.out.println(code);
		
	}
}
