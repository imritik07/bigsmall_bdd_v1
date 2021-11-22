package com.bigsmall.pageObjects;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.GiftCardUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GiftCard {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public GiftCard(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}
	public void clickOnGiftCardLink() throws InterruptedException {
		driver.findElement(GiftCardUI.lnkGiftCard).click();
		log.debug("clicked on Gift Card link");
		test.log(LogStatus.PASS,"clicked on Gift Card");
		Thread.sleep(2000);
	}
	public void selectQty(String qty) throws InterruptedException {
		try {
		driver.findElement(GiftCardUI.qty).clear();
		driver.findElement(GiftCardUI.qty).sendKeys(qty);
		log.debug("Add the quantity");
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "added the quantity");
		}
		catch(NullPointerException ne) {
			ExtentUtils.fail(driver, test, "couldn't select Amount or Give the quantity", log);
			assertTrue(false, "couldn't select Amount or Give the quantity");
		}
	}
	public void clickAddtoWishList() throws InterruptedException {
		try {
		driver.findElement(GiftCardUI.addtoWishList).click();
		test.log(LogStatus.PASS, "Clicked on Add to wishlist.");
		Thread.sleep(2000);
		}catch(NullPointerException ne) {
			ExtentUtils.fail(driver, test, "couldn't add to wishlist", log);
			assertTrue(false, "couldn't add to wishlist");
		}
	}
	public void closePopup() {
		if(driver.findElement(GiftCardUI.closePopup).isDisplayed()) {
			driver.findElement(GiftCardUI.closePopup).click();
			log.debug("closed Popup");
			test.log(LogStatus.PASS, "Closed the popup");
		}
	}
}
