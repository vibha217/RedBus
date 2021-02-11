package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.Driver;
import com.Base.RequiredExecution;
import com.Pages.BusHireOperator_Page;
import com.Pages.TermsAndCondition;
import com.Utils.ExcelReader;


public class TermsAndCondition_Test extends Driver{
	private static String sheetName = prop.getProperty("SheetName8");
	static ExcelReader reader=new ExcelReader("./Resources/TestData/TestDataForBus.xlsx");   

	
	@Test
	public static void TAndC() throws Throwable{
		String TestCaseName="TermsCondition";
		extentTest = extent.startTest("TAndC");
		HashMap<String,String>testData = new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,TestCaseName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"), TestCaseName);

		driverInitialize(prop.getProperty("browserName"),prop.getProperty("mode"));

		

			TermsAndCondition terms = new TermsAndCondition(driver);
			//terms.TermsAndCondition();
			//terms.GuideLine();
			
			terms.SwitchWindow();
			System.out.println(driver.getTitle());
			//Assert.assertTrue(driver.getTitle().contains(s));
			

}
}
