package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.CorporateGiftsUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class CorporateGifts {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public CorporateGifts(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}
	public void cilckCorporate() {
		driver.findElement(CorporateGiftsUI.lnkCorporateGifts).click();
		ExtentUtils.pass(driver, test, "clicked on corporate link", log);
	}
	public void fillDetails(String name, String email, String mobile) throws InterruptedException {
		driver.findElement(CorporateGiftsUI.name).sendKeys(name);
		log.debug("Entered Name.");
		Thread.sleep(1000);
		driver.findElement(CorporateGiftsUI.email).sendKeys(email);
		log.debug("Entered Email.");
		Thread.sleep(1000);
		driver.findElement(CorporateGiftsUI.mobile).sendKeys(mobile);
		log.debug("Entered Mobile Number.");
		Thread.sleep(1000);
		ExtentUtils.pass(driver, test, "filled the details", log);
	}
	public void submit() throws InterruptedException {
		driver.findElement(CorporateGiftsUI.btnSubmit).click();
		ExtentUtils.pass(driver, test, "Clicked on submit", log);
		Thread.sleep(2000);
	}
}
