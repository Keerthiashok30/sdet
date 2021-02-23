package Assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rmg.genericutility.BaseClass;
import com.rmg.genericutility.IEndPoints;
import com.rmg.genericutility.ProjectPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectRestAssured extends BaseClass
{
	@Test
	public void createProj()
	{
		ProjectPojo proj = new ProjectPojo("Nithesh", "18/02/2021", "TY_03", "AWS", "ongoing", 2);
		
		given()
		.contentType(ContentType.JSON)
		.body(proj)
		.when()
		.post(IEndPoints.addProject)
		
		.then()
		.log().all()
		.and()
		.body("AWS", Matchers.equalToIgnoringCase("projectName"));
		
	}

}
