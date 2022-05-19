Feature: Account home page validation

  Scenario Outline: Verify tabs on account's home page
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    When User taps on accountSearch Dropdown and selects an account
    And The user is redirected to the Account page
    Then Account home page should be displayed with CONTRACTS,REQUESTS,FUNDS,ACCOUNT PERFORMANCE and SETTINGS tabs
    Examples:

      | Email                  |
      | avery.fulltmc@test.com |