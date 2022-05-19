Feature: Verify whether CTM Full Access User can edit Cases

  Scenario Outline:  SF - Verify System Admin not be able to choose the Completed Status for the CRM record cases
    Given Salesforce is accessible with username "<Email>"
    When User logs in as System Admin Role into SWA Business Salesforce
    And search for Cases "00001316"
    Then User should be able to see Cases as part of search results

    When User selects Cases

    When User to edit "Status" field
    Then Verify "Status" field should be editable
    And User selects "Status" as "Completed"
    And Save the Case
    Then User should receive an error On Saving Case Page
    Examples:

      | Email |
      | automation.sysadm@test.com    |
      | automation.crliaison@test.com    |