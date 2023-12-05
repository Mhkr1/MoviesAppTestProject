Feature: Login Functionality
  As a user of the movies page
  I am able to log in to my account
  So that i can access personalised feature and watch movies

  Scenario: Login Page UI elements

    Given I am on the login page
    When The website is opened perfectly
    Then the app logo image should be displayed
    And the heading text should be "Login"
    And the username label text should be "USERNAME"
    And the password label text should be "PASSWORD"
    And the login button should be displayed

  Scenario: Successful Login

    Given I am on the login page
    When I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    Then I should be redirected to the home page


  Scenario: Login with empty input fields
    Given I am on the login page
    When I click the login button
    Then an error message '*Username or password is invalid' should be visible


  Scenario: Login with empty username
    Given I am on the login page
    When I enter valid password as 'rahul@2021'
    And I click the login button
    Then an error message '*Username or password is invalid' should be visible


  Scenario: Login with empty password
    Given I am on the login page
    When I enter valid username as 'rahul'
    And I click the login button
    Then an error message '*Username or password is invalid' should be visible


    Scenario: Login with Invalid Credentials
      Given I am on the login page
      When I enter valid username as 'rahul'
      And I enter invalid password as 'rahul2021'
      And I click the login button
      Then an error message '*username and password didn't match' should be visible


