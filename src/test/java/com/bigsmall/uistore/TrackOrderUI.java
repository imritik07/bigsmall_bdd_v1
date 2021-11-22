package com.bigsmall.uistore;

import org.openqa.selenium.By;

public class TrackOrderUI {
	public static By trackOrder = By.cssSelector("div[class='footer_links grid-item grid__item medium-up--one-third hidden-sm hidden-xs'] a[href='/pages/track-your-order']");
	public static By email = By.cssSelector("input#ola_email");
	public static By oid = By.cssSelector("input#ola_orderNumber");
	public static By findbtn = By.cssSelector("input#ola_submitButton");
	public static By response = By.cssSelector("div#ola_orderHeaderContent");
}
