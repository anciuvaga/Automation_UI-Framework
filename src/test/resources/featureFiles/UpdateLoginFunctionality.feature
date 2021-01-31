Feature: Update Account Information

  Background:
    Given user is on HomePage
    When user clicks on 'signIn' generic button from 'HomePage'
    And user is logged in successfully
      | EmailAddress | username13@gmail.com   |
      | Password     | VVV123Fa               |

  @priority-3
  Scenario: Update account information

    When user clicks on 'account' generic button from 'MyAccountPage'
    When user clicks on 'myPersonalInformation' generic button from 'MyAccountPage'
    And password is updated
      | CurrentPassword | NewPassword | Confirmation |
      | VVV123Fa        | VVV123Fa    | VVV123Fa     |
    And user clicks on 'save' generic button from 'MyAccountPage'
    Then successful update info confirmation message is displayed


