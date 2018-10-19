package com.aj.assignment.po.wallethub;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aj.assignment.global.CustomWait;
import com.aj.assignment.global.SeleniumBasePage;

public class WallethubLoginPage extends SeleniumBasePage{

	@FindBy(xpath=".//*[@id='join-login']/form/div[1]/input")
	public static WebElement email;
	public void setEmail(String emailid) {
		CustomWait.waitForWebElementElementToBeVisible(email).clear();
		email.sendKeys(emailid);
	}
	
	@FindBy(xpath="//*[@id='join-login']/form/div[2]/input")
	public static WebElement password;
	public void setPass(String pass) {
		CustomWait.waitForWebElementElementToBeVisible(password).clear();
		password.sendKeys(pass);
	}
	
	
	@FindBy(xpath="//*[@id='join-login']/form/div[4]/button[2]")
	public static WebElement loginButton;
	public WallethubHomePage clickLogin() {
		CustomWait.waitForWebElementElementToBeVisible(loginButton).click();
		
		return new WallethubHomePage();
	}

}
