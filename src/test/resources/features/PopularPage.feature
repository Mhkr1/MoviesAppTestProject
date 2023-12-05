Feature: Popular Page
  As a user of the movies website
  I am able to log in to my account
  So that i can access personalised feature and watch movies

  Scenario: popular page movies are displayed or not
    Given I am on the home page
    When I click on the popular route option
    Then the popular movies should be visible on popular page