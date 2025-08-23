@tag
Feature: Error Validations
	
	@ErrorValidations
	Scenario Outline: Negative Test of Submitting the order
	Given I landed on Ecommerce Page
	When  Logged in with username <name> and password <password>
	Then "Incorrect email or password." message is displayed
	
	Examples:
  | name             | password		|
  | Shoham@gmail.com | Aa12345  	| 