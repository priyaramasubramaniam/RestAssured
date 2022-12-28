package com.RestAssured.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestAssured.TestBase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC004_UPDATE_Employee_Record extends TestBase{

	void updateEmployee()
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		
		httpRequest = RestAssured.given();
		
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName);
		requestParams.put("name", empSalary);
		requestParams.put("name", empAge);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.PUT, "update/"+employeeId);	
		
	}
//	@Test
//	void checkResponsePayload()
//	{
//		logger.info("**************Response Payload*************");
//		String responseBody = response.getBody().asString();
//		AssertJUnit.assertEquals(responseBody.contains(empName), true);
//		System.out.println(empName);
//		AssertJUnit.assertEquals(responseBody.contains(empSalary), true);
//		System.out.println(empSalary);
//		AssertJUnit.assertEquals(responseBody.contains(empAge), true);
//		System.out.println(empAge);
//	}
	
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
