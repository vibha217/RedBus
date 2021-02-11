package com.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {

	public static WebDriver driver;

	public Base_Class(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
     
	//action to perform scroll by element
	public static void scroll(WebElement element) 
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	//action to perform scroll 
	public static void scrollBy() 
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,5000)");
    }

	//method for explicit wait
    public static void ExplicitWait(WebElement element) 
    {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
    }

}

