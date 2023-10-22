Feature: Login

Scenario: Login as valid user
  Given user is on saucedemo page
  When user input valid username and password
  And user click button Login
  Then home page should be displayed

Scenario: Login as invalid user
  Given user is on saucedemo page
  When user input invalid username and password
  And user click button Login
  Then error message should be displayed