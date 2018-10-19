package com.aj.assignment.po.wallethub;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aj.assignment.global.CustomWait;
import com.aj.assignment.global.SeleniumBasePage;

public class WallethubRatingPage extends SeleniumBasePage {
	
	@FindBy(xpath="//*[@id='reviewform']/div[1]/div/div")
	public static WebElement dropdownPolicy;
	
	@FindBy(xpath="//*[@id='reviewform']/div[1]/div/ul/li")
	public static List<WebElement> dropdownPolicyList;
	
	public void selectPolicy(String policy) {
		CustomWait.waitForWebElementElementToBeVisible(dropdownPolicy).click();
		if(policy.equalsIgnoreCase("Annuities")) {
			CustomWait.waitForWebElementElementToBeVisible(dropdownPolicyList.get(0)).click();
		}else if(policy.equalsIgnoreCase("Health")) {
			CustomWait.waitForWebElementElementToBeVisible(dropdownPolicyList.get(1)).click();
		}else if(policy.equalsIgnoreCase("Life")) {
			CustomWait.waitForWebElementElementToBeVisible(dropdownPolicyList.get(2)).click();
		}else{
			CustomWait.waitForWebElementElementToBeVisible(dropdownPolicyList.get(3)).click();
		}
	}
	
	@FindBy(xpath="//*[@id='overallRating']/a")
	public static List<WebElement> rating;
	public void selectRating(int rate) {
		System.out.println("rating:- "+rate);
		Actions actions = new Actions(driver);
		
		CustomWait.waitForWebElementElementToBeVisible(rating.get(rate-1));
		if(rate == 1) {
			actions.moveToElement(rating.get(rate-1));
		}else if(rate == 2) {
			actions.moveToElement(rating.get(rate-1));	
		}else if(rate == 3) {
			actions.moveToElement(rating.get(rate-1));	
		}else if(rate == 4) {
			actions.moveToElement(rating.get(rate-1));	
		}else if(rate == 5) {
			actions.moveToElement(rating.get(rate-1));	
		}
		
		actions.click().build().perform();
	}
	
	
	@FindBy(id="review-content")
	public static WebElement review;
	public void setReview(String data) {
		CustomWait.waitForWebElementElementToBeVisible(review).clear();
		review.sendKeys(data);
	}
	
	
	@FindBy(xpath="//*[@id='reviewform']/div[3]/div[2]/input")
	public static WebElement reviewSubmit;
	public void clickSubmit() {
		CustomWait.waitForWebElementElementToBeVisible(reviewSubmit).click();
	}

}
