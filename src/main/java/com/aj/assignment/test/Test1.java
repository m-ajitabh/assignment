package com.aj.assignment.test;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aj.assignment.flow.FacebookFlow;
import com.aj.assignment.flow.WallethubFlow;
import com.aj.assignment.global.CustomWait;
import com.aj.assignment.global.SeleniumBaseTest;
import com.aj.assignment.global.TestConstant;
import com.aj.assignment.po.facebook.FacebookHomePage;
import com.aj.assignment.po.facebook.FacebookPage;
import com.aj.assignment.po.wallethub.WallethubHomePage;
import com.aj.assignment.po.wallethub.WallethubPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



//@Listeners(value=com.aj.assignment.report.CustomReport.class)

public class Test1 extends SeleniumBaseTest{

	String facebookUser, facebookPass, fmessage;
	
	String whUser , whPass,	whReview ;
	
	@BeforeMethod
	void initData() {
		facebookUser = DataSource.getDataSource(TestConstant.FACEBOOKUSER);
		facebookPass = DataSource.getDataSource(TestConstant.FACEBOOKPASS);
		fmessage = DataSource.getDataSource(TestConstant.FACEBOOKMESSAGE);
		
		whUser = DataSource.getDataSource(TestConstant.WALLETHUBUSER);
		whPass = DataSource.getDataSource(TestConstant.WALLETHUBPASS);
		whReview = DataSource.getDataSource(TestConstant.WALLETHUBREVIEW);
	}
	
	
	@Test
	public void test001() throws InterruptedException{
		
		test = extent.createTest("Verify to write a post on Facebook");
		test.log(Status.INFO, "Write a post ");
		
		driver.get("http://www.facebook.com");
		Thread.sleep(3000);
		FacebookPage fbPage = new FacebookPage();
		//CustomWait.waitForWebElementElementToBeVisible(fbPage.loginButton); // wait till it appears
		FacebookFlow fbFlow = new FacebookFlow();
		
		fbFlow.appPostToFB(facebookUser, facebookPass, fmessage);
		
	}
	
	
	@Test
	public void test002() throws InterruptedException{
		
		test = extent.createTest("Goto WalletHub Login");
		test.log(Status.INFO, "Login the user");
		
		driver.get("http://wallethub.com/profile/test_insurance_company/");
		
		WallethubFlow hubFlow = new WallethubFlow();
		
		WallethubHomePage homePage = hubFlow.Login(whUser, whPass);
		
		hubFlow.giveRatingAndReview("Health", 5, whReview);
		
		Thread.sleep(3000);
		
		
	}

	
	@Test
	public void test003() throws InterruptedException{
		
		test = extent.createTest("Goto WalletHub Review");
		test.log(Status.INFO, "The user's review");
		
		String [] name = whUser.split("@");
		String url = "https://wallethub.com/profile/"+name[0]+"/reviews/";
		driver.get(url);
		
		System.out.println(url);
		WallethubFlow hubFlow = new WallethubFlow();
		String rvw = hubFlow.checkReview();
		
		System.out.println(rvw);
		
		test.log(Status.INFO, "Asserting the review");
		Assert.assertEquals(whReview, rvw);
		
		Thread.sleep(5000);
		
	}

}
