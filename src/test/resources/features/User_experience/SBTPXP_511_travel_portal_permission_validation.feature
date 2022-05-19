@Feature_SBTP-22 @Story_SBTPSF-259 @SBTPXP-511 @UserExperience @TurnThePortalOn @UxValidation
Feature: Permission validation for Travel Portal

  Scenario Outline:TP - Verify the permissions for portal user
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    And The user is redirected to the Account page

    When User Navigate to Account Settings
    When User navigates to Contacts
    Then User should be able to see all his contacts

    When User clicks on Dropdown available at the end of each contact
    Then User should see the options Edit Permissions, Remove User

    When User selects the Edit permission
    Then User should navigate to Permission access page

    When User check the "<Permission>"
    And Selects save

    When User check the "<Permission>"
    And Selects save

    Examples:

      | Email             | Permission                     |
      | jhon.doe@test.com | View Historical Account Report |
      | jhon.doe@test.com | View Benefits Dashboard        |
      | jhon.doe@test.com | Request Status Matches         |
      | jhon.doe@test.com | Request Tier Experiences       |
      | jhon.doe@test.com | Request Status Upgrades        |
      | jhon.doe@test.com | Expired Tickets Report Request |
      | jhon.doe@test.com | View Transferability Report    |
      | jhon.doe@test.com | View Rapid Reward Business Points|
      | jhon.doe@test.com | View Unused Tickets Report    |
      | jhon.doe@test.com | View Unused Flight Credit Report|