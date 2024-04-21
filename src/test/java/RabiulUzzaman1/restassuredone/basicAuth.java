package RabiulUzzaman1.restassuredone;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class basicAuth {
	
	@Test
	public void authTest()

	{

		given().auth().basic("postman", "password")
		.contentType(ContentType.JSON)		
				.when()
				  	.get("http:postman-echo.com/basic-auth")
				.then().assertThat()
				 .statusCode(403).log().all();
		

	}
	
}
