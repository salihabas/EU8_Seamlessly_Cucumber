@smoke
Feature: Calendar, Deck, Task, Update Edit Delete

  Background: User login successfuly with valid credential
    Given user is on the login page
    When user enters "Employee32" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user clicks "Calendar" module

  Scenario: User  can create a new event  and see it on the calendar
    When  User  select Monthly view calendar
    And  User  click on New event button
    And  User  input "Alumni Meeting" as a new event in placeholder
    And  User  select beginning time and date
    And  User  select ending time and date
    And  User  click on Save  button
    Then User  should see new event on monthly calendar

