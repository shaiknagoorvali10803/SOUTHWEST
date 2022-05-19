@Feature_SBTP-14 @Story_SBTPSF-240 @SBTPXP-90 @RequestManagement @GeneralInquiryRequest
Feature: Report on Status Match requests

  Scenario: SF - Verify whether User can see all the Cases under the Status Match Tracking report

    Given Salesforce is accessible
    And Select Navigation Menu and select "Reports"

    And The user goes to "SWA Corporate Status Match Tracking" report
    Then The User should be able to see the all cases with a type value of "SWA Corporate Status Match Tracking"
    And The User Clicks on All Time

