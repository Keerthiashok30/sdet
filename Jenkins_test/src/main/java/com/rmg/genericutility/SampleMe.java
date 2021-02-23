package com.rmg.genericutility;


import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SampleMe 
{
	public static void main(String[] args) throws Throwable, JsonMappingException, IOException
	{
		/*ProjectPojo pojo = new ProjectPojo("keerthi","lahjdg","sdfhlavi","ksdkjf","sdkosdfk",9);
		ObjectMapper obj=new ObjectMapper(); 
		obj.writeValue(new File("./project.json"), pojo);
		System.out.println("success");
			*/
			
		//deserilization
		ObjectMapper obj=new ObjectMapper(); 
		ProjectPojoMe pojo=obj.readValue(new File("./project.json"), ProjectPojoMe.class);
		System.out.println(pojo.createdby);
	}

}
