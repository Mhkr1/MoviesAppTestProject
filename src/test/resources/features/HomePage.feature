Feature: Home Page
  As a user of the movies website
  I am able to log in to my account
  So that i can access personalised feature and watch movies

  Scenario: Test the heading texts of each section
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then the second heading should be 'Originals'

  Scenario: Test whether the play button is displayed or not
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then play button should be visible on the home page

  Scenario: Test whether the Movies are displayed, in the corresponding movies sections
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then movies should be visible in their corresponding sections

  Scenario: Test the Contact Us Section
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then contact us Section should be visible