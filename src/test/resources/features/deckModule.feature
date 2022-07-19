Feature: Deck Module

  Background: Pre_condition User is on dashboard page with valid credential
    Given user is on the login page
    And user enters "Employee111" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user can logged in

  @TC001
  Scenario: TC001
    When User clicks on deck module
    And User clicks to navigation toggle top-left of the page
    And User clicks to Add board entry link
    And User enters "Office" board name in input box
    And User clicks input confirm button
    Then User can see new board in the all boards

  @TC002
  Scenario: TC002
    When User clicks on deck module
    And User clicks to navigation toggle top-left of the page
    And User clicks first board from the opened menu
    And User clicks + add list button top right of the page
    And User enters "To do" list name and presses enter key


