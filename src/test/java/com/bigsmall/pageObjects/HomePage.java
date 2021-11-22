package com.bigsmall.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.HomePageUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public HomePage(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void validateTitle() {
		assertEquals(driver.getTitle(), "Gifts Online - Send Unique, Unusual Gifts in India, Buy Gifts– Bigsmall.in",
				"Title verification failed");
		ExtentUtils.pass(driver, test, "Title Verifcation Success", log);
	}

	public void validateLogo() {
		if (driver.findElement(HomePageUI.logo).isDisplayed()) {
			ExtentUtils.pass(driver, test, "Logo Verification Success", log);
			assertTrue(true);
		} else {
			ExtentUtils.fail(driver, test, "Logo is not displayed", log);
			assertTrue(false, "Logo is not displayed.");
			
		}
	}

	public void validateSearchBox() {
		if (driver.findElement(HomePageUI.logo).isDisplayed()) {
			ExtentUtils.pass(driver, test, "SearchBox is  displayed", log);
			assertTrue(true);

		} else {
			ExtentUtils.fail(driver, test, "SearchBox is not displayed", log);
			assertTrue(false, "SearchBox is not displayed.");
		}
	}
	
}
