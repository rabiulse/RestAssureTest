package RabiulUzzaman1.restassuredone;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

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

				.when().get("https://reqres.in/api/users?page=2")// Actual http call

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

}