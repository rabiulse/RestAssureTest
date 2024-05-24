package herokuapp;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import rabiul.test.resassure.baseTest;

public class partialUpdateBooking extends baseTest {

	@Test
	public void updatebookingTest() {

		// Create Booking:

		Response responseCreate = createBooking();

		int responsecode = responseCreate.statusCode();

		Reporter.log("Get resposne code:" + responsecode);

		Assert.assertEquals(responsecode, 200,
				"Status code should be 200 but it is not");

		int getbookingId = responseCreate.jsonPath().getInt("bookingid");

		// Update Booking

		// Create Json body-

		JSONObject body = new JSONObject();
		body.put("firstname", "rabiul2");
		JSONObject bookingdates = new JSONObject();

		// bookingdates.put("checkin", "2024-06-05");
		// bookingdates.put("checkout", "2024-06-06");

		// body.put("bookingdates", bookingdates);

		body.put("additionalneeds", "Breakfast1");

		Response responseUpdate = RestAssured.given().auth().preemptive()
				.basic("admin", "password123").contentType(ContentType.JSON)
				.body(body.toString())
				.patch("https://restful-booker.herokuapp.com/booking/"
						+ getbookingId);
		responseUpdate.print();

		int updateresponsecode = responseCreate.statusCode();

		Reporter.log("Get resposne code:" + updateresponsecode);
		Assert.assertEquals(responsecode, 200,
				"Status code should be 200 but it is not");

		// validate first name

		String firstname = responseUpdate.jsonPath().get("firstname")
				.toString();
		// validate last name
		String lastname = responseUpdate.jsonPath().getString("lastname");
		Reporter.log("firstname:" + firstname);
		Reporter.log("firstname:" + lastname);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(firstname, "rabiul2",
				"firstname should be  Josh  but it is not");

		softassert.assertEquals(lastname, "uzzaman",
				"last name  should be Allen but it is not");
		softassert.assertAll();

	}

}
