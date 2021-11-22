package com.bigsmall.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.pageObjects.SignIn;
import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInStep extends BaseClass {
	SignIn signin = null;
	public WebDriver driver = null;

	@Before("@SignIn")
	public void init() {
		test = report.startTest("SignIn Test");
		log = Logger.getLogger(SignInStep.class.getName());
		driver = initialize();
		signin = new SignIn(driver, log, test);
		System.out.println("SignIn");
	}

	@Given("open this base {string} for sign in")
	public void open_this_base_for_sign_in(String url) {
		driver.navigate().to(url);
		test.log(LogStatus.PASS, "Url opened");
	}

	@When("click on the signin from the nav bar")
	public void click_on_the_signin_from_the_nav_bar() throws InterruptedException {
		signin.clickLinkSignIn();
		test.log(LogStatus.PASS, "clicked on the sign in");
	}

	@Then("add the email {string} and password {string}")
	public void add_the_email_and_password(String email, String pwd) {
		signin.fillDetails(email, pwd);
	}

	@Then("click on signin and verify")
	public void click_on_signin_and_verify() throws InterruptedException {
		signin.clickSignIn();
	}

	@After("@SignIn")
	public void close() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
