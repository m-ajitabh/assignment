package com.aj.assignment.po.wallethub;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aj.assignment.global.SeleniumBasePage;

public class WallethubReviewPage extends SeleniumBasePage {

	@FindBy(xpath="//*[starts-with(@id,'review')]/p")
	public static List<WebElement> reviews;
	
	public String getReview() {
		
		return reviews.get(0).getText().trim().toString();
	}
	
	
	
}
