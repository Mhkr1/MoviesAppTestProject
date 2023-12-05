Feature: Test the header section elements and functionalities on Home Page
  As a user of the movies website
  I am able to log in to my account
  So that i can access personalised feature and watch movies

  Scenario: Test whether the Website logo is displayed
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then the website logo should be visible


  Scenario: Test the Home Route Visibility on Header Section
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then the home route should be visible

  Scenario: Test the Popular Route Visibility on Header Section
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then the popular route should be visible

  Scenario: Test the search button visibility on header section
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then the search icon should be visible


  Scenario: Test the profile image visibility on header section
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then the profile image should be visible


  Scenario: Test the navigation to popular page through elements in header section
    Given I am on the home page
    When I click popular route option on header section
    Then I should be redirected to the popular route section

  Scenario: Test the navigation to profile page through elements in header section
    Given I am on the home page
    When I click profile route option on header section
    Then I should be redirected to the profile route section


