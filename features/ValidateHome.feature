Feature: Validate Home
	@ValidateHome
  Scenario: HomePage Validation
    Given open the base url for HomePage Validation
    When page opens start validation
    Then verify the title, Logo, SearchBox
