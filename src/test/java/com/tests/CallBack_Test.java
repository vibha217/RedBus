package com.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.CallBack_Page;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;

/*-----------------------------Call Back Test-------------------------------*/
public class CallBack_Test  extends Driver{

	public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);

	//worksheet name used by all tests
	private static String sheetName = prop.getProperty("SheetName4");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   


	@Test(priority=1)
	public static void CallBack() throws Throwable{
		logger.info("*******************Call Back Request Test***********************");

		//extent report generator
		extentTest=extent.startTest("CallBack");

		//fetching test data from excel sheet
		String TestCaseName="CallBackRequest";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		//driver initialization
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));


		//creating object of page class
		CallBack_Page call = new CallBack_Page(driver);

		call.clickBusHire();
		logger.info("click on bus hire button");
		
		
		call.ClickCommute();
		logger.info("click on commute");
		
		call.switchwindow(testData.get("Name"),testData.get("Contact"),testData.get("email"),testData.get("organisationName"));
         logger.info("enter the details to get call Back Request");
     
         
         Assert.assertEquals(true, false);
		
		logger.info("*****************Test cases Passed**************************");




	}




}
