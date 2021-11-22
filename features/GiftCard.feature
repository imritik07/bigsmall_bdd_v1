Feature: Gift Card
	@GiftCard
  Scenario Outline: Gift Card Automate
    Given open the homepage
    When click on the Gift Card
    Then select the amount for gift card and quantity "<qty>"
    Then Add to wishlist
    Then click on close popup

    Examples: 
      | qty |
      |   2 |
