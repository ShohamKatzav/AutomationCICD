@tag
Feature: Purchase the order from Ecommmerce Website
	Background:
	Given I landed on Ecommerce Page
	
	@Regression
	Scenario Outline: Positive Test of Submitting the order
	Given Logged in with username <name> and password <password>
	When I add product <productName> from Cart
	And Checkout <productName> and submit the order
	Then "Thankyou for the order." message is displayed on ConfirmationPage
	
	Examples:
  | name             | password   | productName |
  | Shoham@gmail.com | Aa123456!  | ZARA COAT 3 |