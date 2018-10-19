package com.aj.assignment.po.wallethub;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.support.FindBy;

import com.aj.assignment.global.CustomWait;
import com.aj.assignment.global.SeleniumBasePage;

public class WallethubHomePage extends SeleniumBasePage{

	@FindBy(xpath="//*[@id='wh-body-inner']/div[2]/div[3]/span")
	public static WebElement ratingHover;
	
	@FindBy(xpath="//*[@id='wh-body-inner']/div[2]/div[3]/div[1]/div/a")
	public static List<WebElement> starRating;
	
	@FindBy(xpath="//*[@id='footer_cta']/span/span/i[1]")
	public static WebElement openBanner;
	@FindBy(xpath="//*[@id='footer_cta']/span/span/i[2]")
	public static WebElement closeBanner;
	
	
	public WallethubRatingPage selectStarRating() throws InterruptedException {
		
		CustomWait.waitForWebElementElementToBeVisible(openBanner).click();
		Thread.sleep(1000);
		CustomWait.waitForWebElementElementToBeVisible(closeBanner).click();
		
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(ratingHover);
		
		Thread.sleep(1000);
		actions.moveToElement(starRating.get(1));
		Thread.sleep(1000);
		actions.moveToElement(starRating.get(2));
		Thread.sleep(1000);
		actions.moveToElement(starRating.get(3));
		Thread.sleep(1000);
		actions.moveToElement(starRating.get(4));
		
		actions.click().build().perform();
		
		
		Thread.sleep(3000);
		return new WallethubRatingPage();
	}
	
	
	
}
