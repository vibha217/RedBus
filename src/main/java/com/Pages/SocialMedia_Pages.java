package com.Pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Base.Base_Class;



public class SocialMedia_Pages extends Base_Class{

	public SocialMedia_Pages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		@FindBy(how = How.XPATH, using = "//span[@class='fbicon icon-Facebook']")
		public WebElement facebook;
		
		@FindBy(how = How.XPATH, using = "//span[@class='twittericon icon-Twitter']")
		public WebElement twitter;
		
		public void scrollPage() {
			scroll(facebook);
		}
		
		public void facebookClick() {
			facebook.click();
		}
		public void twitterClick() {
			twitter.click();
			
		}
		
		public void  switchFacebook() {
			String mainHandle = driver.getWindowHandle();
			facebookClick();
			Set<String> allHandles = driver.getWindowHandles();
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scroll(0,250)");
			//  Object windowHandle;
			for(String windowHandle : allHandles)
			if(!mainHandle.equals(windowHandle)) {
				  driver.switchTo().window(windowHandle);
				  driver.getTitle();
				  driver.close();
				  
			  }driver.switchTo().window(mainHandle);
			
			
			
		}
		

		public void  switchTwitter() {
			String mainHandle = driver.getWindowHandle();
			twitterClick();
			Set<String> allHandles = driver.getWindowHandles();
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scroll(0,250)");
			//  Object windowHandle;
			for(String windowHandle : allHandles)
			if(!mainHandle.equals(windowHandle)) {
				  driver.switchTo().window(windowHandle);
				  driver.getTitle();
				  driver.close();
				  
			  }driver.switchTo().window(mainHandle);
			
			
			
		}
		
		
		
	}