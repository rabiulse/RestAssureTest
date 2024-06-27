package herokuapp;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import rabiul.test.resassure.baseTest;

public class headerAndCookiesTest extends baseTest {
	@Test
	public void headerAndCookies() {

		Header someheader = new Header("some header", "someheaderrvalue");

		spec.header(someheader);

		Cookie somecookies = new Cookie.Builder("vv", "vv").build();
		spec.cookie(somecookies);

		Response response = given(spec).header("headernewname", "headervalue")
				.cookies("coockesname", "coockesvalue").log().all()
				.get("/ping");
		response.prettyPrint();
		response.getStatusLine();
		Reporter.log("Response: " + response.prettyPrint());
		Reporter.log("Response: " + response.getStatusLine());

		// Header
		Headers headers = response.getHeaders();

		System.out.println(headers);

		Reporter.log("Headers: " + headers);

		String header = response.getHeader("Server");
		Header header2 = headers.get("Server");

		Reporter.log(header2.getName() + ":" + header2.getValue());

		Reporter.log("Server header2: " + header2);

		Reporter.log("Server Headers: " + header);

		// Cookies

		Cookies cookies = response.getDetailedCookies();
		System.out.println(cookies);

		Reporter.log("Cookies: " + cookies);

	}

}
