package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.SignIn_Page;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;

public class Invalid_SignIn extends Driver {
	public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);

	private static String sheetName = prop.getProperty("SheetName13");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   




	@Test
	public void invalid_SignIn() throws Throwable{
		
		logger.info("****************************invalid SignIn test********************");
		
		extentTest = extent.startTest("invalid_SignIn");
		String TestCaseName="invalidSignin";
		
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

      //extent reporter generator
      		

        SignIn_Page signIn = new SignIn_Page(driver);
        signIn.click_icon_profile1();
        logger.info("click on icon Profile");
        
		signIn.click_signIn();
		logger.info("click on signin button");
		
		signIn.SwitchWindowFacebook(testData.get("email"),testData.get("Password"));
		logger.info("enter the details for signin");
        Thread.sleep(3000);
		signIn.click_close();
		logger.info("click on close");
		Assert.assertEquals(true, false);
		logger.info("******************************Test Case Passed*****************************");
		

}
}
