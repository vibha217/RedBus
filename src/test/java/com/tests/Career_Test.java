package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.Career_Page;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;

/*----------------------------------CareerTest----------------------------*/

public class Career_Test extends Driver {
	public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);

	//worksheet name used by all tests
	private static String sheetName = prop.getProperty("SheetName9");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   

    @Test(priority=1)
	public static void Career() throws Throwable{
		logger.info("**********************Carrer Test****************************");
		
		//extent Report generator
		extentTest=extent.startTest("Career");
		
		//fetching test data from excel sheet
		String TestCaseName="Career";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		
		//driver initialization
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		
		//creating object of the page class
		Career_Page career = new Career_Page(driver);
		
		career.carrersButton();
		logger.info("click on career button");
		
		career.switchCarrer();
		logger.info("window will switch");
	
		
	    Assert.assertTrue(driver.getTitle().contains("Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India"));
		
	    
		
		logger.info("------------------Test  Case Passed-------------------");

	}
}
