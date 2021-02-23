package com.rmg.projecttest;

import java.util.List;

import javax.swing.plaf.synth.SynthScrollPaneUI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifySpecificProject 
{
	@Test
	public void verifyPro()
	{
		/**
		 * to get a  specific record from n no.of records
		 */
		String expectedpro="nkwkak";
		Response res = RestAssured.get("http://localhost:8084/projects");
		res.prettyPrint();
		
		//jsonpath act like findelements
		List<String> pro = res.jsonPath().get("projectName");
		
		Boolean flag = false;
	for(String str:pro)
	{
		//System.out.println(str);
	if(expectedpro.equalsIgnoreCase(str))
	{
		flag=true;
		System.out.println(expectedpro+" is present");
	}
	}
	
	/*if(!flag)
	{
		System.out.println(expectedpro+" is not present");
	}*/
	
	}
}
