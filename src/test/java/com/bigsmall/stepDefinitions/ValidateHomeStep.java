package com.bigsmall.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.HomePage;
import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateHomeStep extends BaseClass {
	HomePage hm = null;
	public WebDriver driver = null;

	@Before("@ValidateHome")
	public void init() {
		test = report.startTest("ValidateHome Test");
		log = Logger.getLogger(ValidateHomeStep.class.getName());
		driver = initialize();
		hm = new HomePage(driver, log, test);
		System.out.println("Validate Home");
	}

	@Given("open the base url for HomePage Validation")
	public void open_the_base_url_for_home_page_validation() {
		driver.navigate().to(pro.getProperty("baseURL"));
		test.log(LogStatus.PASS, "Navigated to base url");
	}

	@When("page opens start validation")
	public void page_opens_start_validation() throws InterruptedException {
		log.info("Starting validation");
		Thread.sleep(2000);
	}

	@Then("verify the title, Logo, SearchBox")
	public void verify_the_title_logo_search_box() {
		hm.validateTitle();
		hm.validateLogo();
		hm.validateSearchBox();
		ExtentUtils.pass(driver, test, "Validate Home test executed", log);

	}

	@After("@ValidateHome")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
