@Story_SBTPSF-164 @Feature_SBTP-24 @SBTPXP-108 @Dashboard_reports @SBTPSF_Sprint_6 @User_Management_Report
Feature: User Management Report

  Scenario Outline: TP - Verify the TMC Full Access User can enable and disable the permissions under "Benefits & Request Permissions" Section
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

    When User check the "<Permissions>"
    And Selects save

    When User check the "<Permissions>"
    And Selects save

    Examples:

      | Email                           | Permissions                       |
      | mark.varied_access_ctm@test.com | View Request Management Dashboard |
      | mark.varied_access_ctm@test.com | View Benefits Dashboard           |
      | mark.varied_access_ctm@test.com | Request Status Matches            |
      | mark.varied_access_ctm@test.com | Request Tier Experiences          |
      | mark.varied_access_ctm@test.com | Request Status Upgrades           |
      | mark.varied_access_ctm@test.com | Expired Tickets Report Request    |