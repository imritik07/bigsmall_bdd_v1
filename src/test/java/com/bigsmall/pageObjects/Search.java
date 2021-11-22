package com.bigsmall.pageObjects;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.SearchUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Search {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public Search(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void sendProductName(String name) {
		driver.findElement(SearchUI.searchBox).sendKeys(name);
		log.debug("product name entered");
	}

	public void clickAndVerify( String title) throws InterruptedException {
		driver.findElement(SearchUI.searchBox).sendKeys(Keys.ENTER);
		log.debug("clicked on search");
		Thread.sleep(3000);
		
		if(driver.getTitle().equals(title)) {
			test.log(LogStatus.PASS, "Title Verified.");
			ExtentUtils.pass(driver, test, "Search Test Executed.", log);
			assertTrue(true);
			}
		else {
			ExtentUtils.pass(driver, test, "Title couldn't verified.", log);
			assertTrue(false,"Title couldn't verified.");
		}
	}
	
}
