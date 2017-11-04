@login @smoke @regression
Feature: Log in function 

Scenario: Log in functionality works 
	Given User is on udemy homepage 
	When User click log in button 
	When Provide a valid email and password 
	And Click log in button 
	Then User should be able to log in successfully 
	