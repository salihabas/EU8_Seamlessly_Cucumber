Feature: Update Edit Delete Functionality
  User Story :

  As a user, I should be able to upload a file, move or delete any selected file under the Files module.

  Acceptance Criteria:

  User can upload a file
  User can create a new folder
  User can move or copy any selected item to any folder
  User can delete any selected item from its three dots menu
  User can see the total number of files and folders under the files list table

  Background: Pre_condition User is on dashboard page with valid credential
    Given user is on the login page
    And user enters "Employee10" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user can logged in

    @SEAMLES-2023
    Scenario:
      When user clicks files module
      And user clicks plus upload link
      And user clicks upload file selection
      Then file successfully uploaded

      @only
      Scenario:
        When user clicks files module
        And user clicks plus upload link
        And user clicks new folder selection
        And user enters folder name
        And user clicks rignt arrow
        Then folder successfully created




