package com.bigsmall.pageObjects;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.bigsmall.uistore.GiftsDropdownUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class GiftsDropdown {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public GiftsDropdown(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}
	public void hoveraAndClickOption() throws InterruptedException {
		Actions a = new Actions(driver);
		WebElement giftlink= driver.findElement(GiftsDropdownUI.lnkGiftsDd);
		a.moveToElement(giftlink).build().perform();
		log.debug("hovering on gift");
		Thread.sleep(1000);
		try {
		a.moveToElement(driver.findElement(GiftsDropdownUI.ddOptionforGirls)).click().build().perform();
		ExtentUtils.pass(driver, test, "clicked on options for girls.", log);
		}
		catch(NullPointerException e) {
			ExtentUtils.fail(driver, test, "Unable to click on dropdown", log);
			assertTrue(false,"Unable to click on dropdown");
		}
	}
	public void selectProduct() {
		driver.findElement(GiftsDropdownUI.productWoodenPopSkt).click();
		ExtentUtils.pass(driver, test, "clicked on product.", log);
	}
	public void verifyAndFetch(String name) {
		 String ActualPname = driver.findElement(GiftsDropdownUI.productTitle).getText();
			if (name.equals(ActualPname)) {
				log.info("Product name verified");
				ExtentUtils.pass(driver, test, "Product name verified", log);
				log.info("Product Name: "+ ActualPname);
				log.info("Price: "+driver.findElement(GiftsDropdownUI.price).getText());
				log.info(driver.findElement(GiftsDropdownUI.desc).getText());
				ExtentUtils.pass(driver, test, "Product details verified and fetched.", log);
			}
			else
			{
				ExtentUtils.fail(driver, test, "Product name verification failed!!!", log);
				assertTrue(false, "Product name verification failed!!!");
			}
	}
}
