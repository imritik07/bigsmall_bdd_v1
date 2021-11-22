package com.bigsmall.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishListSteps extends BaseClass {
	public WebDriver driver = null;

	@Before("@WishList")
	public void init() {
		test = report.startTest("WishList Test");
		log = Logger.getLogger(WishListSteps.class.getName());
		driver = initialize();
		System.out.println("WishList");
	}

	@Given("open the base url for wishList")
	public void open_the_base_url_for_wish_list() {
		driver.navigate().to(pro.getProperty("baseURL"));
		test.log(LogStatus.PASS, "Navigated to base url");
	}

	@When("click on the wishlist")
	public void click_on_the_wishlist() throws InterruptedException {
		driver.findElement(By.cssSelector("div[class= 'site-nav site-nav--icons'] i.fa.fa-heart")).click();
		log.debug("Clicked on wishlist");
		Thread.sleep(2000);
	}

	@Then("verify the title {string}")
	public void verify_the_title(String title) {
		if (driver.getTitle().equals(title)) {
			log.info("Title verification done.");
			ExtentUtils.pass(driver, test, "WishList test executed", log);
			assertTrue(true);
		} else {
			ExtentUtils.fail(driver, test, "Wish List title is not verified.", log);
			assertTrue(false, "Wish List title is not verified.");
		}
	}

	@After("@WishList")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
