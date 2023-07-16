package com.loginModule;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.amazon.AmazonBaseClass;

public class LoginTest extends AmazonBaseClass {

	Login log;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");

	// Constructor
	public LoginTest() {
		super();
	}

	@BeforeSuite()
	public void initSetup() {
		initiate();
		log = new Login();
		log.login();
	}

	@AfterSuite
	public void close() throws InterruptedException {
		log.signinMouseHover();
		Thread.sleep(1000);
		log.signOut();
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void verifyTitle() {
		String actual = log.verify();
		System.out.println("The actual page title is " + actual);
		Assert.assertEquals(actual.substring(0, 9), "Amazon.ca");
	}

	@Test
	public void LowToHighFilterFeature() throws InterruptedException {
		log.searchFeature();
		log.sortByLowToHigh();
	}

	@Test
	public void HighToLowFilterFeature() throws InterruptedException {
		log.searchFeature();
		log.sortByHighToLow();
	}

	@Test
	public void CustomerReviewFilterFeature() throws InterruptedException {
		log.searchFeature();
		log.sortByFeatureCustomerReview();
	}

	@Test
	public void NewestArrivalsFilterFeature() throws InterruptedException {
		log.searchFeature();
		log.sortByFeatureNewestArrivals();
	}

	@Test
	public void VerifySearchFeature() throws InterruptedException {
		log.searchFeature();
	}

	@Test
	public void verifyAddToCart() {
		log.addtocart();
	}

	@Test
	public void addYourAddress() throws InterruptedException {
		log.signinMouseHover();
		Thread.sleep(1000);
		log.clickSignIn();
		log.addAddress();
	}

	@Test
	public void validateOrders() throws InterruptedException {
		log.signinMouseHover();
		Thread.sleep(3000);
		log.clickSignIn();
		log.accessYourAccount();
		Thread.sleep(1000);
	}

	@Test
	public void addPaymentDetails() throws InterruptedException {
		log.signinMouseHover();
		Thread.sleep(3000);
		log.clickSignIn();
		log.addYourPayments();
	}

}