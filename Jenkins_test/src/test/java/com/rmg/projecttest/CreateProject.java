package com.rmg.projecttest;

import java.util.HashMap;
import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject 
{
	@Test
	public void projectCreationHashMap()
	{
		//hashmap providing the body using key and value
		//precondition content type and body
		HashMap map=new HashMap();
		map.put("createdBy", "keerthi");
		map.put("projectName", "nk");
		map.put("status", "completed");
		map.put("teamSize", 4);
		
		RequestSpecification restspec = RestAssured.given();
		
		//add the content type
		restspec.contentType(ContentType.JSON);
		restspec.body(map);
		
		Response res = restspec.post("http://localhost:8084/addProject");

		res.prettyPrint();
		
		int code = res.statusCode();
		System.out.println(code);
		
	}
		@Test
		public void projectCreationJsonObject()
		{
			/**
			 * creating project using json object
			 * 
			 */
			JSONObject json = new JSONObject();
			json.put("createdBy", "keerthi");
			json.put("projectName", "nkw");
			json.put("status", "completed");
			json.put("teamSize", 4);
			
			RequestSpecification restspec = RestAssured.given();
			
			restspec.contentType(ContentType.JSON);
			restspec.body(json);
			
			Response res = restspec.post("http://localhost:8084/addProject");
			res.prettyPrint();
			int code = res.statusCode();
			System.out.println(code);
		}
		
		
		@Test
		public void projectCreationFile()
		{
			/**
			 * creating project using file
			 */
			
			File file=new File("./Data.json");
			
			
			RequestSpecification restspec = RestAssured.given();
			restspec.contentType(ContentType.JSON);
			restspec.body(file);
			
			Response res = restspec.post("http://localhost:8084/addProject");
			res.prettyPrint();
			int code = res.statusCode();
			System.out.println(code);
		}
	
}
