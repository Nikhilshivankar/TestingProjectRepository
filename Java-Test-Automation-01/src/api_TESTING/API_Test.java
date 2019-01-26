package api_TESTING;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class API_Test {

	//@Test
	public void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://services.groupkt.com/country/get";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request().get("/all");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
 
	}

	//@Test
	public void get_ISO_code() {

		RestAssured.baseURI = "http://services.groupkt.com/country/get/iso2code";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request().get("/IN");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
	}
	
	@Test(enabled =false)
	public void test000() {
		
		RestAssured.baseURI = "http://services.groupkt.com/country/get/iso3code";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request().get("/IND");
		
		int statusCode = response.getStatusCode();//getStatusLine();
		System.out.println("StatusCode is :" + statusCode);
		
		String str_header = response.getContentType();
		System.out.println("Content type is :" + response.getContentType());
		
		String responseJson = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseJson);
		
		JsonPath resJson = response.getBody().jsonPath();
		System.out.println("******************************************************************");
		System.out.println("messages = " + resJson.getJsonObject("RestResponse.messages[0]"));
		System.out.println("name = " + resJson.getJsonObject("RestResponse.result.name"));
		
	}

	@Test(enabled = true) 
    public void test_001() {
		
		String strTestName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		RestAssured.baseURI = "http://services.groupkt.com/country";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request().get("/get/all");
	
		System.out.println(strTestName + " : StatusCode is :" + response.getStatusCode());
		
		System.out.println(strTestName + " : Content type is :" + response.getContentType());
		
		String responseJson = response.getBody().asString();
		// System.out.println("Response Body is =>  " + responseJson);
		
		JsonPath resJson = response.getBody().jsonPath();
		System.out.println("******************************************************************");
//		System.out.println("messages = " + resJson.getJsonObject("RestResponse.messages[0]"));
//		System.out.println("name = " + resJson.getJsonObject("RestResponse.result.name"));
		
		System.out.println("name = " + resJson.getList("RestResponse.result").size());
		
		System.out.println("specific = " + resJson.getJsonObject("RestResponse.result[?(@.alpha3_code = 'AFG')]"));
	
	}

	//@Test(enabled=true) 
    public void test_002() {
		
		// Query parameterization WEBSERVICE **************************
		
		RestAssured.baseURI = "http://services.groupkt.com/country";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request().get("/search?text=ind");
		
		String str_response = response.getBody().asString();
		
		JsonPath resJson = response.getBody().jsonPath();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		System.out.println("Response code : " + response.getStatusCode() + "\n");
		
		System.out.println("Result : " + str_response);
		
		String strResult = resJson.getJsonObject("RestResponse.result[?(@.name ='India')]");//[?(@.name ='Isdfg')]
		
		System.out.println("specific = " + strResult  );//[?(@.name = 'India')]"));

		//  $.store.book[0].title
	}

    @Test
    public void test_003() {
		
		// matrix parameterization to WEBSERVICE
		
		RestAssured.baseURI = "http://services.groupkt.com/state";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request().get("/get/IND/all");
		
		JsonPath resJson = response.getBody().jsonPath();
		System.out.println(resJson.prettify());
		System.out.println(response.getBody().asString());
		
		}
}
