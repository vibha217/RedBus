package com.Pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Base.Base_Class;





public class TermsAndCondition extends Base_Class{
	
	   
	
		
		
		

		public TermsAndCondition(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		@FindBy(how = How.XPATH, using = "//a[contains(text(),'T & C')]")
		public static WebElement  TandC_buttons;
		
		@FindBy(how = How.XPATH, using ="//*[@id=\"mBWrapper\"]/p/a/b")
		public WebElement passengerGuideline;
		
		
		@FindBy(how = How.XPATH, using ="//p[contains(text(),'Assam')]")
		public WebElement Assam;
	
		 public static void TermsAndCondition() throws InterruptedException {
		scroll(TandC_buttons);
		Thread.sleep(1000);
		
		TandC_buttons.click();
		
		
	}
		public void GuideLine() {
		 passengerGuideline.click();
		}
		 public  void SwitchWindow() throws InterruptedException{
				
			  // driver.switchTo().frame(frame);
			   
//			   String mainWindow = driver.getWindowHandle();
			   TermsAndCondition();
//				
//			  
//			    Set<String> handles = driver.getWindowHandles();
//			   
//			    
//			    for(String childWindow : handles) {
//			    	
//			    	
//			    	if(!childWindow.equals(mainWindow)) 
//			    		driver.switchTo().window(childWindow);
			    Thread.sleep(1000);		
			    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		        driver.switchTo().window(tabs2.get(1));
			    
		        
			    GuideLine();
			   scroll(Assam);
			   Assam.click();
			    	}
			    
			    
			    	//Thread.sleep(1000);
			     }
			   // driver.switchTo().window(mainWindow);
			  

	

