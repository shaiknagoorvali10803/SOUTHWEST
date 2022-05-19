@Feature_SBTP-21 @Story_SBTPSF-4 @SBTPXP-172 @UxValidation @DashboardsAndReports @User_Provisioning
Feature: TP: Verify whether CTM Full Access User can able to Designate Non Existing TMC

  Scenario Outline: Validation of CTM Full Access User can able to designate Non Existing TMC
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    Then The user is redirected to the Account page

    When User Navigate to Account Settings
    Then User should see the Designate TMC

    When User clicks on Designate TMC
    And User Searches with Invalid ARC Number
    Then No Account Found For ARC Is Displayed

    When User Clicks Next Without Entering Value
    Then Error Message For ARC Is Displayed on Mandatory Field

    When User Enters Information With Company Name To Add To Your Account
    Then Application should display Request Details

    And User Goes To Request DashBoard
    Then User Validate Request Is Available

    When User Clicks On New Request Created
    Then Validate Information on Case Detail Page

    Given Salesforce is accessible
    When User logs in as System Admin Role into SWA Business Salesforce
    And search for Cases
    Then User should be able to see Cases as part of search results

    When User selects Cases
    Then User should be able to see the Case home page
    And Origin as Travel Portal
    And Contact as CTM filling the request
    And Account as Corporate Account selected on Portal
    And Type as TMC Designation
    And Description information should be same as the Travel Portal "nonvalid"

    When User should be able to see Close Opened Case
    Examples:

      | Email             |
      | jhon.doe@test.com |