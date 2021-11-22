Feature: Christmas Gifts
	@ChristmasGifts
  Scenario Outline: Christmas Gifts Automate
    Given open this base "<url>" for chirstmas gifts
    When click on the Christmas gifts in from the nav bar
    Then click on the "<product>"
    Then fetch the product price and check cod on this "<postal>"

    Examples: 
      | url                     | product                     | postal |
      | https://www.bigsmall.in/ | Stagecoach Mechanical Model | 462026 |
