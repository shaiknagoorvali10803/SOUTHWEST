@Feature_SBTP-21 @Story_SBTPSF-63 @SBTPXP-88 @UxValidation @Request_Management @UserProvisioning
Feature: TP Contact Detail validation
    Scenario Outline: TP - Verify the columns of the Contacts section
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    And The user is redirected to the Account page

    When User Navigate to Account Settings
    When User navigates to Contacts
    Then User should be able to see all his contacts
    And check the columns Name, Email, Phone, Role, Dropdown for permissions
    Examples:

      | Email                  |
      | avery.fulltmc@test.com |

