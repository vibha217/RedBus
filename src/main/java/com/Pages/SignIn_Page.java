package com.Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base_Class;

public class SignIn_Page extends  Base_Class{
	 
	public SignIn_Page(WebDriver driver) {
		super(driver);
	}

	  @FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	  public WebElement icon_profile;
	   
	  @FindBy(how = How.XPATH, using = "//li[@id='signInLink']")
	  public WebElement signIn;
	   
	  @FindBy(how = How.CLASS_NAME, using = "modalIframe")
	  public WebElement frame;
	   
	  @FindBy(how = How.ID, using = "newFbId")
	  public  WebElement facebook_button; 
	   
	  @FindBy(how = How.ID, using = "email")
	  public static  WebElement facebook_email;
	   
	  @FindBy(how = How.ID, using = "pass")
	  public static WebElement facebook_password;
	   
	  @FindBy(how = How.ID, using = "loginbutton")
	  public WebElement LogIn_button;
	   
	  @FindBy(how = How.XPATH, using = "//i[@class= 'icon-close']")
	  public WebElement close;
	   
	  public void click_icon_profile1() {
	   //ExplicitWait(icon_profile);
		icon_profile.click();
		
	  }
	  
	  public void click_signIn() {
		//ExplicitWait(signIn);
		  signIn.click();
	  }

	  public  void SwitchWindowFacebook(String Email,String Password) throws InterruptedException{
	    driver.switchTo().frame(frame);
	    Thread.sleep(2000);
	    facebook_button.click();
	    Thread.sleep(1000);
	    
		String mainWindow = driver.getWindowHandle();
	//	waitForElement(facebook_button);
		
		Set<String> handles = driver.getWindowHandles();
		for(String childWindow : handles) {
		 if(!childWindow.equals(mainWindow)) {
		     driver.switchTo().window(childWindow);
		     facebook_email.sendKeys(Email);
		     facebook_password.sendKeys(Password);
		     LogIn_button.click();
		    Thread.sleep(5000);
		    }
		 
		   }
	//	ExplicitWait(driver.switchTo().window(mainWindow));
		driver.switchTo().window(mainWindow);
		 }
	  
	  public void click_close() {
	  close.click();
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

//		Login Methods

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




