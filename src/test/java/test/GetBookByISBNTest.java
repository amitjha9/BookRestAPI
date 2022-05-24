package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBookByISBNTest extends BaseTest{

	@Test
	public void getBookByIsbnTest()
	{
		String serviceUrl = prop.getProperty("host");
		String endUrl= prop.getProperty("EndPoint");
		String url = serviceUrl+endUrl;
		String endPoint = "Book";
		System.out.println(url);
		try {
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.queryParam("ISBN", "9781449325862").baseUri(serviceUrl).basePath(endUrl).when().get("/{endPoint}",endPoint);
			String responseBody = response.getBody().asString();
			
			System.out.println("Response:" +responseBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
