Feature: Travel Portal Login Page Validation

  Scenario Outline: Travel Portal Login Page Validation
    Given Travel portal is accessible and SetData for User "<Email>"
    When Login Using Invalid Username and Password
    Then Login Error Message Is Displayed
    Examples:

      | Email             |
      | jhon.doe@test.com |

