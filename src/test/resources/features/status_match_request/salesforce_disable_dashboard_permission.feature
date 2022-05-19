Feature: Benefits request Submission validation

  Scenario Outline: SF/TP - Verify benefit dashboard in travel portal when user disable permission "View the Benefits Dashboard" in salesforce

    Given Salesforce is accessible with main username "<Email>"
    And Select App Launcher and search for "Contacts"
    Then User should be able to see "Contacts" Home Page

    When User selects "Contacts" from App Launcher Search
    Then The user search for "<contactName>" contact
    And User navigate Edit Permission for contact
    And User "disable" permission for "Benefit Dashboard" for Contact
    And User saves the permission setting
#
#    Given Travel portal is accessible and SetData for User "<Email>"
#    When User logs in as CTM Full Access role into the Travel Portal
#    Then The Travel Portal landing page is displayed
#    When Account is selected from homepage
#    And The user is redirected to the Account page
#    When User navigates to Requests tab
##    Then User should not be able to see Benefit Dashboard in Travel Portal
#
#    Given SWABiz Salesforce is accessible
#    And Select App Launcher and search for "Contacts"
#    Then User should be able to see "Contacts" Home Page
#
#    When User selects "Contacts" from App Launcher Search
#    Then The user search for "<contactName>" contact
##    And User navigate Edit Permission for contact
##    And User "enable" permission for Benefit Dashboard
##    And User saves the permission setting

    Examples:

      | contactName | Email                  |
      | avery       | avery.fulltmc@test.com |


