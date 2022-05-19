Feature: Search by company id

  Scenario: Searching for a traveller
    Given Sergey is on the SwaBiz home page
    When he searches for companyId "99895051"
    When User Click on Continue
    Then Verify User is on HomePage