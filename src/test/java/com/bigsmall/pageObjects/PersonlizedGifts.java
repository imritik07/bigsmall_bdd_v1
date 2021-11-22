package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.PersonalizedGiftsUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class PersonlizedGifts {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public PersonlizedGifts(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}
	public void clickPersonalized() throws InterruptedException {
		driver.findElement(PersonalizedGiftsUI.lnkPersGifts).click();
		 ExtentUtils.pass(driver, test, "Clicked on personalized Gifts", log);
		Thread.sleep(2000);
	}
	public void clickOnProduct() throws InterruptedException {
		driver.findElement(PersonalizedGiftsUI.product).click();
		log.debug("clicked on product");
		Thread.sleep(2000);
	}
	public void fillNameAndQty(String name, String qty) throws InterruptedException {
		driver.findElement(PersonalizedGiftsUI.name).sendKeys(name);
		log.debug("filled the name");
		Thread.sleep(1000);
		driver.findElement(PersonalizedGiftsUI.qty).sendKeys(qty);
		log.debug("filled the quantity");
		Thread.sleep(1000);
	}
	public void clickOnAddToCart() throws InterruptedException {
		driver.findElement(PersonalizedGiftsUI.addtoCart).click();
		log.debug("Clicked on add to cart");
		Thread.sleep(2000);
	}
	
}
