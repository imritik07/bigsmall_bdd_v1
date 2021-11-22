Feature: Gifts DropDown
	@GiftsDropdown
  Scenario Outline: Automating Gifts Dropdown and fetch the product description
    Given open this base url for Gifts dropdown link
    When hover on the Gifts and click on Gifts for girls
    Then select the product
    Then verify the name of product "<pname>" and fetch the description of product

    Examples: 
      | pname                        |
      | Girl Power Wooden Pop Socket |
