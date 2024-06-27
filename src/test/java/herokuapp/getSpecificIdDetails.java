package herokuapp;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getSpecificIdDetails {

	@Test
	public void getspecificIddetails() {
		Response response = RestAssured
				.get("https://restful-booker.herokuapp.com/booking/220");
		Reporter.log("Get resposne suucessfully:");
		response.print();

		// validate response code

		int responsecode = response.statusCode();

		Reporter.log("Get resposne code:" + responsecode);

		Assert.assertEquals(responsecode, 200,
				"Status code should be 200 but it is not");

		// validate first name

		String firstname = response.jsonPath().get("firstname").toString();

		// validate last name
		String lastname = response.jsonPath().getString("lastname");

		Reporter.log("firstname:" + firstname);
		Reporter.log("firstname:" + lastname);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(firstname, "rabiul",
				"firstname should be  Josh  but it is not");

		softassert.assertEquals(lastname, "uzzaman",
				"last name  should be Allen but it is not");
		softassert.assertAll();

	}

}
