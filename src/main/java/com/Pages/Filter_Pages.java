package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Base.Base_Class;



public class Filter_Pages extends Base_Class {

	public Filter_Pages(WebDriver driver) {
		super(driver);
	 }

	@FindBy(xpath = "//i[@class='icon icon-close c-fs']")
	WebElement close;

	@FindBy(xpath = "//ul[@class='addn-filters']//span[contains(text(),'Live Tracking')]")
	WebElement live_tracking;

	@FindBy(xpath = "//ul[@class='addn-filters']//span[contains(text(),'Red Deals')]")
	WebElement red_deals;

	@FindBy(xpath = "//ul[@class='addn-filters']//span[contains(text(),'Reschedulable')]")
	WebElement reschedulable;

	@FindBy(xpath = "//label[@for='dtAfter 6 pm' and @class='custom-checkbox']")
	WebElement dt_after6pm;

	@FindBy(xpath = "//label[@for='bt_SEATER' and @title='SEATER']")
	WebElement bus_type_seater;

	@FindBy(xpath = "//label[@for='atBefore 6 am' and @class='custom-checkbox']")
	WebElement at_before6am;

	public void click_livetracking() {
		//ExplicitWait(close);
		//close.click();
		live_tracking.click();
    }

	public void busSeating() throws Exception {
		ExplicitWait(bus_type_seater);
		bus_type_seater.click();
		//scroll(dt_after6pm);
    }

	public void selectArrivalTime() {
		ExplicitWait(dt_after6pm);
		dt_after6pm.click();
	}
}
