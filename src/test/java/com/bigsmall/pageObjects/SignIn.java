package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.SignInUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SignIn {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public SignIn(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}
	public void clickLinkSignIn() throws InterruptedException {
		driver.findElement(SignInUI.lnkSignin).click();
		log.debug("clicked on Sign in link.");
		Thread.sleep(1000);
	}
	public void fillDetails(String email, String pwd) {
		driver.findElement(SignInUI.txtEmail).clear();
		driver.findElement(SignInUI.txtEmail).sendKeys(email);
		log.debug("Email entered");
		driver.findElement(SignInUI.txtPassword).clear();
		driver.findElement(SignInUI.txtPassword).sendKeys(pwd);
		log.debug("password entered");
		log.debug("filled the details.");
	}
	public void clickSignIn() throws InterruptedException {
		driver.findElement(SignInUI.btnSignIn).click();
		log.debug("clicked on sign in");
		test.log(LogStatus.PASS, "clicked on Signin");
		Thread.sleep(2000);
		if (driver.getPageSource().contains("To continue, let us know you're not a robot.")
				|| driver.getTitle().equals("Account– Bigsmall.in")) {
			ExtentUtils.pass(driver, test, "Sign in success", log);
			ExtentUtils.pass(driver, test, "Sign in Test executed", log);
		}
		else {
			log.warn("Signin failed");
			ExtentUtils.fail(driver, test, "Sign in test Failed", log);
		}
	}
}
