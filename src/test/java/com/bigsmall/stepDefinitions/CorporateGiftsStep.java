package com.bigsmall.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.CorporateGifts;
import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExtentUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CorporateGiftsStep extends BaseClass {
	CorporateGifts cg = null;
	public WebDriver driver = null;
	
	@Before("@CorporateGifts")
	public void init() {
		test = report.startTest("Corporate Gifts");
		log = Logger.getLogger(CorporateGiftsStep.class.getName());
		driver = initialize();
		cg= new CorporateGifts(driver, log, test);
		System.out.println("Corporate Gifts");
	}
	@Given("open this base {string} for corporate gifts")
	public void open_this_base_for_corporate_gifts(String url) throws InterruptedException {
		driver.navigate().to(url);
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equals(url)) {
			ExtentUtils.pass(driver, test, "Navigated to the Base Url.", log);
			assertTrue(true);
		}
		else {
			ExtentUtils.fail(driver, test, "Couldn't navigated to the correct url.", log);
			assertTrue(false, "Couldn't navigated to the correct url.");
		}
	}

	@When("click on the Corporate gifts in from the nav bar")
	public void click_on_the_corporate_gifts_in_from_the_nav_bar() {
		cg.cilckCorporate();
	}

	@Then("input the details {string} {string} {string}")
	public void input_the_details(String name, String email, String mobile) throws InterruptedException {
		cg.fillDetails(name, email, mobile);
	}

	@Then("click on submit")
	public void click_on_submit() throws InterruptedException {
	    cg.submit();
	    ExtentUtils.pass(driver, test, "Corporate Gifts Feature Executed", log);
	}
	@After("@CorporateGifts")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
