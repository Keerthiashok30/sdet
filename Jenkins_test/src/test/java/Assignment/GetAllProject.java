package Assignment;

import org.testng.annotations.Test;

import com.rmg.genericutility.BaseClass;
import com.rmg.genericutility.IEndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class GetAllProject  extends BaseClass
{
	@Test
	public void getAllProject()
	{
		 given()
		.contentType(ContentType.JSON)
		
		
		.when()
		.get(IEndPoints.getAllProject)
		
		.then()
		.log().all();
	}

}
