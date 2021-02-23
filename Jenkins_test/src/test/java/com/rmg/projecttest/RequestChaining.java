package com.rmg.projecttest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RequestChaining
{
	@Test
	public void requestChaining()
	{
		/**
		 * create project and update the project using project ID
		 */
		
		HashMap map=new HashMap();
		map.put("createdBy", "keerthi");
		map.put("projectName", "nkwkak");
		map.put("status", "completed");
		map.put("teamSize", 43);
		
		RequestSpecification restspec = RestAssured.given();
		restspec.contentType(ContentType.JSON);
		restspec.body(map);
		Response res = restspec.post("http://localhost:8084/addProject");
		String pro = res.jsonPath().get("projectId");
		res.prettyPrint();
		int code = res.statusCode();
		System.out.println(code);
		
		HashMap map1=new HashMap();
		map1.put("createdBy", "keerthi");
		map1.put("projectName", "nkwkak");
		map1.put("status", "created");
		map1.put("teamSize", 43);
		
		
		restspec.contentType(ContentType.JSON);
		restspec.body(map1);
		Response resp = restspec.put("http://localhost:8084/projects/"+pro);
		resp.prettyPrint();
		int code1 = res.statusCode();
		System.out.println(code1);
	}

}
