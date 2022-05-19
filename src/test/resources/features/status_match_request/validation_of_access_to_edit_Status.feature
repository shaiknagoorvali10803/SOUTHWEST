Feature: Verify whether CTM Full Access User can edit Cases

  Scenario: SF - Verify CR Liaison has access to edit and choose the Status of the Portal Request cases
    Given Salesforce is accessible
    When User logs in as System Admin Role into SWA Business Salesforce
    And search for Cases "00005072"
    Then User should be able to see Cases as part of search results

    When User selects Cases
    Then User should be able to see the Case home page

    When User to edit "Case Outcome" field
    Then Verify "Case Outcome" field should be editable
    And User selects "Status" as "Completed"
#    And User selects "Case Outcome" as "Resolved"
#    And User selects outcome reason as "Already A-list"
    And Save the Case
    When User to edit "Case Outcome" field
    Then Verify "Case Outcome" field should be editable
    And User selects "Status" as "New"
    And Save the Case