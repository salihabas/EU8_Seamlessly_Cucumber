@smoke
Feature: Calendar, Deck, Task, Update Edit Delete

  Background: User login successfully with valid credential
    Given User is on the home page

  Scenario: User  can create a new event  and see it on the calendar
    When User click on the calendar module
    And  User  select Monthly view calendar
    And  User  click on "New event" button
    And  User  input new event in "Event title" placeholder
    And  User  select beginning time and date
    And  User  select ending time and date
    And  User  click on Save  button
    Then User  should see new event on monthly calendar

  Scenario: TC_001 - Verify that user can create a new board - US013 [UTB] S-4
    When User clicks on deck module
    And User clicks to navigation toggle top-left of the page
    And User clicks to Add board entry link
    And User enters any board name in input box
    And User clicks input confirm button
    Then User can see new board in the all boards

  Scenario: US2009-TC1 Verify that user can create a new list of tasks
    Given user clicks Add List...
    And user enters tasks list name as "School"
    And user clicks checkmark
    Then new list of tasks is created as "School"

  Scenario:Verify that User can upload a file
    When user clicks files module
    And user clicks plus upload link
    And user clicks upload file selection
    Then file successfully uploaded