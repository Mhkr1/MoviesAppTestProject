Feature: In the Home Page click on any Movie and test all the UI elements present in it
  As a user of the movies website
  I am able to log in to my account
  So that i can access personalised feature and watch movies

  Scenario: In the Popular Page click on any Movie and test all the UI elements present in it
    Given I am on the popular page
    When I click on one movie on popular page
    Then the movie title should be visible
    And the movie watch time should be visible
    And the movie sensor rating should be visible
    And the movie release year should be visble
    And the movie overview should be visible
    And the movie play button should be visible
    And the movie genres should be visible
    And the movie available audios should be visible
    And the movie rating count should be visible
    And the movie average rating should be visible
    And the movie budget should be visible
    And the movie release date should be visible
    And the more like movies section should be visible
