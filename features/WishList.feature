Feature: WishList
	@WishList
  Scenario Outline: WishList Page Validation
    Given open the base url for wishList
    When click on the wishlist
    Then verify the title "<title>" 

    Examples: 
      | title                     |
      | My Wishlist - Bigsmall.in |
