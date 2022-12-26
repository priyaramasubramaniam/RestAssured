/******************************************************
Test Name:Create new record in database 
URI: http://dummy.restapiexample.com/api/v1/create
Request Type: POST
Request Payload(Body): {"name":"XXXXX","salary":"XXXX","age":"XX"}
********* Validations **********
Response Payload(Body) : {"name":"XXXXX","salary":"XXXX","age":"XX"}
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : text/html; charset=UTF-8
Server Type :  nginx/1.14.1
Content Encoding : gzip
**********************************************************/

package com.RestAssured.TestCases;

import java.net.http.HttpRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured.TestBase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;


public class TC003_Post_Employee_Record extends TestBase{
	
	@BeforeClass
	public void createEmployee() throws InterruptedException
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Priya");
		requestParams.put("salary", 1000);
		requestParams.put("age", 25);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.POST, "/create");
			
		Thread.sleep(5000);
	}
	
	@Test
	void checkResponsePayload()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("Priya"), true);
		Assert.assertEquals(responseBody.contains("salary"), "1000");
		Assert.assertEquals(responseBody.contains("age"), "25");
	}
	
	@Test
	void checkStausCode()
	{
		logger.info("************Status code is 200***************");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	void checkStatusLine()
	{
		logger.info("************Status Line is HTTP/1.1 201 OK***************");
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line is HTTP/1.1 200 OK");
	}
	
}
