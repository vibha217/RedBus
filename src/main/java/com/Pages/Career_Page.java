package com.Pages;

import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Base.Base_Class;

public class Career_Page extends Base_Class {
	public Career_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//---------------------------------locators------------------------------------
	@FindBy(linkText = "Careers")
	WebElement carrers;

    @FindBy(xpath = "//a[@id='scroll-aHref-1']")
	WebElement ourCrew;

    @FindBy(linkText = "Life at redBus")
	WebElement lifeRedbus;

    @FindBy(linkText = "Jobs")
	WebElement jobs;

     public void carrersButton() {

		scrollBy();
		ExplicitWait(carrers);
		carrers.click();
	}






	public void crewButton() {
		ExplicitWait(ourCrew);



		ourCrew.click();
	}



	public void lifeRedbusButton() {
		ExplicitWait(lifeRedbus);
		lifeRedbus.click();
	}



	public void jobsButton() {
		ExplicitWait(jobs);
		jobs.click();
	}

	public void switchCarrer() {
		String mainHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,250)");
		for (String windowHandle : allHandles) {
			if (!mainHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				crewButton();
				lifeRedbusButton();
				jobsButton();
				driver.close();



			}
			driver.switchTo().window(mainHandle);



		}
	}



}


