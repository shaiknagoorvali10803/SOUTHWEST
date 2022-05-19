@Feature_SBTP-21 @Story_SBTPSF-63 @SBTPXP-86 @UserProvisioning @UxValidation @Request_Management
Feature:TP Contact Validation

  Scenario Outline:TP - Ensure that the CTM or TMC can view their contacts
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    And The user is redirected to the Account page

    When User Navigate to Account Settings
    When User navigates to Contacts
    Then User should be able to see all his contacts
    Examples:

      | Email             |
      | jhon.doe@test.com |

