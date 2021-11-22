package com.bigsmall.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.GiftsDropdown;
import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExtentUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GiftsDropdownStep extends BaseClass {
	GiftsDropdown gd = null;
	public WebDriver driver = null;

	@Before("@GiftsDropdown")
	public void init() {
		test = report.startTest("Gifts Dropdown");
		log = Logger.getLogger(GiftsDropdownStep.class.getName());
		driver = initialize();
		gd = new GiftsDropdown(driver, log, test);
		System.out.println("Gifts Dropdown");
	}

	@Given("open this base url for Gifts dropdown link")
	public void open_this_base_url_for_gifts_dropdown_link() {
		driver.navigate().to(pro.getProperty("baseURL"));
		ExtentUtils.pass(driver, test, "Navigated to the Base Url.", log);
	}

	@When("hover on the Gifts and click on Gifts for girls")
	public void hover_on_the_gifts_and_click_on_gifts_for_girls() throws InterruptedException {
		gd.hoveraAndClickOption();
		ExtentUtils.pass(driver, test, "Hover functionality is working fine.", log);
	}

	@Then("select the product")
	public void select_the_product() throws InterruptedException {
		Thread.sleep(3000);
		gd.selectProduct();
	}

	@Then("verify the name of product {string} and fetch the description of product")
	public void verify_the_name_of_product_and_fetch_the_description_of_product(String name) {
		gd.verifyAndFetch(name);
		ExtentUtils.pass(driver, test, "Gift Dropdown feature Executed.", log);
	}

	@After("@GiftsDropdown")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
