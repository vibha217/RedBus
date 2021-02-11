package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
//import com.Pages.SocialMedia_Page;
import com.Pages.SocialMedia_Pages;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;


public class SocialMedia_Test extends Driver{
	public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);

	private static String sheetName = prop.getProperty("SheetName7");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   

		@Test
		public void SocialMedia() throws Throwable{
			logger.info("*************************Social Media Test****************************");
			extentTest = extent.startTest("SocialMedia");
			String TestCaseName="SocialMedia";
			HashMap<String,String>testData = new HashMap<String,String>();
			testData=reader.getRowTestData(sheetName,TestCaseName);
			RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

			driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

			
			
			SocialMedia_Pages media = new SocialMedia_Pages(driver);
			media.scrollPage();
			//media.facebookClick();
			//media.twitterClick();
			media.switchFacebook();
			media.switchTwitter();
			
		
		
		}
		
}
