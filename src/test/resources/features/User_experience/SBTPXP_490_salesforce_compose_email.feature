@Feature_SBTP-22 @Story_SBTPSF-356 @SBTPXP-490 @UxValidation @Userexperience @TurnThePortalOn
Feature: Verify Compose button on Email Component

  Scenario Outline:  SF - Verify compose button on email component
    Given Salesforce is accessible and Setdata "<Email>"
    When User logs in as System Admin Role into SWA Business Salesforce
    And search for Cases
    Then User should be able to see Cases as part of search results

    When User selects Cases
    Then User should be able to see the Case home page
    And Select compose on the Email component
    Then Fields to compose email should be appeared
    Examples:

      | Email             |
      | jhon.doe@test.com |
