package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.Utils.ScreenShot;
/*--------------------------------------------BaseTest-------------------------------*/
public class Driver
{
	//Initialize the driver as public and static
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	//Create a file and give the path of properties file
	public static File file = new File(
			"./Resources/properties/Configuration.properties");
	static FileInputStream fis = null;
	//Create a static object
  public static Properties prop = new Properties();
	static
	{
		//Using the try and catch block
		try
		{
			fis = new FileInputStream(file);

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			prop.load(fis);

		}
		catch (IOException el)
		{
			el.printStackTrace();
		}
	}
	// Driver Initilization--------------------------------------

	public static void driverInitialize(String browser, String browserType) throws Throwable

	{

		//CHROME BROWSER------------------------------
         browser = prop.getProperty("browserName");
		if (browser.toLowerCase().equals("chrome"))
		{

			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
          browserType = prop.getProperty("mode");
			if (browserType.toLowerCase().equals("headless"))
			{

				// DesiredCapabilities dc = DesiredCapabilities.chrome();
				// URL url = new URL("http://localhost:4444/wd/hub");
				// RemoteWebDriver driver = new RemoteWebDriver(url,dc);
				// driver.manage().window().maximize();
				// driver.get("https://www.redbus.in/");

				//------------------------------------------------------------

				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size=1920,1080");
				options.addArguments("headless");
				options.addArguments("user-agent=Chrome/88.0.4324.150");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url"));
			}
			else
			{
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url"));
			}
		}
		//INTERNET EXPLORER BROWSER-----------------------------------------------

		// else if (browser.toLowerCase() == "ie")
		// {
		// System.setProperty("webdriver.gecko.driver", "./Resources/drivers/geckodriver.exe");
		// driver = new InternetExplorerDriver();
		// driver.manage().window().maximize();
		// driver.get(prop.getProperty("url"));
		// }
		// else if (browser.toLowerCase() == "firefox")
		// {
		// System.setProperty("webdriver.gecko.driver", "./Resources/drivers/geckodriver.exe");
		// if (browserType.toLowerCase() == "headless")
		// {
		// DesiredCapabilities dc = DesiredCapabilities.firefox();
		// URL url = new URL("http://localhost:4444/wd/hub");
		// RemoteWebDriver driver = new RemoteWebDriver(url,dc);
		// driver.manage().window().maximize();
		// driver.get("https://www.redbus.in/");
		//--------------------------------------------------------
		// FirefoxOptions options = new FirefoxOptions();
		// options.setHeadless(true);
		// driver = new FirefoxDriver(options);
		// driver.manage().window().maximize();
		// driver.get(prop.getProperty("url"));
		//}
		// else
		// {
		//
		// driver = new FirefoxDriver();
		// driver.manage().window().maximize();
		// driver.get(prop.getProperty("url"));
		// }
		//}
		else
		{
			System.out.println("Incompatible Browser Selection");
		}
		
	   // int wait = Integer.parseInt(prop.getProperty("ImplicitWait"));
	      //  Log4jDemo.logge("Give the value of wait from the properties file");
	        /*****************Call this method to manage the driver *****************/
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//driver.manage().timeouts().implicitlyWait(prop.getProperty("wait"), TimeUnit.SECONDS);
	}
	// this line of Code is For Extent Reporting ----------------------
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "vibha kumari");
		extent.addSystemInfo("User Name", "vibha kumari");
		extent.addSystemInfo("Environment", "Automation Testing");
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
	@AfterMethod
	public static void closeBrowser(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			// to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
			// to add error/exception in
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			// extent report
		String screenshotPath = ScreenShot.getScreenshot(driver, result.getName());
			//String screenshotPath = ScreenShot.
		//	extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			// to add screenshot in extent // report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent report
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		// ending test and ends the current test and prepare to create html report
	
		extent.endTest(extentTest);
		//driver.quit();
	}
	
	@AfterClass
public void QuitDriver() {
driver.close();
	
	}	
		
	}
