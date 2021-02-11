package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.Filter_Pages;
import com.Pages.Modify_Pages;
import com.Pages.Search;
import com.Pages.SortSelectLocators;

import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;


/*---------------------------------Search Test--------------------------*/
public class SearchTest extends Driver
{

	public final static Logger logger = Logger.getLogger(SearchTest.class);
	
	//worksheet name is same for all test case
	private static String sheetName = prop.getProperty("SheetName11");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   

	@Test(priority=1)
	public void Search_Bus() throws Throwable{
		logger.info("*****************************Search Bus Test****************************");

		//extent reporter generator
		extentTest = extent.startTest("Search_Bus");

		//fetching the test data from excel sheet
		String TestCaseName="SearchBus";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);
		
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));


		//creating an object of page class
		Search search = new Search(driver);

		//Test
		search.enter_source(testData.get("Source"));
		logger.info("user will enter the source");

		search.enter_destination(testData.get("Destination"));
		logger.info("user will enter the destination");
		Thread.sleep(1000);

		search.click_calendar();
		logger.info("user will click on calendar");

		search.Select_date();
		logger.info("select the date");

		search.click_searchButton();
		logger.info("search button");
		 logger.info(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India"));
		

	}

	@Test(priority=2)
	public void Modify_Search() throws Throwable{
		logger.info("*****************Modify search Test*******************");

		//extent report generator
		extentTest = extent.startTest("Modify_Search");

		//fetching the test data from excel sheet
		String TestCasesName="ModifyBus";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCasesName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCasesName);
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		Modify_Pages modify = new Modify_Pages(driver);

		Search search = new Search(driver);

		//Test
	
          //Thread.sleep(1000);
		modify.click_iconClose();
		logger.info("click on icon close button");
	

		modify.modify_dest(testData.get("Destination"));
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Delhi to Udaipur Bus Tickets Booking, Save upto 25% - redBus"));
		
	}

	@Test(priority=3)
	public void Filter() throws Throwable{
		logger.info("***************Filter Test******************");

		//extent report generator
		extentTest = extent.startTest("Filter");

		//fetching the test data from excel sheet
		String TestCasesName="Filter";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCasesName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCasesName);
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		Filter_Pages filter = new Filter_Pages(driver);
		filter.click_livetracking();
		logger.info("click on Live tracking button");

		filter.busSeating();

		filter.selectArrivalTime();
		logger.info("User will select the arrival time");

		
	}

	@Test(priority=4)
	public void SortSelect() throws Throwable {
		logger.info("***************sort select Test********************");
		extentTest = extent.startTest("SortSelect");
		String TestCasesName="SortSelect";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCasesName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCasesName);
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));


		//extent report generator
	//	extentTest = extent.startTest("SortSelect");

		SortSelectLocators sort = new SortSelectLocators(driver);
		
		sort.sortFare();
		sort.seatSelect();
		
		logger.info("---------------------------------------------------------------");
		
        Assert.assertEquals(true, false);
	}




}