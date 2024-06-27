package herokuapp;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import rabiul.test.resassure.Booking;
import rabiul.test.resassure.Bookingdates;
import rabiul.test.resassure.baseTest;

public class CreateBookingWithPogo extends baseTest {
	@Test
	public void createBookingWithPOJOTest() {

		Faker fakedata = new Faker();
		String firstname = fakedata.name().firstName();
		String lastname = fakedata.name().lastName();
		// Create body using POJOs
		Bookingdates bookingdates = new Bookingdates("2024-07-25",
				"2024-07-27");
		Booking booking = new Booking(firstname, lastname, 200, false,
				bookingdates, "Baby crib");

		// Get response
		Response response = RestAssured.given(spec)
				.contentType(ContentType.JSON).body(booking).post("/booking");
		response.print();
		// Verify All fields
		SoftAssert softAssert = new SoftAssert();
		String actualFirstName = response.jsonPath()
				.getString("booking.firstname");
		softAssert.assertEquals(actualFirstName, firstname,
				"firstname in response is not expected");

		String actualLastName = response.jsonPath()
				.getString("booking.lastname");
		softAssert.assertEquals(actualLastName, lastname,
				"lastname in response is not expected");

		int price = response.jsonPath().getInt("booking.totalprice");
		softAssert.assertEquals(price, 200,
				"totalprice in response is not expected");

		boolean depositpaid = response.jsonPath()
				.getBoolean("booking.depositpaid");
		softAssert.assertFalse(depositpaid,
				"depositpaid should be false, but it's not");

		String actualCheckin = response.jsonPath()
				.getString("booking.bookingdates.checkin");
		softAssert.assertEquals(actualCheckin, "2024-07-25",
				"checkin in response is not expected");

		String actualCheckout = response.jsonPath()
				.getString("booking.bookingdates.checkout");
		softAssert.assertEquals(actualCheckout, "2024-07-27",
				"checkout in response is not expected");

		String actualAdditionalneeds = response.jsonPath()
				.getString("booking.additionalneeds");
		softAssert.assertEquals(actualAdditionalneeds, "Baby crib",
				"additionalneeds in response is not expected");

		softAssert.assertAll();
	}

}
