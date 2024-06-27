package herokuapp;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import rabiul.test.resassure.baseTest;

public class GetBookingIdsXMLTest extends baseTest {
	@Test
	public void getallbookingIdsXMLTEST() {
		Response responseCreate = createBooking();

		int responsecode = responseCreate.statusCode();

		Reporter.log("Get resposne code:" + responsecode);

		Assert.assertEquals(responsecode, 200,
				"Status code should be 200 but it is not");

		// int getbookingId = responseCreate.jsonPath().getInt("bookingid");

		spec.pathParam("bookingid",
				responseCreate.jsonPath().getString("bookingid"));

		Header xml = new Header("accept", "application/xml");
		spec.header(xml);

		Response response = RestAssured.given(spec).get("/booking/{bookingid}");
		response.print();

		// validate first name

		// String firstname = response.jsonPath().get("firstname").toString();

		String firstname = response.xmlPath().getString("booking.firstname");

		// validate last name
		// String lastname = response.jsonPath().getString("lastname");
		String lastname = response.xmlPath().getString("booking.lastname");

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
