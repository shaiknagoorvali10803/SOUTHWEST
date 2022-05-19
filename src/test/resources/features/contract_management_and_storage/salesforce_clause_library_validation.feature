Feature: Benefits request Submission validation

  Scenario: Verify Clause library is setup for CLM admin user in Salesforce

    Given Salesforce is accessible
    And Select App Launcher and search for "Clause Library"
    Then User should be able to see "Clause Library" Home Page

    When User selects "Clause Library" from App Launcher Search
    Then User should see the all "Clauses" on left side
    Then User verify options "Clauses", "Clauses Types", "Clauses Categories", "Clauses Bundles" and "Clauses Approvers" are displayed in Library Page


