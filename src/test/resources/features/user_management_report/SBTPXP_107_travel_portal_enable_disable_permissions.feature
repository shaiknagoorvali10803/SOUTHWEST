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

    When User check the "<Permissions>"
    And Selects save

    When User check the "<Permissions>"
    And Selects save

    Examples:

      | Email                           | Permissions                   |
      | mark.varied_access_ctm@test.com | Delegate a Full Access Admin  |
      | mark.varied_access_ctm@test.com | Update Account Details  |
      | mark.varied_access_ctm@test.com | Designate a TMC  |
      | mark.varied_access_ctm@test.com | Update TMC Distribution Info  |
      | mark.varied_access_ctm@test.com | Access to Contracts |
      | mark.varied_access_ctm@test.com | View the Contract Compliance Dashboard |
      | mark.varied_access_ctm@test.com | Register and Sign for New Agreements, Supplemental Agreements, Promotions, etc.  |
      | mark.varied_access_ctm@test.com | View Ticket Data Report  |
      | mark.varied_access_ctm@test.com | View Historical Account Report  |
      | mark.varied_access_ctm@test.com | View Channel Report  |