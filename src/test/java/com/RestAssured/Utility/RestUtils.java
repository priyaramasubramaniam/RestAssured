package com.RestAssured.Utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String empName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return "John" + generatedString;
	}
	
	public static String empSalary()
	{
		String generatedSalary = RandomStringUtils.randomNumeric(4);
		return generatedSalary;
	}
	
	public static String empAge()
	{
		String generatedAge = RandomStringUtils.randomNumeric(2);
		return generatedAge;
	}
	

}
