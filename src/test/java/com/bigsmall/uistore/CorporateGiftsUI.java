package com.bigsmall.uistore;

import org.openqa.selenium.By;

public class CorporateGiftsUI {
	public static By lnkCorporateGifts = By.xpath("//a[@href ='/collections/corporate-gifts'][@class='site-nav__link']");
	public static By name = By.id("contactFormName");
	public static By email = By.id("contactFormEmail");
	public static By mobile = By.id("contactFormPhone");
	public static By btnSubmit = By.cssSelector("input.btn");
}
