package com.bigsmall.uistore;

import org.openqa.selenium.By;

public class GiftsDropdownUI {
	public static By lnkGiftsDd = By.cssSelector("li[class='site-nav__item site-nav__expanded-item site-nav--has-dropdown'] a[href='/collections/unique-gifts']");
	public static By ddOptionforGirls = By.cssSelector("ul[class='site-nav__dropdown text-left'] a[href='/collections/gifts-for-women']");
	public static By productWoodenPopSkt = By.xpath("//div[contains(text(),'Girl Power Wooden Pop Socket')]");
	public static By productTitle = By.cssSelector("h1.h1.product-single__title");
	public static By price = By.cssSelector("div#price-field");
	public static By desc = By.cssSelector("div.product-single__description.rte");
}
