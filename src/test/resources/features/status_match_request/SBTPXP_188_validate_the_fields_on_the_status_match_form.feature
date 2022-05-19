@Feature_SBTP-8 @Story_SBTPSF-180 @SBTPXP-188 @WaiversAndFavors @StatusMatchRequest
Feature: Verify Fields on the Status Match Page

  Scenario Outline: Validate fields in Status Match form on Southwest.com
    Given User navigates to Status Match form by launching SouthwestForm Page
    Then "firstName" form should be displayed
    When User provides alphanumeric value in Rapid Rewards Number "rrNumber" field
    And User submits the form For Southwest
#    Then User should see relevant error message
    When User provides numeric value in Rapid Rewards Number "rrNumber" field
    And User submits the form For Southwest
#    Then User should see relevant error message
    When User provides "<Invalid eMail>" in "corporateEmailAddress" field
    And User submits the form For Southwest
#    Then User should see relevant error message for the eMail field
    When User provides "<Valid eMail>" in "corporateEmailAddress" field
    And User submits the form For Southwest
#    Then Case should be created in Southwest Business CRM

    Examples:

      | Invalid eMail | Valid eMail  |
      | abc           | NA           |
      | abc@          | NA           |
      | abc@test      | NA           |
      | abc@test.     | NA           |
      | NA            | abc@test.com |

