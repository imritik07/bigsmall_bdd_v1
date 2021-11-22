Feature: SignIn 
	@SignIn
  Scenario Outline: Sign in Automate
    Given open this base "<url>" for sign in
    When click on the signin from the nav bar
    Then add the email "<email>" and password "<pwd>"
    Then click on signin and verify

    Examples: 
      | url                     | email                   | pwd   |
      | https://www.bigsmall.in | ritikpatel586@gmail.com | admin |
