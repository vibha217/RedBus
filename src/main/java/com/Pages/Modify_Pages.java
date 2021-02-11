package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Base.Base_Class;




//import in.RedBus.Base.PageObject;

public class Modify_Pages extends Base_Class{

	public Modify_Pages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH , using ="//div[@class='close']")
	public WebElement icon_close;

	@FindBy(how = How.XPATH , using ="//div[contains(text() ,'Modify') and @class='onward-modify-btn g-button clearfix fl']")
	public WebElement modify_button;

	@FindBy(how = How.XPATH , using ="//input[@id='dest']")
	public WebElement modify_destination;

	@FindBy(how = How.XPATH, using = "//button[@class ='button ms-btn']")
	public WebElement modify_interact_dest;

	@FindBy(how = How.XPATH, using = "//button[@class ='button ms-btn']")
	public WebElement date_tab;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'button ms-btn')]")
	public WebElement search_button;

	public void click_iconClose() throws InterruptedException {
		//ExplicitWait(icon_close);
		Thread.sleep(1000);
		icon_close.click();


	}

	public void modify_dest(String dest) throws Exception{
		Thread.sleep(5000);
		ExplicitWait(modify_button);
		modify_button.click();
		//ExplicitWait(modify_destination);
		Thread.sleep(5000);
		modify_destination.clear();
		modify_destination.sendKeys(dest);
		//ExplicitWait(date_tab);

		//date_tab.click();
		//
		//	date_tab.click();
		Thread.sleep(2000);
		search_button.click();

	}












}


