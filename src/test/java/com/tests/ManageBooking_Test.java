package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.ManageBooking_Page;
import com.Utils.ExcelReader;
import com.sun.istack.logging.Logger;

/*----------------------------------Manage booking test--------------------------*/
 class ManageBooking_Test  extends Driver {
	 public final static Logger logger = Logger.getLogger(BusHireOperator_Test.class);
    
	 //Worksheet name used by the test
	 private static String sheetName = prop.getProperty("SheetName1");
	 static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   


	@Test
	public static void Cancel() throws Throwable{
		logger.info("*************************Cancel Test*****************************");
		
		//extent report generator
		extentTest = extent.startTest("Cancel");
		
		//fetching the test data from excel sheet
		String TestCaseName="Cancel";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		
		//driver initialization
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		
		
		ManageBooking_Page manage = new ManageBooking_Page(driver);
        
		manage.ClickOnManageBooking();
		manage.CancelTicket(testData.get("TicketNo"),testData.get("EmailId"));
		
		Thread.sleep(2000);
		String title = driver.getTitle();
		//logger.info(title);
		Assert.assertEquals(title,"Cancel Tichgjket - redBus");
		
		logger.info("*******************Test Case Passed*******************");
		


	}
	@Test
	public void Reschedule() throws Throwable{
		logger.info("*********************Reschedule Test************************");
		
		//Extent Report generator
		extentTest = extent.startTest("Reschedule");
		
		//fetching test data from excel sheet
		String TestCaseName="Reschedule";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));
		
		

		
	    ManageBooking_Page manage = new ManageBooking_Page(driver);
		
		manage.ClickOnManageBooking();

		manage.RescheduleBooking(testData.get("TicketNo"),testData.get("EmailId"));
		logger.info("Enter the input for reschedule booking");
		Thread.sleep(1000);
		
		 Assert.assertTrue(driver.getTitle().contains("Bus Hire: Rent Volvo, AC buses, Mini Buses, Tempo Travellers & Innova Cars - Book Online"));
		logger.info("*******************Test Case Passed********************");
	}
	@Test
	public void Show_MyTicket() throws Throwable{
		logger.info("******************Show My Ticket***********************");
		
		//Extent Report generator
		extentTest = extent.startTest("Show_MyTicket");
			
		//fetching the test data from excel sheet
		String TestCaseName="ShowTicket";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));
		


        ManageBooking_Page manage = new ManageBooking_Page(driver);
		
        manage.ClickOnManageBooking();
        logger.info("click on manage booking");
        
		manage.MyTicket(testData.get("TicketNo"),testData.get("EmailId"));
	logger.info("user will enter the details to check the status of ticket");
		Thread.sleep(1000);
		
		Assert.assertEquals(true,false);
		
		logger.info("**************************Test Cases Passed*****************************");

	}
	@Test
	public void SmS() throws Throwable{
		logger.info("**************************Sms Test***************************");
		extentTest = extent.startTest("SmS");
		
		//fetching the test data from excel sheet
		String TestCaseName="Sms";
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);
		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		
		//driver initialisation
		

        ManageBooking_Page manage = new ManageBooking_Page(driver);
		manage.ClickOnManageBooking();
		logger.info("click on Manage booking");
		
		manage.Sms(testData.get("TicketNo"),testData.get("EmailId"));
		Thread.sleep(1000);
		
		Assert.assertEquals(true,false);
		logger.info("******************Test Case Passed********************");


	}
}

