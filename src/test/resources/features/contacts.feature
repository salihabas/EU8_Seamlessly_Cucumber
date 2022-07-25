Feature: Contacts function

  User Story :
  As a user, I should be able to create a new contact and edit/delete any contact under Contacts module

  Acceptance Criteria:
  1-User can create a new contact
  2-User can see all the contacts as a list inside the middle column and total number of the contacts near the “All Contacts” tab
  3-User can change the profile picture of any contact with a previously uploaded picture by using “Choose from files” option
  4-User can delete any selected contact

  Background: Pre_condition User is on dashboard page with valid credential
    Given user is on the login page
    And user enters "Employee1" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user can logged in
    And user clicks contacts link and user on the contacts page

    @wip
    Scenario Outline: User creates a new contact with entering Company and Title
      When user clicks +New contact button
      And user see New contact form and exclamation mark
      And user enters "<companyName>" and sees changed company name
      And user enters "<title>"
      Then user sees "<companyName>" in the middle column


      Examples:
        | companyName | title |
        | cydeo       | ceo   |


