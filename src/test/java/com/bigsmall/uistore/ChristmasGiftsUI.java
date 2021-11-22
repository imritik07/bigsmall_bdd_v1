package com.bigsmall.uistore;

import org.openqa.selenium.By;

public class ChristmasGiftsUI {
	public static By lnkChristmas = By.xpath("//a[@href ='/collections/christmas-gifts'][@class='site-nav__link']");
	public static By stagecoachProduct = By.xpath("//div[contains(text(),'Stagecoach Mechanical Model')]");
	public static By price = By.cssSelector("div#price-field");
	public static By postal= By.cssSelector("input#PostalCode");
	public static By btnCheck= By.cssSelector("button.codbutton.btn.button");
	public static By codAvailablity = By.id("PostalCodeCheckerAvailability");
}
