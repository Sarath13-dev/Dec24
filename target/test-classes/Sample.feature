Feature: Validate the Swagger Pet Store
Scenario: Validate the POST request 
Given User creates the request object
When User attaches the payload
And User creates the response object
Then User validates the response code and body