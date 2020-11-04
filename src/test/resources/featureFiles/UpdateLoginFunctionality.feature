Feature: Update Account Information

  Background:
    Given user is on HomePage
    And user is logged in successfully
      | EmailAddress | persona4@gmail.com |
      | Password     | VVV123Fa         |

  @priority-3
  Scenario: Update account information

    When user click on account tab
    And goes to 'My Personal Information'
    And password is updated
      | CurrentPassword | NewPassword | Confirmation |
      | VVV123Fa        | VVV123Fa    | VVV123Fa     |
    And 'Save' button is pressed
    Then successful update info confirmation message is displayed


