package herokuapp;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import rabiul.test.resassure.baseTest;

public class CreateBooking extends baseTest {

	@Test
	public void createbookingTest() {

		Response response = createBooking();

		// verification:

		int responsecode = response.statusCode();

		Reporter.log("Get resposne code:" + responsecode);

		Assert.assertEquals(responsecode, 200,
				"Status code should be 200 but it is not");

		// validate first name

		String firstname = response.jsonPath().get("booking.firstname")
				.toString();
		// validate last name
		String lastname = response.jsonPath().getString("booking.lastname");
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
