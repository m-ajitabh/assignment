package com.aj.assignment.po.facebook;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;

import com.aj.assignment.global.CustomWait;
import com.aj.assignment.global.SeleniumBasePage;

public class FacebookPage extends SeleniumBasePage {

	@FindBy(id = "email")
	public static WebElement email;
	
	public void setUserName(String data) {
		CustomWait.waitForWebElementElementToBeVisible(email).sendKeys(data);
	}

	@FindBy(id = "pass")
	public static WebElement password;
	public void setPassword(String data) {
		CustomWait.waitForWebElementElementToBeVisible(password).sendKeys(data);
	}
	
	@FindBy(id = "u_0_2")
	public static WebElement loginButton;
	public FacebookHomePage clickLogIn() {
		CustomWait.waitForWebElementElementToBeVisible(loginButton).click();
		return new FacebookHomePage();
	}

	

}
