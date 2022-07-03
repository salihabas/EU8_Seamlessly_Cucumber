Feature: Logout function

  User Story :
  As a user, I should be able to log out.

  Acceptance Criteria:
  1-User can log out and ends up in login page
  2-User can not go to home page again by clicking step back button after successfully logged out.

  Background: Pre_condition User is on dashboard page with valid credential
    Given user is on the login page
    And user enters "Employee12" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user can logged in


  Scenario: US002_AC1_TC1 User can log out and ends up in login page
    When user clicks avatar image
    And user clicks Log out link
    Then user can log out and see log in page

  @wip
  Scenario:  US002_AC2_TC1 User can not go to dashboard page again after logout
    When user clicks avatar image
    And user clicks Log out link
    And user can log out and see log in page
    And user clicks step back button
    Then User can not go to dashboard page and stay log in page