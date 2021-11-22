package com.bigsmall.stepDefinitions;

import static org.testng.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.ChristmasGifts;
import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExtentUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChristmasGiftsStep extends BaseClass {
	ChristmasGifts ch = null;
	public WebDriver driver = null;

	@Before("@ChristmasGifts")
	public void init() {
		log = Logger.getLogger(ChristmasGiftsStep.class.getName());
		test = report.startTest("Christmas Gifts");
		driver = initialize();
		System.out.println("Christmas Gifts");
		ch = new ChristmasGifts(driver, log, test);
	}

	@Given("open this base {string} for chirstmas gifts")
	public void open_this_base_for_chritmas_gifts(String url) {
		if (driver != null) {
			driver.navigate().to(url);
			ExtentUtils.pass(driver, test, "Navigated to url.", log);
			assertTrue(true);
		} else {
			ExtentUtils.fail(driver, test, "Driver not intialized!!!", log);
			assertTrue(false, "Driver not intialized!!!");
		}
	}

	@When("click on the Christmas gifts in from the nav bar")
	public void click_on_the_christmas_gifts_in_from_the_nav_bar() throws InterruptedException {
		ch.clickChristmas();
	}

	@Then("click on the {string}")
	public void click_on_the(String product) throws InterruptedException {
		ch.selectProduct();
	}

	@Then("fetch the product price and check cod on this {string}")
	public void fetch_the_product_price_and_check_cod_on_this(String string) throws InterruptedException {
		ch.fetchDetails();
		ExtentUtils.pass(driver, test, "Details fetched Successfully", log);
		ExtentUtils.pass(driver, test, "Corporate Test Completed", log);
	}

	@After("@ChristmasGifts")
	public void getLl() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
