@Feature_SBTP-14 @Story_SBTPSF-273 @SBTPXP-79 @GeneralInquiryRequest  @RequestManagement
Feature: Benefits Create request validation

 Scenario Outline: TP - Verify case layout for a newly created case.
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    And The user is redirected to the Account page

    When User navigates to Requests tab
    Then User should be able to see Start a new request
    When User selects Start a new request
    And User selects Request Category as "Contract Benefit Requests"
    And User selects Request Type as "A-List Status Match"
    Then User should be able to select Start Request
    And System should ask Submit the request by
    When User selects "<Submit the request by>"
    Then User required to fill the information to create a case
    Then Review the information is correct
    And User selects finish
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    And The user is redirected to the Account page

    When User navigates to Requests tab
    Then User Open Request on the Top

    Then Validate Information on New Created Request

   Examples:
      | Email | Submit the request by  |
      | avery.fulltmc@test.com | Submit on behalf of the Traveler |