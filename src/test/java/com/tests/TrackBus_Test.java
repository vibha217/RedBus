package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.TrackBus_Pages;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;



public class TrackBus_Test extends Driver{

	public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);
	private static String sheetName = prop.getProperty("SheetName3");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");
	
	@Test
	public static void TrackBus() throws Throwable {
		extentTest = extent.startTest("TrackBus");
		logger.info("***********************Track Bus Test*************************");
		String TestCaseName="TrackBus";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		
			//Driver.openBrowser();
			
			TrackBus_Pages track = new TrackBus_Pages(driver);
			track.Know_More();
			track.Details_TrackBus(testData.get("TicketNo"),testData.get("email"));
			System.out.println(driver.getTitle());
			
}
}

