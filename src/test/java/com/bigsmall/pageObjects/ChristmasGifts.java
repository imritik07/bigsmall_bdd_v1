package com.bigsmall.pageObjects;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.ChristmasGiftsUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class ChristmasGifts extends ChristmasGiftsUI {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public ChristmasGifts(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}
	public void clickChristmas() throws InterruptedException {
		try {
		driver.findElement(ChristmasGiftsUI.lnkChristmas).click();
		ExtentUtils.pass(driver, test, "Clicked on christmas gifts", log);
		}catch(NullPointerException e) {
			log.warn("link Christmas not working "+e.getMessage());
			assertTrue(false, "link Christmas not working");
		}
		Thread.sleep(2000);
	}
	public void selectProduct() throws InterruptedException {
		driver.findElement(ChristmasGiftsUI.stagecoachProduct).click();
		log.debug("Clicked on StagecoachProduct");
		Thread.sleep(2000);
	}
	public void fetchDetails() throws InterruptedException {
		String productPrice = driver.findElement(ChristmasGiftsUI.price).getText();
		log.info("Price: "+productPrice);
		Thread.sleep(1000);
		driver.findElement(ChristmasGiftsUI.postal).sendKeys("462026");
		Thread.sleep(1000);
		driver.findElement(ChristmasGiftsUI.btnCheck).click();
		Thread.sleep(3000);
		log.info(driver.findElement(ChristmasGiftsUI.codAvailablity).getText());
	}
}
