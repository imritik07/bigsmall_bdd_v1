package com.bigsmall.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.PersonlizedGifts;
import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExtentUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonlizedStep  extends BaseClass{
	PersonlizedGifts pg = null;
	public WebDriver driver = null;
	
	@Before("@Personalized")
	public void init() {
		test = report.startTest("Personlized Gifts");
		log = Logger.getLogger(PersonlizedStep.class.getName());
		driver = initialize();
		pg = new PersonlizedGifts(driver, log, test);
		System.out.println("Personlized Gifts");
	}
	@Given("open this base {string} for personlized gifts")
	public void open_this_base_for_personlized_gifts(String url) throws InterruptedException {
		driver.navigate().to(url);
		ExtentUtils.pass(driver, test, "Navigated to the url", log);
		Thread.sleep(1000);
	}
	@When("click on the personlized gifts from the nav bar")
	public void click_on_the_personlized_gifts_from_the_nav_bar() throws InterruptedException {
	   pg.clickPersonalized();
	}

	@Then("clicked on the {string}")
	public void clicked_on_the(String string) throws InterruptedException {
	  pg.clickOnProduct();
	}

	@Then("enter {string} and {string}")
	public void enter_and(String name, String qty) throws InterruptedException {
	 pg.fillNameAndQty(name, qty);
	 ExtentUtils.pass(driver, test, "Filled the name and quantity", log);
	}

	@Then("click on add to cart")
	public void click_on_add_to_cart() throws InterruptedException {
	    pg.clickOnAddToCart();
	    ExtentUtils.pass(driver, test, "Clicked on Add to cart", log);
	    ExtentUtils.pass(driver, test, "Personalized Gifts Test Executed", log);
	}
	@After("@Personalized")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
