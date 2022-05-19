 @Feature_SBTP-22 @Story_SBTPSF-259 @SBTPXP-508 @UxValidation @UserExperience @TurnThePortalOn
 Feature: Benefits request Submission validation

  Scenario Outline:TP - Verify the View Request Management Dashboard permission for portal user
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

    When User check the "View Request Management Dashboard"
    And Selects save

    When User check the "View Request Management Dashboard"
    And Selects save

    Examples:

      | Email             |
      | jhon.doe@test.com   |