
/******************************************************
Test Name:Get all employees data
URI: http://dummy.restapiexample.com/api/v1/employees
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
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.*;


import com.RestAssured.TestBase.*;


public class TC001_GET_AllEmployees extends TestBase{
		
	@BeforeClass
	void getEmployees()
	{
		logger.info("******************* Started TC001_GET_AllEmployees**********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		httpRequest = RestAssured.given(); 
		response = httpRequest.request(Method.GET, "employees");
	}
	
	@Test
	void checkResponse()
	{
		logger.info("************** Checking Status Code of the Response************");
		String responseBody = response.getBody().asString();
		logger.info("Response body " + responseBody);
		AssertJUnit.assertEquals(responseBody!=null, true);
		System.out.println(responseBody);
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("************** Checking Status Code of the Response************");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		logger.info("***************Staus code is 200*************");
		AssertJUnit.assertEquals(statusCode, 200);
		
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("************** Checking Status Line of the Response************");
		String statusLine = response.getStatusLine().toString();
		System.out.println(statusLine);
		logger.info("***************Staus line is HTTP/1.1 200 OK*************");
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
//	@Test
//	void checkContentType()
//	{
//		logger.info("************** Checking Content Type of the Response header************");
//		String contentType = response.getHeader("Content-Type");
//		System.out.println(contentType);
//		logger.info("***************Content Type is application/json*************");
//		AssertJUnit.assertEquals(contentType, "application/json");
//				
//	}
//	
//	@Test
//	void checkServerType()
//	{
//		logger.info("************** Checking Server Type of the Response header************");
//		String serverType = response.getHeader("Server-Type");
//		logger.info("***************serverType is nginx/1.14.1*************");
//		AssertJUnit.assertEquals(serverType, "nginx/1.14.1");
//				
//	}
	
//	@Test
//	void checkContentEncoding()
//	{
//		logger.info("************** Checking Content Encoding of the Response header************");
//		String contentEncoding = response.getHeader("Content-Encoding");
//		logger.info("***************contentEncoding is gzip*************");
//		AssertJUnit.assertEquals(contentEncoding, "gzip");
//		
//	}
//	
//	@Test
//	void checkContentLength()
//	{
//		logger.info("************** Checking Content Length of the Response header************");
//		String contentLength = response.getHeader("Content-Length");
//		System.out.println(contentLength);
//		
//		
//		if(Integer.parseInt(contentLength)<800)
//			logger.warn("Content Length is less than 100");
//		
//		AssertJUnit.assertTrue(Integer.parseInt(contentLength)>800);
//		logger.info("***************Content length is greater than 800*************");		
//	}
//	
//	@Test
//	void checkCookies()
//	{
//		logger.info("***********  Checking Cookies **********");
//
//		String cookie = response.getCookie("PHPSESSID");
//		//Assert.assertEquals(cookie,"1esuvsfslcmiee2bfrsgnijtg0");
//		
//	}
//	
//	
	
	
		
}
