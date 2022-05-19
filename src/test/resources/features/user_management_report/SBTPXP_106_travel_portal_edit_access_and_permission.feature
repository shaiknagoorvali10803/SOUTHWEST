@Story_SBTPSF-164 @Feature_SBTP-24 @SBTPXP-106 @User_Management_Report @Dashboard_reports @SBTPSF_Sprint_6
Feature: Benefits request Submission validation

  Scenario Outline:TP - Verify whether Full Access TMC can see the Edit Access & Permission page
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

    Examples:

      | Email             |
      | mark.varied_access_ctm@test.com |