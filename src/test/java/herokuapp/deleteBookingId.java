package herokuapp;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import rabiul.test.resassure.baseTest;

public class deleteBookingId extends baseTest {

	@Test
	public void deleteBookingIdTest() {

		// Create Booking:

		Response responseCreate = createBooking();

		int responsecode = responseCreate.statusCode();

		Reporter.log("Get resposne code:" + responsecode);

		Assert.assertEquals(responsecode, 200,
				"Status code should be 200 but it is not");

		int getbookingId = responseCreate.jsonPath().getInt("bookingid");

		Response responsedelete = RestAssured.given().auth().preemptive()
				.basic("admin", "password123")
				.delete("https://restful-booker.herokuapp.com/booking/"
						+ getbookingId);
		responsedelete.print();

		int responsecodedelete = responsedelete.statusCode();
		System.out.println("Delete  resposne code:" + responsecodedelete);
		String statusline = responsedelete.statusLine();

		System.out.println("status line :" + statusline);

		Reporter.log("Delete  resposne code:" + responsedelete);

		Reporter.log("statusline:" + statusline);

	}

}
