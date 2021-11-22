package com.bigsmall.uistore;

import org.openqa.selenium.By;

public class GiftCardUI {
	public static By lnkGiftCard = By.cssSelector("a[href='https://www.bigsmall.in/products/gift-card']");
	public static By selectAmt = By.cssSelector("div[data-value='Rs. 1000'] input[type='radio']");
	public static By qty = By.cssSelector("input#quantity");
	public static By addtoWishList = By.cssSelector("button.btn.swym-button.swym-add-to-wishlist.swym-inject.swym-iconbtnlink.swym-heart.swym-loaded");
	public static By closePopup = By.cssSelector("a#swym-close-notification-button");
	
}
