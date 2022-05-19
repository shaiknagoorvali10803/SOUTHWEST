@BenefitsInventoryDashboard @Feature_SBTP-36 @Story_SBTPSF-211 @SBTPXP-36
Feature: Benefits request Submission Status validation

  Scenario Outline: Verify the Benefits requests submission for Tier Experience
    Given Travel portal is accessible and SetData for User "<Email>"
    When User logs in as CTM Full Access role into the Travel Portal
    Then The Travel Portal landing page is displayed
    When Account is selected from homepage
    And The user is redirected to the Account page

    When User navigates to Requests tab
    When User Validates "Status Match" Current date falls under the start date & end date of Value
    Then User should be able to see Benefits dashboard under the Account details page
    And Submit Request button should be available

    When User Selects on Submit Request for "Status Match"
    Then Application should navigate to the Request Management page
    And Request Category dropdown should be auto populated with value "Contract Benefit Requests"
    And Request Type dropdown  should be auto populated with value "Status Match"
    Examples:

      | Email             |
      | avery.fulltmc@test.com |