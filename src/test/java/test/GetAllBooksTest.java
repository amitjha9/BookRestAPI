package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class GetAllBooksTest extends BaseTest{


	@Test
	public void getAllBookTest()
	{
		String serviceUrl = prop.getProperty("host");
		String endUrl= prop.getProperty("EndPoint");
		String url = serviceUrl+endUrl;
		String endPoint = "Books";
		System.out.println(url);

		Response response = given()
				.baseUri(serviceUrl)
				.basePath(endUrl)
				.when()
				.get("/{endPoint}",endPoint);
		
		System.out.println(response.getBody().asString());
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
