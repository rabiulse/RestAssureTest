package herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import rabiul.test.resassure.Booking;
import rabiul.test.resassure.Bookingdates;
import rabiul.test.resassure.baseTest;
import rabiul.test.resassure.bookingIds;

public class CreateBookingWithPogo2 extends baseTest {
	@Test
	public void createBookingWithPOJOTest2() {

		// Create body using POJOs
		Bookingdates bookingdates = new Bookingdates("2024-07-25",
				"2024-07-27");
		Booking booking = new Booking("Olga", "Shyshkin", 200, false,
				bookingdates, "Baby crib");

		// Get response
		Response response = RestAssured.given(spec)
				.contentType(ContentType.JSON).body(booking).post("/booking");
		response.print();
		bookingIds ids = response.as(bookingIds.class);
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200,
				"Status code should be 200, but it's not");

		System.out.println("Request booking : " + booking.toString());
		System.out.println("Response booking: " + ids.getBooking().toString());

		// Verify All fields
		Assert.assertEquals(ids.getBooking().toString(), booking.toString());

	}

}
