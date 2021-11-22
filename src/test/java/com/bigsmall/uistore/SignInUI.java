package com.bigsmall.uistore;

import org.openqa.selenium.By;

public class SignInUI {
	public static By lnkSignin = By.cssSelector("a.site-nav__link.site-nav__link--icon.signinlink");
	public static By txtEmail = By.cssSelector("input#CustomerEmail.input-full");
	public static By txtPassword = By.cssSelector("input#CustomerPassword.input-full");
	public static By btnSignIn = By.xpath("//div[@id='CustomerLoginForm']//input[@value='Sign In']");
}
