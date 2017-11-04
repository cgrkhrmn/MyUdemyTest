@Search @smoke
Feature: Searh functionality 

Scenario: Search functionality check
	Given Udemy homepage 
	When user click search box 
	And search some item 
	Then user should be able to see expected results. 
