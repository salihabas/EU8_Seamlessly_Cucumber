Feature: Deck Module

  Background: Pre_condition User is on dashboard page with valid credential
    Given user is on the login page
    And user enters "Employee111" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user can logged in


  Scenario: TC001
    When User clicks on "deck module"
    And User clicks to navigation toggle top-left of the page
    And User clicks to Add board entry link
    And User enters "New Board" board name in input box
    And User clicks input confirm button
    Then User can see new board in the all boards