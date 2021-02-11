package com.Base;

import org.testng.SkipException;
import com.relevantcodes.extentreports.LogStatus;

public class RequiredExecution extends Driver {
	public static void tocheckExecutionRequired(String executionRequired, String TestName) {
		if (executionRequired.toLowerCase().equals("no")) {
			extentTest = extent.startTest(TestName);
			extentTest.log(LogStatus.WARNING, "Execution required is " + executionRequired);
			throw new SkipException("Skipping this test ");
		}

	}

}
