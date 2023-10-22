Feature: Sort product

  Scenario: sorting price low to high
    Given user login in saucedemo page
    When user click Name (A to Z) feature
    And user choose low to high price
    Then product will be sort low to high based on price