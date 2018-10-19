package com.aj.assignment.po.wallethub;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aj.assignment.global.CustomWait;
import com.aj.assignment.global.SeleniumBasePage;
import com.aj.assignment.global.TestConstant;

public class WallethubPage extends SeleniumBasePage{
	
	@FindBy(xpath="//*[@id='viewport']/header/div/nav[3]/div[2]/a[1]")
	public static WebElement loginMenu;
	public WallethubLoginPage clickLogin() {
		CustomWait.waitForWebElementElementToBeVisible(loginMenu).click();
		
		return new WallethubLoginPage();
	}
	
		
		
}
