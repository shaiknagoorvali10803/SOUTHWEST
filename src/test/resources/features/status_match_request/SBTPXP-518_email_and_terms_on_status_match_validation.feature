@Feature_SBTP-8 @Story_SBTPSF-237 @SBTPXP-518 @WaiversAndFavors @StatusMatchRequest
Feature: Benefits request Submission Status validation

  Scenario Outline: TP - Verify email on Status Match T&Cs with instructions to complete the Status Match request
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
#    Then The Travel Portal landing page is displayed
#    When Account is selected from homepage
#    And The user is redirected to the Account page
#
#    When User navigates to Requests tab
#    Then User Open Request on the Top
#
#    Then Validate Information on New Created Request

    Examples:
      | Email | Submit the request by  |
      | mark.varied_access_ctm@test.com | Submit on behalf of the Traveler |