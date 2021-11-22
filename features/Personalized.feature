Feature: Personalized Gifts
	@Personalized
  Scenario Outline: Personalized Gifts Automate
    Given open this base "<url>" for personlized gifts
    When click on the personlized gifts from the nav bar
    Then clicked on the "<product>"
    Then enter "<name>" and "<qty>"
    Then click on add to cart

    Examples: 
      | url                     | product                                                | name  | qty |
      | https://www.bigsmall.in/ | Personalized Metallic Gold Pendant I COD Not Available | Ritik |   2 |
