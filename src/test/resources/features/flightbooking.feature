Feature: Flight booking

  Background: 
   Given open browser "chrome"
    When launch site
    Then i should see the title contains "SpiceJet"

  Scenario Outline: Validate flight booking with different details for single trip
  Given I am on the SpiceJet flight booking page
    When I select Leaving From as "<From>" and verify Going To does not include "<From>"
    And I select Going To as "<To>"
    And I select Departure Date as "<DepDate>"
    And I select "<Category>" as the passenger type
    And I select "<Currency>" as the preferred currency
    And I enter Adults as "<Adults>" and Children as "<Children>"
    Then I should see flight options matching the criteria
    And I verify the displayed flights meet the booking details

    Examples: 
      | From      | To        | DepDate    | Category         | Currency | Adults | Children |
      | Hyderabad | Bangalore | 2025-11-24 | Family & Friends | INR      |      2 |        1 |
      | Mumbai    | Delhi     | 2025-12-10 | Senior Citizen   | USD      |      1 |        0 |
      | Chennai   | Kolkata   | 2025-11-30 | Student          | GBP      |      1 |        1 |
      | Pune      | Ahmedabad | 2025-12-05 | Armed Forces     | EUR      |      3 |        2 |

  Scenario Outline: Validate flight booking with different details for round trip
    Given I am on the SpiceJet flight booking page
    When I select Leaving From as "<From>" and verify Going To does not include "<From>"
    And I select Going To as "<To>"
    And I select Departure Date as "<DepDate>" and  Return date as "<ReturnDate>"
    And I select "<Category>" as the passenger type
    And I select "<Currency>" as the preferred currency
    And I enter Adults as "<Adults>" and Children as "<Children>"
    Then I should see flight options matching the criteria
    And I verify the displayed flights meet the booking details

    Examples: 
      | From      | To        | DepDate    | ReturnDate | Category         | Currency | Adults | Children |
      | Hyderabad | Bangalore | 2025-11-24 | 2025-11-27 | Family & Friends | INR      |      2 |        1 |
      | Mumbai    | Delhi     | 2025-12-10 | 2025-12-14 | Senior Citizen   | USD      |      1 |        0 |
      | Chennai   | Kolkata   | 2025-11-30 | 2025-12-03 | Student          | GBP      |      1 |        1 |
      | Pune      | Ahmedabad | 2025-12-05 | 2025-12-08 | Armed Forces     | EUR      |      3 |        2 |
