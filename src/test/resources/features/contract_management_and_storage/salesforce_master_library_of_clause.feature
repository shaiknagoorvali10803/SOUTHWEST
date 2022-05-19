@ContractManagement&Storage @Feature_SBTP-19 @CCC @Story_SBTPSF-452 @UxValidation @SBTPXP-517
Feature: Benefits request Submission validation

  Scenario: SF - Verify the setup for Master Library of Clauses

    Given Salesforce is accessible
    And Select App Launcher and search for "Clause Library"
    Then User should be able to see "Clause Library" Home Page

    When User selects "Clause Library" from App Launcher Search
    Then User should see the all "Clauses" on left side

    When User selects "Clause Types" Tab from Library Page
    Then User should see the all "Clause Types" on left side

    When User selects "Clause Bundles" Tab from Library Page
    Then User should see the all "Clause Bundles" on left side

