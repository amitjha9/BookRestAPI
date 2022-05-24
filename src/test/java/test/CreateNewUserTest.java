package test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import entity.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNewUserTest extends BaseTest{
	
	
	@Test
	public void createUserTest()
	{
		String serviceUrl = prop.getProperty("host");
		String endUrl= prop.getProperty("EndPoint1");
		String url = serviceUrl+endUrl;
		String endPoint = "User";
		System.out.println(url);
		
		Map<String, String> payload = new HashMap<String, String>();
		
		User user = new User();
		user.setUsername("PostRequestUser123");
		user.setPassword("PostRequestUser@@123");
		
		payload.put("userName", user.getUsername());
		payload.put("password", user.getPassword());
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(payload);
		
		System.out.println(jsonObject);
		
		try {
			RequestSpecification httpRequest = RestAssured.given();
			 Response response=httpRequest.baseUri(serviceUrl).basePath(endUrl).contentType("application/json").accept("application/json").body(jsonObject).post("/{endPoint}",endPoint);
			 String responseBody = response.getBody().asString();
			 System.out.println(responseBody);
			 
			 int statusCode = response.getStatusCode();
			 System.out.println("Status Code:" +statusCode);
			 if(statusCode==201)
			 {
				 System.out.println("Test Passed");
			 }
			 
			 else {
				System.out.println("Test Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
