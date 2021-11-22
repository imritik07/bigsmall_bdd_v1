Feature: Track Order
	@Track
  Scenario Outline: Track Order Automate
    Given open the base url for track order
    When click on the track order inside helpful links in footer section
    Then verify the title "<title>" of the page
    Then enter email "<email>" and order id "<id>"

    Examples: 
      | title                         | email             | id        |
      | Track your order– Bigsmall.in | john162@gmail.com | 367263839 |
