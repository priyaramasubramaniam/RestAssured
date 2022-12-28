package com.RestAssured.TestBase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.RestAssured.Utility.RestUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	//Request Object
	public static RequestSpecification httpRequest;
	
	//Response Object
	public static Response response;
	
	//Static Employee id
	public static String employeeId = "9200";
	
	//Static Employee name
	public static String empName = RestUtils.empName();
	
	//Static Employee Salary
	public static String empSalary = RestUtils.empSalary();
	
	//Static Employee Age
	public static String empAge = RestUtils.empAge();
	
	//Logger Object 
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger = Logger.getLogger("Rest Assured");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	@AfterMethod
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC002_Get_Single_Employee_Record **********");
	}

}
