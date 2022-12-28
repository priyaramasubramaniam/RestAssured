/******************************************************
Test Name:Get a single employee data
URI: http://dummy.restapiexample.com/api/v1/employee/{id}
Request Type: GET
Request Payload(Body): NA
********* Validations **********
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : text/html; charset=UTF-8
Server Type :  nginx/1.14.1
Content Encoding : gzip
Content Length <800
 *********************************************************/

package com.RestAssured.TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured.TestBase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;

public class TC002_GET_SingleEmployeeRecord extends TestBase{
	
	@BeforeClass
	void getSingleEmployee()
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, TestBase.employeeId);
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
		logger.info("************Status Line is HTTP/1.1 200 OK***************");
		String statusLine = response.getStatusLine();
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line is HTTP/1.1 200 OK");
	}
	
//	@Test
//	void checkContentType()
//	{
//		logger.info("************Content Type is application/json***************");
//		String contentType = response.getHeader("Content-Type");
//		AssertJUnit.assertEquals(contentType, "application/json");
//	}
//	
//	@Test
//	void checkServerType()
//	{
//		logger.info("************Server Type is nginx/1.21.6***************");
//		String serverType = response.getHeader("Server");
//		AssertJUnit.assertEquals(serverType, "nginx/1.21.6");
//	}
//	@Test
//	void checkContentLenght()
//	{
//		String contentLength = response.header("Content-Length");
//		AssertJUnit.assertTrue(Integer.parseInt(contentLength)<1500);
//	}
//	
	
}
