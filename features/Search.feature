Feature: Search
	@Search
  Scenario Outline: Search feature automate
    Given open the base url for searchs
    When click on the search box and give the product name "<pname>"
    Then click on search and verify title "<title>"
    Then come back

    Examples: 
      | pname                           | title                                         |
      | Heart-Key Beaded Charm Bracelet | Heart-Key Beaded Charm Bracelet - Bigsmall.in |
