package com.RestAssured.TestBase;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	//Request Object
	public static RequestSpecification httpRequest;
	
	//Response Object
	public static Response response;
	
	//Static Employee id
	public static String employeeId = "58512";
	
	//Logger Object 
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger = Logger.getLogger("Rest Assured");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC002_Get_Single_Employee_Record **********");
	}

}
