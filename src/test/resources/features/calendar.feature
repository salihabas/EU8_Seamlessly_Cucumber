Feature: Calendar function

  User Story:
  As a user, I should be able to see Daily-Weekly-Monthly calendar view and create a new event under the Calendar module

  Acceptance Criteria:
  1- User can display daily calendar view
  2- User can display weekly calendar view
  3- User can display monthly calendar view
  4- User can create a new event under the Calendar module and see it on the related day through the Monthly Calendar view
  5- User can delete any event through the Monthly Calendar view by clicking on the event and then using “more” option

  Background:
    Given User is on the home page

  @calendar
  Scenario:  User can display daily calendar view
    When User click on the calendar module
    And  User click on the calendar view dropdown menu
    And  User click on "Day" option
    Then User should see daily calendar view

  @calendar
  Scenario:  User can display weekly calendar view
    When User click on the calendar module
    And  User click on the calendar view dropdown menu
    And  User click on "Week" option
    Then User should see weekly calendar view

  @calendar
  Scenario:  User can display monthly calendar view
    When User click on the calendar module
    And  User click on the calendar view dropdown menu
    And  User click on "Month" option
    Then User should see monthly calendar view
