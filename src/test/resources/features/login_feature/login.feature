Feature: Login function

  User Story:
  As a user, I should be able to login.

  Acceptance Criteria:
  1-User can login with valid credentials
  2-User can not login with any invalid credentials
    -"Wrong username or password." should be displayed for invalid credentials
    -"Please fill out this field" message should be displayed if the password or username is empty
  3-User can see the password in a form of dots by default
  4-User can see the password explicitly if needed
  5-User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
  6-User can see valid placeholders on Username and Password fields

  Background:
    Given user is on the login page

  @SEAMLES-1937 @smoke
  Scenario Outline: US001_AC1_TC1 User logins with valid credentials
    When user enters "<username>" as a username
    And user enters "<password>" as a password
    And user clicks login button
    Then user can logged in
    Examples:
      | username   | password    |
      | Employee1  | Employee123 |
      | Employee12 | Employee123 |
      | Employee3  | Employee123 |
      | Employee4  | Employee123 |

  @@SEAMLES-1938
  Scenario Outline: US001_AC2_TC1 User doesn't login with invalid username or password
    When user enters "<username>" as a username
    And user enters "<password>" as a password
    And user clicks login button
    Then user cannot logged in with invalid username
    Examples:
      | username   | password    |
      | Employeee1 | Employee123 |
      | mployee12  | Employee123 |
      | Employee3  | Employee12  |
      | Employee4  | employee123 |

  @@SEAMLES-1939
  Scenario: US001_AC2_TC2 User doesn't login with absent username and correct password
    When user enters "" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    Then user cannot logged in with absent username

  @@SEAMLES-1940
  Scenario: US001_AC2_TC3 User doesn't login with correct username and absent password
    When user enters "Employee1" as a username
    And user enters "" as a password
    And user clicks login button
    Then user cannot logged in with absent password

  @SEAMLES-1941
  Scenario: US001_AC3_TC1 User can see the password in a form of dots by default
    When user enters "Employee123" as a password
    Then User can see the password in a form of dots

  @SEAMLES-1942
  Scenario: US001_AC4_TC1 User can see the password explicitly if needed
    When user enters "Employee123" as a password
    And user clicks eye icon inside the password section
    And User can see the password explicitly
    And user clicks eye icon inside the password section
    Then User can see the password in a form of dots

  @SEAMLES-1943 @smoke
  Scenario: US001_AC5_TC1 User can see the Forgot password and Reset Password
    When User can see the Forgot password link
    And User clicks Forgot password? link
    Then User can see Reset password button

  @SEAMLES-1944
  Scenario: US001_AC6_TC1 User can see valid placeholders on Username and Password fields
    Then User can see valid placeholders on Username and Password fields