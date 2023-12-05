Feature: Test the header section elements and functionalities on Home Page
  As a user of the movies website
  I am able to log in to my account
  So that i can access personalised feature and watch movies


  Scenario: Account page ui Test
    Given I am on the account page
    When all profile page opened perfectly
    Then all ui elements should be visible on profile page


  Scenario: Logout Functionality
    Given I am on the home page
    When I click on logout button
    Then I should be redirected to the login page