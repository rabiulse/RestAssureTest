package herokuapp;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import rabiul.test.resassure.baseTest;

public class exampleOfQueryParam extends baseTest {
	@Test
	public void exampleOfQueryParamTest() {

		spec.param("firstname", "Susan");
		spec.param("lastname", "Brown");

		Response response = RestAssured.given(spec).get("/booking");
		response.prettyPrint();

		// verify the response code

		Assert.assertEquals(response.getStatusCode(), 200,
				"Status code should be 200 but it is not");
		Reporter.log(" status code validation is  succssfull");

		// Verify if the list of response is empty or not

		List<Integer> bookingIds = response.jsonPath().get("bookingid");

		for (int booking : bookingIds) {
			Reporter.log(" booking id is :" + booking);
		}

		Assert.assertFalse(bookingIds.isEmpty(), "Booking is empty");
		Reporter.log(" empty lits checking succssfully  succssfull");

	}

}
