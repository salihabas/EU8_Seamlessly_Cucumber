@calendar
Feature: Calendar function

  User Story:
  As a user, I should be able to see Daily-Weekly-Monthly calendar view and create a new event under the Calendar module

  Acceptance Criteria:
  1- User can display daily calendar view
  2- User can display weekly calendar view
  3- User can display monthly calendar view
  4- User can create a new event under the Calendar module and see it on the related day through the Monthly Calendar view
  5- User can delete any event through the Monthly Calendar view by clicking on the event and then using “more” option

    Background: User login successfuly with valid credential
    Given user is on the login page
    When user enters "Employee32" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user clicks "Calendar" module

    @SEAMLES-2046
    Scenario:  User can display daily calendar view
    When User click on the calendar view dropdown menu
    And  User click on "day" option
    Then User should see daily calendar view

    @SEAMLES-2047
    Scenario:  User can display weekly calendar view
    When  User click on the calendar view dropdown menu
    And  User click on "week" option
    Then User should see weekly calendar view

    @SEAMLES-2048
    Scenario:  User can display monthly calendar view
    When  User click on the calendar view dropdown menu
    And  User click on "month" option
    Then User should see monthly calendar view

    @SEAMLES-2049
    Scenario: User  can create a new event  and see it on the calendar
    When  User  select Monthly view calendar
    And  User  click on New event button
    And  User  input "Alumni Meeting" as a new event in placeholder
    And  User  select beginning time and date
    And  User  select ending time and date
    And  User  click on Save  button
    Then User  should see new event on monthly calendar

    @SEAMLES-2050
    Scenario: User can delete any event through the Monthly Calendar
    When User click "any event" on the monthly calendar
    And  User click More button
    And  User click tree dot dropdown menu
    And  User click delete button
    Then User should see the event was erased