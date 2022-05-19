@Feature_SBTP-9 @Story_SBTPSF-240 @SBTPXP-92 @StatusMatchRequest @CustomerRequestReport
Feature: Report on Status Match requests

  Scenario: SF - Verify whether User can see all the Cases under the Status Match Tracking report

    Given Salesforce is accessible
    And Select Navigation Menu and select "Reports"

    And Select Different Category from Left Nav "All Folders"
    And The user goes to "Loyalty Processing" folder in "All Folders" Page
    And The user goes to "SWA Corporate Status Match Tracking" folder
    And User should see Report with columns "Traveler's Name", "Case Owner: Full Name", "Rapid Rewards Number","Date/Time Opened"

