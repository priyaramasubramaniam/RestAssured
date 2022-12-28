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

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
		logger.info("*********Started TC004_Put_Employee_Record **********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		// JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
		//{"name":"John123X","salary":"123","age":"23"}
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName); // Cast
		requestParams.put("salary", empSalary);
		requestParams.put("age", empAge);
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		response = httpRequest.request(Method.POST, "/create");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		System.out.println(response.getBody().jsonPath().get("id"));
		
		Thread.sleep(5000);

	}
	
	@Test
	void checkResponsePayload()
	{
		logger.info("**************Response Payload*************");
		String responseBody = response.getBody().asString();
		AssertJUnit.assertEquals(responseBody.contains(empName), true);
		System.out.println(empName);
		AssertJUnit.assertEquals(responseBody.contains(empSalary), true);
		System.out.println(empSalary);
		AssertJUnit.assertEquals(responseBody.contains(empAge), true);
		System.out.println(empAge);
	}
	
	@Test
	void checkStausCode()
	{
		logger.info("************Status code is 200***************");
		int statusCode = response.getStatusCode();
		AssertJUnit.assertEquals(statusCode, 200);
	}

	@Test
	void checkStatusLine()
	{
		logger.info("************Status Line is HTTP/1.1 201 OK***************");
		String statusLine = response.getStatusLine();
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line is HTTP/1.1 200 OK");
	}
	
}
