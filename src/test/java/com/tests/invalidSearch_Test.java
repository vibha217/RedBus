package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.Search;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;

public class invalidSearch_Test extends Driver {
	
public final static Logger logger = Logger.getLogger(SearchTest.class);
	
	//worksheet name is same for all test case
	private static String sheetName = prop.getProperty("SheetName14");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   

	@Test(priority=1)
	public void invalidSearch_Bus() throws Throwable{
		logger.info("*****************************Search Bus Test****************************");

		//extent reporter generator
		extentTest = extent.startTest("invalidSearch_Bus");

		//fetching the test data from excel sheet
		String TestCaseName="invalidSearchBus";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		

		//creating an object of page class
		Search search = new Search(driver);

		//Test
		search.enter_source(testData.get("Source"));
        search.enter_destination(testData.get("Destination"));
		Thread.sleep(1000);
        search.click_calendar();
		search.Select_date();
		search.click_searchButton();
		Assert.assertEquals(true,false);
		

		logger.info("-----------------------Test Cases passed----------------------------");

	}


}
