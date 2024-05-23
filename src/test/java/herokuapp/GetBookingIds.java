package herokuapp;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIds {
	@Test
	public void getallbookingIds() {
		Response response = RestAssured
				.get("https://restful-booker.herokuapp.com/booking");
		Reporter.log("Get resposne suucessfully:");
		response.print();

		// verify the response code

		Assert.assertEquals(response.getStatusCode(), 200,
				"Status code should be 200 but it is not");
		Reporter.log(" Stactucvalidation succssfull");

		// Verify if the list of response is empty or not

		List<Integer> bookingIds = response.jsonPath().get("bookingid");
		Assert.assertFalse(bookingIds.isEmpty(), "Booking is empty");
		Reporter.log(" empty lits checking succssfully  succssfull");

	}

}
