package com.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.SortByPage;
import com.Utils.ExcelReader;
//import com.redbus.pages.SortByPage;
import com.relevantcodes.extentreports.LogStatus;

public class ModifySearchTest extends Driver{
	
	@Test
	public void Search_Modify() throws Throwable
	{
		String sheetName=prop.getProperty("SheetName11");
	    ExcelReader reader=new  ExcelReader(prop.getProperty("./Resources/TestData/TestDataForBus.xlsx"));
		String TestCaseName="Search_Modify";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		//String RequiredExecution = testData.get("ExecutionRequired")
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),TestCaseName);
		driverInitialize(prop.getProperty("browserType"), prop.getProperty("mode"));
		extentTest = extent.startTest("Search_Modify");
		//Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		SortByPage  SortBy = new SortByPage(driver);
		SortBy.Trip_Details(testData.get("Source"),testData.get("Destination"));
		//Log4jFile1.logger.info("Source point and destination point entered.");
		extentTest.log(LogStatus.INFO, "Source point and destination point entered.");
		SortBy.Date();
		//Log4jFile1.logger.info("clicked on date.");
		extentTest.log(LogStatus.INFO, "clicked on date.");
		SortBy.SelectDate(testData.get("MonthYear"), testData.get("Day"));
		//Log4jFile1.logger.info("month, year and date entered.");
		extentTest.log(LogStatus.INFO, "month, year and date entered.");
		SortBy.Search();
	//	Log4jFile1.logger.info("Clicked on search.");
		extentTest.log(LogStatus.INFO, "Clicked on search.");
		SortBy.Modify_Trip_Detail(testData.get("Source1"),testData.get("Destination1"));
	//	Log4jFile1.logger.info("New Source point and destination point entered.");
		extentTest.log(LogStatus.INFO, "New Source point and destination point entered.");
		SortBy.SearcH();
	//	Log4jFile1.logger.info("Clicked on search.");
		extentTest.log(LogStatus.INFO, "Clicked on search.");
		Thread.sleep(1000);
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle,testData.get("ExpectedResult"));
		//Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
	//	Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}
}
