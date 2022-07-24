@DeckModule
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
    And User enters any board name in input box
    And User clicks input confirm button
    Then User can see new board in the all boards

  @TC002
  Scenario: TC002
    When User clicks on deck module
    And User clicks to navigation toggle top-left of the page
    And User clicks created board from the opened menu
    And User clicks + add list button top right of the page
    And User enters any list name and presses enter key
    Then User can see newly created list appears under the related board;

  @TC003
  Scenario: TC003
    When User clicks on deck module
    And User clicks to navigation toggle top-left of the page
    And User clicks created board from the opened menu
    And User clicks + add card button of any created list
    And User enters new card name and presses enter
    Then User can see new card appears on the related list

  @TC004
  Scenario: TC004
    When User clicks on deck module
    And User clicks to navigation toggle top-left of the page
    And User clicks created board from the opened menu
    And User clicks any three dots button on any created card
    And User clicks the assign to me option from opened menu
    Then User profile icon should be displayed on card

    @TC005
    Scenario: TC005
      When User clicks on deck module
      And User clicks to navigation toggle top-left of the page
      And User clicks created board from the opened menu
      And User clicks any three dots button on any created card
      And User clicks move card
      And User selects board and list and clicks move card button
      And User clicks Board2 board
      Then The card should be displayed under the selected list








