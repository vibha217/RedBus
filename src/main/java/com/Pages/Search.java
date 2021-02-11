package com.Pages;

import java.sql.Time;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;

import com.Base.Base_Class;



public class Search extends Base_Class{



	public Search(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement source;

	@FindBy(how = How.XPATH, using = ".//*[@id='search']/div/div[1]/div/ul/li[1]")
	public WebElement srcSend;


	@FindBy(how = How.XPATH, using ="//input[@id='dest']")
	public WebElement destination;

	@FindBy(how = How.XPATH, using =".//*[@id=\"search\"]/div/div[2]/div/ul/li[1]")
	public WebElement  destSend;

	@FindBy(xpath="//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")
	public WebElement calendar_click;

	@FindBy(how = How.XPATH , using = "//*[text() = '12']")
	public WebElement select_date;

	//  @FindBy(how = How.XPATH, using = "//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]")
	// public  WebElement abc;

	//   @FindBy(how = How.XPATH, using = "/*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[5]/td[4]")
	//   public WebElement c;

	@FindBy(xpath="//button[@id='search_btn']")
	WebElement search_button;

	public void enter_source(String src) throws Exception{
		Thread.sleep(5000);
		source.sendKeys(src);
		srcSend.click();
    }

	public void enter_destination(String dest) {

		destination.sendKeys(dest);
		destSend.click();
    }
	
	public void click_calendar() throws InterruptedException {
		Thread.sleep(3000);
        calendar_click.click();
	}

    public void Select_date() throws InterruptedException {

		//	ExplicitWait(calendar_click);

		Thread.sleep(1000);
         //selectDate("17");
		Actions action = new Actions(driver);
		action.moveToElement(select_date).click().perform();
        Thread.sleep(1000);
		//ExplicitWait(search_button);
     }

	public void click_searchButton() {
		search_button.click();
	}





}
