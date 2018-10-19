package com.aj.assignment.flow;

import com.aj.assignment.global.CustomWait;
import com.aj.assignment.po.facebook.FacebookHomePage;
import com.aj.assignment.po.facebook.FacebookPage;

public class FacebookFlow {
	
	public FacebookHomePage facebookLogin(String username, String password) throws InterruptedException {
		
		FacebookPage fbPage = new FacebookPage();
		
		fbPage.setUserName(username);
		fbPage.setPassword(password);
		return fbPage.clickLogIn();
		
		
	}
	
	public void appPostToFB(String username, String password, String message) throws InterruptedException {
		
		FacebookHomePage fbHomePage = facebookLogin(username, password);
		Thread.sleep(3000);
		fbHomePage.setMessage(message);
		fbHomePage.selectShareTo();
		Thread.sleep(3000);
		System.out.println(fbHomePage.getMessage());
		
	}

}
