package com.Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Base.Base_Class;


public class ProfileUpdate extends Base_Class {

	public ProfileUpdate(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath = "//div[@id='sign-in-icon-down']")
	WebElement icon_sign;

	@FindBy(xpath = "//li[contains(text(),'My Profile')]")
	WebElement list_profile;

	// Profile Locators

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'My Trips')]")
	WebElement MyTrips;

	@FindBy(how = How.XPATH, using = "//p[@class='wallet']")
	WebElement Wallet;

	@FindBy(how = How.XPATH, using = "//p[@class='Pro']")
	WebElement click_MyProfile;

	@FindBy(how = How.XPATH, using = "//span[@id='Editbtn']")
	WebElement Edit_button;

	@FindBy(how = How.XPATH, using = "//input[@id='profile-displayName']")
	WebElement Enter_name;

	@FindBy(how = How.XPATH, using = "//input[@id='female']")
	WebElement Select_Gender;

	@FindBy(how = How.XPATH, using = "//select[@id='profile-code']")
	WebElement Phone_code;

	@FindBy(how = How.XPATH, using = "//input[@id='profile-mobile']")
	WebElement Mobile_no;
	// input[@id='profile-DOB']

	@FindBy(how = How.XPATH, using = "//input[@id='profile-DOB']")
	WebElement date_click;

//	Login Methods

	public void clickOniconSign() throws Exception {

		icon_sign.click();

	}
	
	public void clickListProfile() {
		list_profile.click();
	}

//Profile Methods

	public void click_on_myprofile() {
		ExplicitWait(click_MyProfile);
		click_MyProfile.click();

	}

	public void click_wallet() {
		ExplicitWait(Wallet);
		Wallet.click();

	}

	public void update_myProfile(String name, String code, String Phoneno) throws InterruptedException {
		click_on_myprofile();
		Thread.sleep(2000);
		Edit_button.click();
		Enter_name.sendKeys(name);
		Select_Gender.click();
		Phone_code.sendKeys(code);
		Thread.sleep(1000);
		Phone_code.click();
		Mobile_no.sendKeys(Phoneno);
		date_click.click();

	}

}

