@Feature_SBTP-21 @Story_SBTPSF-63 @SBTPXP-128 @UxValidation @UserProvisioning @Request_Management
Feature: Benefits request Submission validation

  Scenario Outline:TP: Check the Remove User functionality for Contacts when user login as CTM or TMC Full Access
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
    Examples:

      | Email             |
      | jhon.doe@test.com |