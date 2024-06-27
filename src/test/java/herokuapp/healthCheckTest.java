package herokuapp;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class healthCheckTest {
	@Test
	public void HealthCheckTest() {
		Response response = RestAssured
				.get("https://restful-booker.herokuapp.com/ping");
		Reporter.log("Ping Response sucessfully: "
				+ response.getStatusLine().toString());
		response.print();

		// verify the response code

		Assert.assertEquals(response.getStatusCode(), 201,
				"Status code should be 200 but it is not");
		Reporter.log(" Health check Status  validation succssfull");

	}

}
