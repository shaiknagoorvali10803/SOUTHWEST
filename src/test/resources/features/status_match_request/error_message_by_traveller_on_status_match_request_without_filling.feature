Feature: Benefits request Submission Status validation

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
    When User fills the information First Name as "<TestFirstName>" LastName as "<TestLastName>" email as "<TestEmail>"
    Then User validate the error message for mandatory fields in request page "<TestFirstName>", "<TestLastName>"

    Examples:
      | Email             | Submit the request by            | TestFirstName | TestLastName | TestEmail                             |
      | avery.fulltmc@test.com | Submit on behalf of the traveler |          |testln    |swa.teststatusmatchid@Test.com  |
      | avery.fulltmc@test.com | Submit on behalf of the traveler | testfn   |          |swa.teststatusmatchid@Test.com  |
      | avery.fulltmc@test.com | Submit on behalf of the traveler | testfn   |testln    |                                   |
      | avery.fulltmc@test.com | Submit on behalf of the traveler |          |testln    |swa.teststatusmatchid@Test.com  |
      | avery.fulltmc@test.com | Submit on behalf of the traveler | testfn   |          |swa.teststatusmatchid@Test.com  |
      | avery.fulltmc@test.com | Submit on behalf of the traveler | testfn   |testln    |                                   |