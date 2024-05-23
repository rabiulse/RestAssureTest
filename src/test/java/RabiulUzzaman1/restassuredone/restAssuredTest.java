package RabiulUzzaman1.restassuredone;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class restAssuredTest {

	@Test
	public void getUser()

	{

		given()

				.when().get("https://reqres.in/api/users/2")

				.then().statusCode(200);

	}

	@Test
	public void listUsers() {
		given()// precondition for content type, body

				.when().get("https://reqres.in/api/users?page=2")// Actual http
																	// call

				.then().statusCode(200);// validation

	}

	@Test
	public void createUser() {
		HashMap<String, String> testdata = new HashMap<String, String>();
		testdata.put("name", "rabiul1");
		testdata.put("job", "IT");

		given().contentType("application/json").body(testdata)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201);

	}
	@Test
	public void WeatherMessageBody() {
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();

		// convert the body into lower case and then do a comparison to ignore
		// casing.
		Assert.assertEquals(
				bodyAsString.toLowerCase()
						.contains("hyderabad") /* Expected value */,
				true /* Actual Value */, "Response body contains Hyderabad");
	}

}