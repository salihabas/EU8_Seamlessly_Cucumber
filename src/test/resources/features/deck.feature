@SEAMLES-2021
Feature: Deck Module

	User Story:
	As a user, I should be able to manage my works by creating a new board/list/card and modifying them under Deck Module.

	Background:
		#@SEAMLES-2022
		    Given user is on the login page
		    And user enters "Employee111" as a username
		    And user enters "Employee123" as a password
		    And user clicks login button
		    And user can logged in
		

	@SEAMLES-2016
	Scenario: TC_001 - Verify that user can create a new board - US013 [UTB] S-4
		When User clicks on deck module
		    And User clicks to navigation toggle top-left of the page
		    And User clicks to Add board entry link
		    And User enters any board name in input box
		    And User clicks input confirm button
		    Then User can see new board in the all boards	


	@SEAMLES-2017
	Scenario: TC_002 - Verify that user can create a new list and new card US-013 [UTB] S-4
		When User clicks on deck module
		    And User clicks to navigation toggle top-left of the page
		    And User clicks created board from the opened menu
		    And User clicks + add list button top right of the page
		    And User enters any list name and presses enter key
		    Then User can see newly created list appears under the related board	


	@SEAMLES-2018
	Scenario: TC_003 - Verify that user can add a new card on any list on the current board US-013[UTB] S-4
		When User clicks on deck module
		    And User clicks to navigation toggle top-left of the page
		    And User clicks created board from the opened menu
		    And User clicks + add card button of any created list
		    And User enters new card name and presses enter
		    Then User can see new card appears on the related list	


	@SEAMLES-2019
	Scenario: TC_004 - Verify that user can assign any card to himself  US-013 [UTB] S-4
		When User clicks on deck module
		    And User clicks to navigation toggle top-left of the page
		    And User clicks created board from the opened menu
		    And User clicks any three dots button on any created card
		    And User clicks the assign to me option from opened menu
		    Then User profile icon should be displayed on card	


	@SEAMLES-2020
	Scenario: TC_005 - Verify that user can move card on the current board to any other list of other board US-013 [UTB] S-4
		When User clicks on deck module
		    And User clicks to navigation toggle top-left of the page
		    And User clicks created board from the opened menu
		    And User clicks any three dots button on any created card
		    And User clicks move card
		    And User selects board and list and clicks move card button
		    And User clicks board that moved card recently
		    Then The card should be displayed under the selected list