package rabiul.test.resassure;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class baseTest {

	protected Response createBooking() {
		// Create Json body-

		JSONObject body = new JSONObject();
		body.put("firstname", "rabiul");
		body.put("lastname", "uzzaman");
		body.put("totalprice", 150);
		body.put("depositpaid", true);

		JSONObject bookingdates = new JSONObject();

		bookingdates.put("checkin", "2024-06-04");
		bookingdates.put("checkout", "2024-06-06");

		body.put("bookingdates", bookingdates);

		body.put("additionalneeds", "Breakfast");

		// Create Response

		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body(body.toString())
				.post("https://restful-booker.herokuapp.com/booking");
		response.print();
		return response;
	}

}
