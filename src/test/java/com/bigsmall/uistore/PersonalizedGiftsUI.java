package com.bigsmall.uistore;

import org.openqa.selenium.By;

public class PersonalizedGiftsUI {
	public static By lnkPersGifts =By.xpath("//a[@href ='/collections/personalized-gifts'][@class='site-nav__link']");
	public static By product = By.xpath("//div[contains(text(),'Personalized Metallic Gold Pendant I COD Not Available')]");
	public static By qty = By.cssSelector("input#quantity");
	public static By name = By.cssSelector("div[id ='pplr-6137510330566'] input[type='text']");
	public static By addtoCart = By.cssSelector("button[name='add']");
}
