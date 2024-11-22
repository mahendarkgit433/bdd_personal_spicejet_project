Feature: Login feature

  Background: 
    Given open browser "chrome"
    When launch site
    Then i should see the title contains "SpiceJet"

  Scenario: Validate Login Scenario with valid credentials
    And click on login button
    When enter either mobile number or email id as "mahendark433@gmail.com"
    When enter login "123@456fre"
    Then click on submit login button
    Then login page should be displayed
    Then close browser
#Validate Login Scenario with invalid credentials
