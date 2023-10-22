Feature: Add to cart

Scenario: Adding product to cart
  Given user login in saucedemo page
  When user click button add to cart
  And user click icon cart
  Then cart page displays user-selected product