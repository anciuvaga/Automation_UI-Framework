Feature: Update Account Information

  Background:
    Given user is on HomePage
    When user clicks on 'Sign In' generic button
    And user is logged in successfully
      | EmailAddress | personal4463@gmail.com |
      | Password     | VVV123Fa              |

  @priority-3
  Scenario: Update account information

    When user clicks on 'Account' generic button
    When user clicks on 'My personal information' generic button
    And password is updated
      | CurrentPassword | NewPassword | Confirmation |
      | VVV123Fa        | VVV123Fa    | VVV123Fa     |
    And user clicks on 'Save' generic button
    Then successful update info confirmation message is displayed


