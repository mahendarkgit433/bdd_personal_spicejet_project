Feature: Signup module

Background:

Given open browser "edge"
When launch site
Then i should see the title contains "SpiceJet"

Scenario: validate signup functionality with valid information
And click on signup button
Then signup page should be displayed
When select title
When enter first and middle name
When enter last name
When select country
When enter date of birth
When enter mobile number
When enter email
When enter password
When enter confirm password
When click on checkbox
Then click on submit button
Then close browser
#Validate with invalid information