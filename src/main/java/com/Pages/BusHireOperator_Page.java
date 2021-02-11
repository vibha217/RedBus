package com.Pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.Base.Base_Class;

public class BusHireOperator_Page extends Base_Class{

	public BusHireOperator_Page(WebDriver driver) {
		super(driver);
    }

	
//-----------------------------locators------------------------------
	@FindBy(how = How.LINK_TEXT, using = "BUS HIRE")
	public WebElement Bushire;

	@FindBy(how = How.XPATH, using = "//div[@class='_3VcoR-iRCX0iy6hxaxf6ER']")
	public WebElement scrollElement;

	@FindBy(how = How.XPATH, using = "//div[@class='_254VH5WNgWgjclgRRPngBJ']")
	public WebElement BecomeAnOperator;

	@FindBy(how = How.ID, using = "Name")
	public WebElement CompanyName;

	@FindBy(how = How.ID, using = "OperatorName")
	public WebElement operatorName ;

	@FindBy(how = How.ID, using = "City")
	public WebElement City;

	@FindBy(how = How.ID, using = "PrimaryPhNumber")
	public WebElement MobileNumber;

	@FindBy(how = How.ID, using = "AlternatePhNumber")
	public WebElement Alternate_MobileNumber;

    @FindBy(how = How.ID, using = "EmailAddress")
	public WebElement emailid;

    @FindBy(how = How.ID, using = "AlternateEmailAddress")
	public WebElement Alternate_emailId;

    @FindBy(how = How.ID, using = "OperatorAddress")
	public WebElement  FullAddress;

    @FindBy(how = How.ID, using = "PAN")
	public WebElement PAN_Number;

    @FindBy(how = How.ID, using = "GSTIN")
	public WebElement GSTIN_Number;

	@FindBy(how = How.XPATH, using = "//div[@id='submitFormDetails']")
	public WebElement Submit_button;

	//actions
	public void BusHire() throws InterruptedException {
		Bushire.click();
		ExplicitWait(scrollElement);
		scroll(scrollElement);
	 }

	public void signUp_BusHireOperator(String name,String operatorname,String city,String no,String AlternateNo,String email,String alternate_id,String Address,String panNo,String GstinNo) throws InterruptedException{
		String mainWindow = driver.getWindowHandle();
		ExplicitWait(BecomeAnOperator);
		BecomeAnOperator.click();
		

		//action for change window
		Set<String> handles = driver.getWindowHandles();
        for(String childWindow : handles) {
        	if(!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				CompanyName.sendKeys(name);
				operatorName.sendKeys(name);
				City.sendKeys(city);
				MobileNumber.sendKeys(no);
				Alternate_MobileNumber.sendKeys(AlternateNo);
				emailid.sendKeys(email);
				Alternate_emailId.sendKeys(alternate_id);
				FullAddress.sendKeys(Address);
				PAN_Number.sendKeys(panNo);
				GSTIN_Number.sendKeys(GstinNo);
				Submit_button.click();
	      }
       }
		driver.switchTo().window(mainWindow);
    }


}





