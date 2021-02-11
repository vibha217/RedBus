package com.Pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.Base.Base_Class;

public class CallBack_Page extends Base_Class{

  public CallBack_Page(WebDriver driver) {
		super(driver);
	}
      
  //---------------------------locators-------------------------------------
      @FindBy(how = How.XPATH,using ="//a[contains(text(),'BUS HIRE')]")
	  public WebElement busHire;
		
      @FindBy(how = How.XPATH,using = "//div[contains(text(),'Verified Drivers and Vehicles')]")
	  public WebElement scrollCommute;
		
      @FindBy(how = How.CLASS_NAME, using ="_37v4jd2t38Bgz56yFS_OXA")
	  public WebElement rCommuteButton;
		
      @FindBy(how = How.XPATH, using = "//button[@id='rcommute_request_call_back']")
	  public WebElement callBackButton;
		
      @FindBy(how = How.XPATH, using = "//input[@placeholder='YOUR NAME']")
	  public WebElement yourName;
		
      @FindBy(how = How.XPATH, using = "//input[@placeholder='YOUR CONTACT NUMBER']")
	  public WebElement yourContact;
		
      @FindBy(how =How.XPATH, using = "//input[@placeholder='YOUR EMAIL ID']")
	  public WebElement yourEmail;
		
      @FindBy(how = How.XPATH,using = "//input[@placeholder='ORGANISATION NAME']")
	  public WebElement organisationName;
		
      @FindBy(how = How.XPATH, using = "//iframe[@role='presentation']")
	  public WebElement captchaFrame;
		
      @FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	  public WebElement captcha;
		
      @FindBy(xpath = "//button[@id='rcommute_form_submit']")
	  public WebElement submitButton;
		
    //  ---------------------------actions--------------------------------
      public void clickBusHire() {
		ExplicitWait(busHire);
    	  busHire.click();
		}
		
      public void ClickCommute() {
		scroll(scrollCommute);
		rCommuteButton.click();
	  }
		
      public void CallButtonClick() {
		callBackButton.click();
	  }
		
      public void enterName(String name) {
		yourName.sendKeys(name);
	  }
		
      public void enterContact(String contact) {
		yourContact.sendKeys(contact);
	  }
		
      public void enterEmail(String email) {
		yourEmail.sendKeys(email);
	  }
		
      public void enterOrgName(String orgname) {
    	ExplicitWait(organisationName);
		organisationName.sendKeys(orgname);
	  }
		
      public void captchClick() {
		driver.switchTo().frame(captchaFrame);
		captcha.click();
		driver.switchTo().defaultContent();
	  }
		
      public void clicksubmit() {
		ExplicitWait(submitButton);
    	submitButton.click();
	  }
		
      public void switchwindow(String name,String contact,String email,String orgname) {
		String mainHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		for (String windowHandle : allHandles) {
		if (!mainHandle.equals(windowHandle)) {
		driver.switchTo().window(windowHandle);
		CallButtonClick();
		enterName(name);
		enterContact(contact);
		enterEmail(email);
		enterOrgName(orgname);
		captchClick();
		clicksubmit();
		
		}
		 driver.switchTo().window(mainHandle);
		}
	}
}
