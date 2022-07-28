@wip

Feature: Tasks feature
  User Story :  As a user, I should be able to create a new task list or a single task
  and add any task to completed and importants tasks list.

  Acceptance Criteria:
  1. User can create a new list of tasks**
  2. User can create a new task
  3. User can add any task to the list of completed tasks by clicking on the checkbox near the task name
  4. User can add any task to the list of important tasks by clicking on the star icon on the right side of task line
  5. User can see the number of all uncompleted tasks next to the Current tab


  Background: User is Logged in and in Tasks module
    Given user is on the login page
    When user enters "Employee71" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user clicks "Tasks" module

  @SEAMLES-2036
  Scenario: US2009-TC1 Verify that user can create a new list of tasks
    Given user clicks Add List...
    And user enters tasks list name as "School"
    And user clicks checkmark
    Then new list of tasks is created as "School"

  @SEAMLES-2037
  Scenario: US2009-TC2 Verify that user can create a new task
    Given user chose "School" tasks group from the tasks list
    And user enters task name as "Homework" and clicks enter
    Then "Homework" task is created under "School" tasks group

  @SEAMLES-2038
  Scenario: US2009-TC3 Verify that user can add any task to the list of completed tasks by clicking on the checkbox near the task name
    Given Tasks are created under "School" tasks group
      | Homework   |
      | Assignment |
      | Recording  |
      | Flipgrid   |
    And user clicks checkbox near any completed task name
      | Recording |
    Then chosen task is added to the list of completed tasks

  @SEAMLES-2039
  Scenario: US2009-TC4 Verify that user can add any task to the list of important tasks
  by clicking on the star icon on the right side of task line
    Given user has uncompleted tasks remaining
    And user clicks on the star icon on the right side of task line
      | Flipgrid |
    Then the task is added to list of important tasks
      | Flipgrid |

  @SEAMLES-2040
  Scenario: AC5 user can see the number of all uncompleted tasks next to the Current tab
    Given user has uncompleted tasks remaining
    Then user can see the number of all uncompleted tasks









