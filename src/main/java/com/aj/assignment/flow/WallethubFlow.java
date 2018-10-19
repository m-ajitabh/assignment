package com.aj.assignment.flow;

import com.aj.assignment.global.CustomWait;
import com.aj.assignment.po.wallethub.WallethubHomePage;
import com.aj.assignment.po.wallethub.WallethubLoginPage;
import com.aj.assignment.po.wallethub.WallethubPage;
import com.aj.assignment.po.wallethub.WallethubRatingPage;
import com.aj.assignment.po.wallethub.WallethubReviewPage;
import com.aj.assignment.report.CustomReport;
import com.aventstack.extentreports.Status;

public class WallethubFlow extends CustomReport{
	
	public WallethubHomePage Login(String username, String password) {
		
		WallethubPage wPage = new WallethubPage();
		WallethubLoginPage loginPage = wPage.clickLogin();
		test.log(Status.INFO, "Set username");
		loginPage.setEmail(username);
		test.log(Status.INFO, "Set password");
		loginPage.setPass(password);
		test.log(Status.INFO, "click login");
		WallethubHomePage homePage = loginPage.clickLogin();
		
		return homePage;
		
	}
	
	
	public void giveRatingAndReview(String policy, int rate, String review) throws InterruptedException {
		WallethubHomePage homePage = new WallethubHomePage();
		
		WallethubRatingPage ratingPage = homePage.selectStarRating();
		CustomWait.waitForWebElementElementToBeVisible(ratingPage.dropdownPolicy);
		
		test.log(Status.INFO, "Selecting Policy");
		ratingPage.selectPolicy(policy);
		Thread.sleep(2000);
		test.log(Status.INFO, "Selecting review stars");
		ratingPage.selectRating(rate);
		test.log(Status.INFO, "Write the review");
		ratingPage.setReview(review);
		ratingPage.clickSubmit();
		
	}
	
	
	public String  checkReview() {
		WallethubReviewPage reviewPage = new WallethubReviewPage();
		
		return reviewPage.getReview();
	}
	
	

}
