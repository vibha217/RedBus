package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.SignIn_Page;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;

import org.testng.annotations.Test;

public class SignIn_Test extends Driver {
	public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);

	// wOrksheet Name and path of excel sheet
	private static String sheetName = prop.getProperty("SheetName2");
	static ExcelReader reader = new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");

	@Test
	public void Valid_SignIn() throws Throwable {
		// fetching test data from excel
		extentTest = extent.startTest("Valid_SignIn");
		String TestCaseName = "valid_signIn";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, TestCaseName);



			logger.info("*************************Valid SignIn*********************");

			// extent reporter generator
			
			RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);


			// driver initialisation
			driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

			

			SignIn_Page signIn = new SignIn_Page(driver);
			signIn.click_icon_profile1();
			logger.info("user will click on icon Profile");

			signIn.click_signIn();
			logger.info("user will click on sign in button");

			signIn.SwitchWindowFacebook(testData.get("email"), testData.get("Password"));
			logger.info("user will enter the details for sihn in");

			Thread.sleep(3000);
			signIn.click_close();
			logger.info("user will click on close button");
			System.out.println(driver.getTitle());
			
		     Assert.assertTrue(driver.getTitle().contains("Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India"));
			logger.info("*********************Test Case Passed*******************");

	
	}
}
