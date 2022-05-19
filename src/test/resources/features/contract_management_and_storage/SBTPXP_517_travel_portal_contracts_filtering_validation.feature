Feature: Benefits request Submission validation

  Scenario Outline:TP - Ensure that the CTM or TMC can view their contacts
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    And The user is redirected to the Account page

    Then User should be able to view Active Contracts
    Examples:

      | Email             |
      | jhon.doe@test.com |

