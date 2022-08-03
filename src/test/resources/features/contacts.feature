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


    @SEAMLES-2027 
    Scenario Outline: User creates a new contact with entering Company and Title
      When user clicks +New contact button
      And user see New contact form and exclamation mark
      And user enters "<name>" as name
      And user enters "<companyName>" as company name
      And user enters "<title>"
      Then user sees "<name>" in the middle column


      Examples:
        | name  | companyName | title |
        | Tom   | cydeo       | ceo   |
        | Mike  | Amazon      | sdet  |
        | Oscar | Uber        | qa    |

  @SEAMLES-2028
  Scenario: User creates a new contact with only name
      When user clicks +New contact button
      And user see New contact form and exclamation mark
      And user enters "Henry" as name
      Then user sees "Henry" in the middle column


  @SEAMLES-2029
  Scenario: User cannot create a new contact without entering info
    When user clicks +New contact button
    And user see New contact form and exclamation mark
    And user hovers on exclamation mark and sees the message
    And user refresh the page
    Then user doesn't see New contact in the middle column

  @SEAMLES-2030
  Scenario: User can see all the contacts inside the middle column and total number near the contact categories
    When user can see all contacts in the middle column
    Then user can see total number of contact near the contact categories

  @SEAMLES-2031
  Scenario: User can delete any selected contact
    When user clicks any contact middle column
    And user clicks on image icon
    And user clicks choose from files option
    And user selects a image
    Then user can see selected avatar image for the contact

  @SEAMLES-2032
  Scenario: User can delete any selected contact
    When user clicks any contact middle column
    And user clicks on three-dot icon
    And user clicks delete option
    Then user can delete selected contact




