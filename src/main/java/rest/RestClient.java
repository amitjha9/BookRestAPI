package rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
	
	
	public static Response jsonClientGet(String url)
	{
		RequestSpecification httpRequest;
		Response response=null;
		try {
			RestAssured.baseURI=url;
			httpRequest = RestAssured.given();
			httpRequest.header("Content-Type", "application/json");
			response = httpRequest.request(Method.GET, url);

			if(response.getStatusCode()!=200 && response.getStatusCode()!=201)
			{
				System.out.println("Request Failed: ERROR CODE:" +response.getStatusCode());
				System.out.println("Request Failed: ERROR Message:" +response.asString());
			}
			else {
				System.out.println("API call is success");
			}
		} catch (Exception e) {
			throw new RuntimeException("Request Failed:" +response.getStatusCode());
		}
		return response;
	}

	//This is for Post call
	public static Response jsonClientPost(String url, String jsonPayload)
	{
		RequestSpecification httpRequest;
		Response response = null;
		try {
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(jsonPayload);

			response = httpRequest.request(Method.POST, url);
			if(response.getStatusCode()!=200 && response.getStatusCode()!=201)
			{
				System.out.println("Request Failed: ERROR CODE:" +response.getStatusCode());
				System.out.println("Request Failed: ERROR Message:" +response.asString());
			}
			else {
				System.out.println("API call is success");
			}
		} catch (Exception e) {
			throw new RuntimeException("Request Failed:" +response.getStatusCode());
		}

		return response;
	}

	//This is for put call
	public static Response jsonClientPut(String url, String jsonPayload)
	{
		RequestSpecification httpRequest;
		Response response=null;
		try {
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(jsonPayload);

			response = httpRequest.request(Method.PUT,url);
			if(response.getStatusCode()!=200 && response.getStatusCode()!=201)
			{
				System.out.println("Request Failed: ERROR CODE:" +response.getStatusCode());
				System.out.println("Request Failed: ERROR Message:" +response.asString());
			}
			else {
				System.out.println("API call is success");
			}
		} catch (Exception e) {
			throw new RuntimeException("Request Failed:" +response.getStatusCode());
		}

		return response;
	}

	//This is for Patch call
	public static Response jsonClientPatch(String url, String jsonPayload)
	{
		RequestSpecification httpRequest;
		Response response=null;
		try {
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(jsonPayload);

			response = httpRequest.request(Method.PATCH,url);
			if(response.getStatusCode()!=200 && response.getStatusCode()!=201)
			{
				System.out.println("Request Failed: ERROR CODE:" +response.getStatusCode());
				System.out.println("Request Failed: ERROR Message:" +response.asString());
			}
			else {
				System.out.println("API Call is success");
			}
		} catch (Exception e) {
			throw new RuntimeException("Request Failed:" +response.getStatusCode());
		}

		return response;
	}

	//This is for delete call
	public static Response jsonClientDelete(String url)
	{
		RequestSpecification httpRequest;
		Response response = null;
		try {
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();

			response = httpRequest.request(Method.DELETE, url);
			if(response.getStatusCode()!=204)
			{
				System.out.println("Request Failed: ERROR CODE:" +response.getStatusCode());
				System.out.println("Request Failed: ERROR CODE:" +response.asString());
			}
			else {
				System.out.println("API Call is success");
			}
		} catch (Exception e) {
			throw new RuntimeException("Request Failed:" +response.getStatusCode());
		}

		return response;
	}
}
