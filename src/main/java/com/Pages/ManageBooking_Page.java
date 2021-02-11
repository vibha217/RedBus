package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base_Class;

public class ManageBooking_Page extends Base_Class  {
	
	public ManageBooking_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//div[@class='manageHeaderLbl']")
	public WebElement managebooking;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	public WebElement Cancel;

	@FindBy(how = How.NAME, using = "tin")
	public WebElement Ticketno_Element1;

	@FindBy(how = How.NAME, using = "email")
	public WebElement  email_Element1;

	@FindBy(how = How.XPATH, using = "//div[@class='button-comp-lbl bg-color-d84e55']")
	public WebElement  selectPassenger_button ;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Reschedule')]")
	public WebElement  reschedule ;

	@FindBy(how = How.XPATH, using = " //input[@id='searchTicket']")
	public WebElement  TicketNo_Element2 ;

	@FindBy(how = How.XPATH, using = "//input[@id='searchEmail']")
	public WebElement  email_Element2 ;

	@FindBy(how = How.XPATH, using = "//input[@id='ticketSearch']")
	public WebElement  Search_button ;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
	public WebElement ShowMyTicket;

	@FindBy(how = How.XPATH, using = "//input[@id='searchTicketTIN']")
	public WebElement Ticketno_Element3;

	@FindBy(how = How.XPATH, using = "//input[@id='searchTicketEmail']")
	public WebElement email_Element3;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Email/SMS')]")
	public WebElement SMS_Element;

    public void ClickOnManageBooking() {
		managebooking.click();
    }

	public void CancelTicket(String ticket, String email) {
		Cancel.click();
		ExplicitWait(Ticketno_Element1);
		Ticketno_Element1.sendKeys(ticket);
		email_Element1.sendKeys(email);
		selectPassenger_button.click();
	}

	public void RescheduleBooking(String ticket,String email) throws InterruptedException{
		reschedule.click();
		TicketNo_Element2.sendKeys(ticket);
		email_Element2.sendKeys(email);
		ExplicitWait(Search_button);
		Search_button.click();
	}

	public void MyTicket(String ticket,String Email) throws InterruptedException{
		ShowMyTicket.click();
		Ticketno_Element3.sendKeys(ticket);
		email_Element3.sendKeys(Email);
		ExplicitWait(Search_button);
		Search_button.click();
    }

	public void Sms(String ticket,String email)  throws InterruptedException{
		SMS_Element.click();
		Ticketno_Element3.sendKeys(ticket);
		email_Element3.sendKeys(email);
		ExplicitWait(Search_button);
		Search_button.click();
     }
}
