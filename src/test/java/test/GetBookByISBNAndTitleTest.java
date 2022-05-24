package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBookByISBNAndTitleTest extends BaseTest{
	
	
	@Test
	public void getBookByIsbnAndTitleTest()
	{
		String serviceUrl = prop.getProperty("host");
		String endUrl= prop.getProperty("EndPoint");
		String url = serviceUrl+endUrl;
		String endPoint = "Book";
		System.out.println(url);
		try {
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.queryParam("ISBN", "9781449331818").queryParam("TITLE", "Learning JavaScript Design Patterns").baseUri(serviceUrl).basePath(endUrl).get("/{endPoint}",endPoint);
			String responseBody = response.getBody().asString();
			
			System.out.println("Response:" +responseBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
