package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base_Class;




public class TrackBus_Pages  extends Base_Class{
	 public TrackBus_Pages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 
	 @FindBy(how = How.XPATH, using = "//div[contains(text(),'Thermal Screening')]")
	 public WebElement ScrollElement;
	 
	   @FindBy(how = How.XPATH, using = "//a[@class='know_more']")
		public WebElement KnowMore_button;
	   
	    @FindBy(how = How.XPATH, using = "//input[@placeholder='Ticket No']")
	    public WebElement TicketNo;
	    
	  
	  
	   @FindBy(how = How.XPATH, using = "//div//input[@placeholder='Email Id']")
	   public WebElement Email;
	   @FindBy(how = How.XPATH, using = "//input[@class='search_btn']")
	   public WebElement Search_Button;
	   
	   
	    
	    
	    public void Know_More() throws InterruptedException {
	    	scroll(ScrollElement);
	    	Thread.sleep(2000);
	    	KnowMore_button.click();
	    }
	    
	    public void Details_TrackBus(String number ,String email) {
	    //	driver.switchTo().frame(Frame);
	    	TicketNo.sendKeys(number);
	    	Email.sendKeys(email);
	    	Search_Button.click();
	    }
	   

}
