Feature: Registration

  Background:
    Given user is on HomePage

  @priority-1
  Scenario: Successful Registration

    When user clicks on 'signIn' generic button from 'HomePage'
    Then user is redirected on 'AutheticationPage'
    When user enter 'username13@gmail.com' address
    And user clicks on 'createAccount' generic button from 'AuthenticationPage'
    And user fills in personal information details
      | FirstName | LastName | Password | Address      | City   | ZipCode | MobilePhone | AddressAlias |
      | John      | Dow      | VVV123Fa | 22 London St | London | 22222   | 068255255   | jonnydow     |
    And user clicks on 'register' generic button from 'AccountCreationPage'
    Then new account is created for the user

  @priority-1
  Scenario: Successful LogIn and LogOut

    When user clicks on 'signIn' generic button from 'HomePage'
    And user enters his credentials
      | EmailAddress | username13@gmail.com |
      | Password     | VVV123Fa             |
    Then user lands on 'MyAccount' page
    When user clicks on 'signOut' generic button from 'MyAccountPage'
    Then user is logged out successfully








