package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.ManageBooking_Page;
import com.Pages.Search;
import com.Pages.SitesPages;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;



public class Sites_Test extends Driver{
	public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);

	private static String sheetName = prop.getProperty("SheetName6");
	 static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   

	@Test
	public void get_Title() throws Throwable{
		logger.info("****************Sites Test**************************");
		extentTest=extent.startTest("get_Title");
		String TestCaseName="GlobalSites";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		
		
		SitesPages sites = new SitesPages(driver);
		sites.HomePage();
		logger.info("home page will be opened");
		
		sites.SwitchWindowColombia();
		logger.info("window will changed");
		sites.SwitchWindowIndia();
		sites.SwitchWindowIndonesia();
		logger.info("*******************TEST Cases Passed************************");
		
		
		
		
}}

