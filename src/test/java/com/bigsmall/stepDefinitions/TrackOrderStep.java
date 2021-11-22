package com.bigsmall.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.TrackOrder;
import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackOrderStep extends BaseClass{
	TrackOrder to= null;
	public WebDriver driver = null;
	
	@Before("@Track")
	public void init() {
		test = report.startTest("Track Order Test");
		log = Logger.getLogger(TrackOrderStep.class.getName());
		driver = initialize();
		to = new TrackOrder(driver, log, test);
		System.out.println("Track Order");
	}
	
	@Given("open the base url for track order")
	public void open_the_base_url_for_track_order() {
		driver.get(pro.getProperty("baseURL"));
		test.log(LogStatus.PASS, "Navigated to base url");
	}

	@When("click on the track order inside helpful links in footer section")
	public void click_on_the_track_order_inside_helpful_links_in_footer_section() throws InterruptedException {
	    to.openTrackPage();
	    test.log(LogStatus.PASS, "Opened track order page");
	}

	@Then("verify the title {string} of the page")
	public void verify_the_title_of_the_page(String title) throws InterruptedException {
	   to.verifyPage(title);
	}

	@Then("enter email {string} and order id {string}")
	public void enter_email_and_order_id(String email, String oid) throws InterruptedException {
		to.fillDetailsAndGetResponce(email, oid);
		ExtentUtils.pass(driver, test, "Track Order test executed", log);
	}
	@After("@Track")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
