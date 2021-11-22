package com.bigsmall.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.Search;
import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep extends BaseClass{
	Search s = null;
	public WebDriver driver = null;
	
	@Before("@Search")
	public void init() {
		test = report.startTest("Search");
		log = Logger.getLogger(SearchStep.class.getName());
		driver = initialize();
		s = new Search(driver, log, test);
		System.out.println("Search");
	}
	@Given("open the base url for searchs")
	public void open_the_base_url_for_searchs() throws InterruptedException {
		driver.navigate().to(pro.getProperty("baseURL"));
		test.log(LogStatus.PASS, "Navigated to the base Url");
		Thread.sleep(1000);
	}

	@When("click on the search box and give the product name {string}")
	public void click_on_the_search_box_and_give_the_product_name(String name) {
		s.sendProductName(name);
	}

	@Then("click on search and verify title {string}")
	public void click_on_search_and_verify_title(String title) throws InterruptedException {
// | coffee mugs                     | coffee mugs - Bigsmall.in                     |
// | mobile holder                   | mobile holder - Bigsmall.in                   |
		s.clickAndVerify(title);
	}

	@Then("come back")
	public void come_back() {
	    driver.navigate().back();
	}
	
	@After("@Search")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
