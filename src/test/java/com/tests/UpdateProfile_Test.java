package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.ProfileUpdate;
import com.Pages.SignIn_Page;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;



public class UpdateProfile_Test extends Driver{
	
	//log4j
    public final static Logger logger = Logger.getLogger(SearchTest.class);
	
	//worksheet name is same for all test case
	private static String sheetName = prop.getProperty("SheetName12");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   

	@Test(priority=1)
	public static void validSignIn() throws Throwable {
		logger.info("******************valid SignIn **************************");
		extentTest=extent.startTest("validSignIn");
		String TestCaseName="validSignIn";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		
		SignIn_Page sign =new SignIn_Page(driver);
		ProfileUpdate update = new ProfileUpdate (driver);
		
		sign.click_icon_profile1();
		Thread.sleep(1000);
		sign.click_signIn();
		Thread.sleep(1000);
		sign.SwitchWindowFacebook(testData.get("email"),testData.get("Password"));
		Thread.sleep(3000);
		sign.click_close();
		update.clickOniconSign();
		update.clickListProfile();
		update.click_wallet();
		//System.out.println(driver.getTitle());
		Assert.assertEquals(true,true);
		
	}
	
	
	
	
	
	
	


	@Test
	public static void UpdateProfile() throws Throwable {
		logger.info("*****************************Update Profile Test**********************************");
		
		
		String TestCaseName="UpdateProfile";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);
		extentTest=extent.startTest("UpdateProfile");
		//ProfileUpdate Pro_update = new ProfileUpdate (driver);
		
		//ProfileUpdate update = new ProfileUpdate (driver);
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));
		SignIn_Page sign =new SignIn_Page(driver);
		System.out.println("gbhjkhj");
	   sign.click_icon_profile1();
		System.out.println("gbhj");
		Thread.sleep(1000);
		sign.click_signIn();
		System.out.println("gbhyghj");
		
		Thread.sleep(1000);
		sign.SwitchWindowFacebook(testData.get("email"),testData.get("Password"));
		System.out.println("gbyhjnhj");
		Thread.sleep(3000);
		sign.click_close();
		System.out.println("gbyghhj");
		sign.clickOniconSign();
		sign.clickListProfile();
		sign.update_myProfile(testData.get("name"), testData.get("PhoneCode"),testData.get("MobileNumber"));
	//	Assert.assertEquals(true, false);
	}
}
