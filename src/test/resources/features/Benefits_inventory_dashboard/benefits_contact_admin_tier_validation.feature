Feature: Benefits contact Admin validation

  Scenario Outline: Verify the Benefits contact Admin for Tier Experience
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    And The user is redirected to the Account page

    When User navigates to Requests tab
    Then User should be able to see Benefits dashboard under the Account details page
    And Contact Admin button should be available

    When User Selects on Contact Admin for "Tier Experience"
    Then Additional Inventory Request Is Displayed

    Examples:

      | Email |
      | jhon.doe@test.com   |