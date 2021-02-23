package com.rmg.projecttest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmg.genericutility.DataBaseUtilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyDataInDataBaseGUI 
{
	@Test
	public void verifydatadb() throws Throwable
	{
		/**
		 * create a project
		 * connect to db
		 * verify the project
		 * disconnect db
		 */
		
		DataBaseUtilities data=new DataBaseUtilities();
		data.connectToDB();
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
		String pro = res.jsonPath().get("projectId");
		data.executeQueryAndGetData("select * from project", 1, pro);
		
		data.closeDb();
		
		
		//verify in gui
		//Assert.assertEquals(pro, );
	}
}
