package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.BusHireOperator_Page;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;

/*--------------------------------------BusHireOperator Test--------------------------*/

public class BusHireOperator_Test extends Driver {

	public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);

	//worksheet name used by all tests
	private static String sheetName = prop.getProperty("SheetName5");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx"); 

	@Test
	public static void BusHireOperator() throws Throwable{
		logger.info("*********************Bus hire operator test****************************");

		//extent report generator
		extentTest = extent.startTest("BusHireOperator");
		String TestCaseName="BusHireOperator";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);
		//driver initialization
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		//creating an object of page class
		BusHireOperator_Page hire = new BusHireOperator_Page(driver);

		//Test
		hire.BusHire();
		logger.info("click on Bus Hire button");
		
		hire.signUp_BusHireOperator(testData.get("Name"),testData.get("OperatorName"),testData.get("City"),testData.get("ContactNo"),testData.get("AlternateContactNo"),testData.get("email"),testData.get("AlternateEmail"),testData.get("Address"),testData.get("PanNo"),testData.get("GSTINno"));
	    logger.info("enter the details for login the bus");
	    
	   Assert.assertTrue(driver.getTitle().contains("Bus Hire: Rent Volvo, AC buses, Mini Buses, Tempo Travellers & Innova Cars - Book Online"));
	  //  System.out.println(driver.getTitle());
	    
	
	

		logger.info("------------------------------Test Cases Passed----------------------------");
	}
}

