package com.rmg.projecttest;

import org.testng.annotations.Test;

import com.rmg.genericutility.DataBaseUtilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingBDD 
{
	@Test
	public void getAndDeleteFirstProject() throws Throwable
	{
		DataBaseUtilities data=new DataBaseUtilities();
		data.connectToDB();
		Response resp = when()
		.get("http://localhost:8084/projects");
		
		String projectid=resp.jsonPath().get("[0].projectId");
		
		when()
		.delete("http://localhost:8084/projects/"+projectid)
		
		.then()
		.log().all()
		.assertThat().statusCode(204)
		.and()
		.assertThat().contentType(ContentType.JSON);
		
		
		
		data.executeQueryAndGetData("select * from project", 1, projectid);
		data.closeDb();
		
		
	}

}
