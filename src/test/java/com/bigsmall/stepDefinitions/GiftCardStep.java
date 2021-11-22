package com.bigsmall.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.GiftCard;
import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExtentUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GiftCardStep extends BaseClass {
	GiftCard cc = null;
	public WebDriver driver = null;

	@Before("@GiftCard")
	public void init() {
		test = report.startTest("Gift Card");
		log = Logger.getLogger(GiftCardStep.class.getName());
		driver = initialize();
		cc = new GiftCard(driver, log, test);
		System.out.println("Gift Card");
	}

	@Given("open the homepage")
	public void open_the_homepage() throws InterruptedException {
		driver.navigate().to(pro.getProperty("baseURL"));
		ExtentUtils.pass(driver, test, "Navigated to the Base Url.", log);
		Thread.sleep(2000);
	}

	@When("click on the Gift Card")
	public void click_on_the_gift_card() throws InterruptedException {
		cc.clickOnGiftCardLink();
	}

	@Then("select the amount for gift card and quantity {string}")
	public void select_the_amount_for_gift_card_and_quantity(String qty) throws InterruptedException {
		cc.selectQty(qty);
	}

	@Then("Add to wishlist")
	public void add_to_wishlist() throws InterruptedException {
		cc.clickAddtoWishList();
	}

	@Then("click on close popup")
	public void click_on_close_popup() {
		cc.closePopup();
		ExtentUtils.pass(driver, test, "Gift Card Test is executed.", log);
	}

	@After("@GiftCard")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}

}
