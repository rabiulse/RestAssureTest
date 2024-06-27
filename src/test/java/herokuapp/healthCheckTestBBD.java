package herokuapp;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;
import org.testng.annotations.Test;

import rabiul.test.resassure.baseTest;

public class healthCheckTestBBD extends baseTest {
	@Test
	public void HealthCheckTestBBD() {

		// RequestSpecification spec = new RequestSpecBuilder()
		// .setBaseUri("https://restful-booker.herokuapp.com").build();

		given().when().spec(spec).get("/ping").then().assertThat()
				.statusCode(201);

		Reporter.log(" Health check Status  validation succssfull");

	}

}
