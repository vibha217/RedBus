package com.Pages;

import static org.testng.Assert.assertEquals;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import com.Base.Base_Class;


public class SitesPages extends Base_Class {
	 
	   public SitesPages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//span[@class='flagicon icon-COL']")
	public WebElement Tab_Colombia;
	   
	@FindBy(how = How.XPATH, using = "//a[@class='redbus-logo home-redirect']")
	public WebElement redBus_logo;
	   
	@FindBy(how = How.XPATH, using ="//span[@class='flagicon icon-IND']")
	public WebElement Tab_India;
	   
	@FindBy(how = How.XPATH, using ="//span[@class='flagicon icon-IDN']")
	public WebElement Tab_Indonesia;
	   
	
	   public void HomePage() {
		   redBus_logo.click();
	   }
	   
	   public void SwitchWindowColombia() throws InterruptedException {
             
		   
		   String mainWindow = driver.getWindowHandle();
			ExplicitWait(Tab_Colombia);
		   Tab_Colombia.click();
		    Set<String> handles = driver.getWindowHandles();
		   
		    
		    for(String childWindow : handles) {
		    	
		    	
		    	if(!childWindow.equals(mainWindow)) {
		    		driver.switchTo().window(childWindow);
		    		
		    		String actualTitle = driver.getTitle();
		    		String expectedTitle = "Compra Pasajes de Bus Online - redBus Colombia";
		    		assertEquals(expectedTitle,actualTitle);
		    		
		    	driver.close();
		    	}
		    
		    	 driver.switchTo().window(mainWindow);
		    	
		     }
		    
		  }
	   
	   public void SwitchWindowIndia() {
	   String mainWindow = driver.getWindowHandle();
		ExplicitWait(Tab_India);
	   Tab_India.click();
	    Set<String> handles = driver.getWindowHandles();
	   
	    
	    for(String childWindow : handles) {
	    	
	    	
	    	if(!childWindow.equals(mainWindow)) {
	    		driver.switchTo().window(childWindow);
	    		
	    		String actualTitle = driver.getTitle();
	    		String expectedTitle = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";
	    		assertEquals(expectedTitle,actualTitle);
	    		
	    		driver.close();
	    	}
	    
	    	 driver.switchTo().window(mainWindow);
	    	
	     }
	   
	  }
	   
	   public void SwitchWindowIndonesia() {
		   String mainWindow = driver.getWindowHandle();
			ExplicitWait(Tab_Indonesia);
		   Tab_Indonesia.click();
		    Set<String> handles = driver.getWindowHandles();
		   
		    
		    for(String childWindow : handles) {
		    	
		    	
		    	if(!childWindow.equals(mainWindow)) {
		    		driver.switchTo().window(childWindow);
		    		
		    		String actualTitle = driver.getTitle();
		    		String expectedTitle = "Pesan Tiket Bus Online, AKAP, dan Shuttle - redBus.id";
		    		assertEquals(expectedTitle,actualTitle);
		    		
		    		driver.close();
		    	}
		    
		    
		    	
		     }
		    driver.switchTo().window(mainWindow);
	   }
	 
	  
}
