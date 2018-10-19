package com.aj.assignment.global;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait extends SeleniumBaseTest {
	static WebDriver driver = (WebDriver) getWebDriver();

	@SuppressWarnings("unchecked")
	public static WebElement waitForWebElementElementToBeVisible(WebElement element) {

		FluentWait fluentWait = new FluentWait(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}

	public static WebElement waitForWebElementElementToBeVisible1(final WebElement element) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		 WebElement element1 = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				
				//String getTextOnPage = element.getText();
				if (element.isDisplayed()) {
					return element;
				} else {
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		 });
		 
		 return element1;
	}

}