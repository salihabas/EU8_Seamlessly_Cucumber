Feature: Update Edit Delete Functionality
  User Story :

  As a user, I should be able to upload a file, move or delete any selected file under the Files module

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
  Scenario:Verify that User can upload a file
    When user clicks files module
    And user clicks plus upload link
    And user clicks upload file selection
    Then file successfully uploaded

  @SEAMLES-2025
  Scenario: Verify that User can create a new folder
    When user clicks files module
    And user clicks plus upload link
    And user clicks new folder selection
    And user enters MainFolderName
    And user clicks right arrow
    Then folder successfully created

  @SEAMLES-2034
  Scenario: User can move or copy any selected item to any folder
    When user clicks files module
    And user clicks plus upload link
    And user clicks new folder selection
    And user enters MainFolderName
    And user clicks right arrow
    And user clicks home button
    And user clicks plus upload link
    And user clicks new folder selection
    And user enters MovingFolderName
    And user clicks right arrow
    And user clicks second three dot icon
    And user selects moveOrCopy selection
    And user clicks little home button
    And user chooses MainFolderName target in the list
    And user clicks MoveToMainFolder button
    And user clicks Main folder
    Then user can see MovingFolder

  @SEAMLES-2042
  Scenario: User can delete any selected item from its three dots menu
    Given user already uploaded a file
    When user clicks threeDotForDeleting
    And user clicks Delete file selection
    Then verify the item is deleted

  Scenario: User can see the total number of files and folders under the files list table
    Given user already uploaded a file
    Given user already created a folder
    Then total file and folder number is seen









