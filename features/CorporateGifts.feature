Feature: Corporate Gifts
	@CorporateGifts
  Scenario Outline: Corporate Gifts Automate
    Given open this base "<url>" for corporate gifts
    When click on the Corporate gifts in from the nav bar
    Then input the details "<name>" "<email>" "<mobile>"
    Then click on submit

    Examples: 
      | url                     | name                     | email |mobile|
      | https://www.bigsmall.in/ | Ritik Patel | test@gmail.com |8376237256|
