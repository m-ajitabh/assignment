package com.aj.assignment.po.facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aj.assignment.global.CustomWait;
import com.aj.assignment.global.SeleniumBasePage;

public class FacebookHomePage  extends SeleniumBasePage {
	
	
	@FindBy(xpath="//*[text()='Compose Post']")
	public static WebElement composePost;
	
					  //*[@id="js_26"]/div[1]/div/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div
	@FindBy(xpath =  "//*[@id='js_26']/div[1]/div/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div")//"//div[@class='_1mf _1mj']")
	public static WebElement post;
	public void setMessage(String msg) {
		CustomWait.waitForWebElementElementToBeVisible(composePost).click();
		CustomWait.waitForWebElementElementToBeVisible(post).click();
		post.sendKeys(msg);
	}
	
	@FindBy(xpath = "//*[@id='js_26']/div[2]/div[3]/div[1]/div/ol/li[1]/div[1]/ol/li/div")//"//div[@class='_1se_']")
	public static List<WebElement> shareTo;
	public void selectShareTo() {
		CustomWait.waitForWebElementElementToBeVisible(shareTo.get(0)).click();
	}
	
	@FindBy(xpath="//button/*[text()='Share']")
	public static WebElement share;
	
	@FindBy(xpath="//div[@class='_5_jv _58jw']")
	public static List<WebElement> cards;
	
	public String getMessage() {
		return cards.get(0).getText().trim().toString();
	}
	

}
