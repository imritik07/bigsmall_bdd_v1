package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.TrackOrderUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TrackOrder {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public TrackOrder(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void openTrackPage() throws InterruptedException {
		driver.findElement(TrackOrderUI.trackOrder).click();
		log.debug("clicked on Track order");
		Thread.sleep(3000);
	}

	public void verifyPage(String title) throws InterruptedException {
		Thread.sleep(2000);
		if(driver.getTitle().equals(title))
		{
			log.info("Landed on the right page");
			test.log(LogStatus.PASS, "Landed on the right page");
		}
		else {
			log.warn("Landed on some another page.");
			test.log(LogStatus.FAIL, "Landed on the another page");
		}
	}

	public void fillDetailsAndGetResponce(String email, String id) throws InterruptedException {
		driver.findElement(TrackOrderUI.email).sendKeys(email);
		driver.findElement(TrackOrderUI.oid).sendKeys(id);
		log.debug("filled the details");
		driver.findElement(TrackOrderUI.findbtn).click();
		log.debug("Clicked on track");
		Thread.sleep(2000);
		String responce= driver.findElement(TrackOrderUI.response).getText();
		log.info("Status of your order: " +responce);
		ExtentUtils.pass(driver, test, "Tracked the order", log);
	}
}
