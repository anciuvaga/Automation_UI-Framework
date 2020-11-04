Feature: Registration

  Background:
    Given user is on HomePage

  @priority-1
  Scenario: Successful Registration

    When user clicks on 'Sign in' button
    Then user is redirected on 'AutheticationPage'
    When user enter 'persona4@gmail.com' address
    And user clicks on 'Create an account' button
    And user fills in personal information details
      | FirstName | LastName | Password | Address      | City   | ZipCode | MobilePhone | AddressAlias |
      | John      | Dow      | VVV123Fa | 22 London St | London | 22222   | 068255255   | jonnydow     |
    And user clicks on 'Register' button
    Then new account is created for the user

  @priority-2
  Scenario: Successful LogIn and LogOut

    When user clicks on 'Sign in' button
    And user enters his credentials
      | EmailAddress | persona4@gmail.com |
      | Password     | VVV123Fa          |
    Then user lands on 'MyAccount' page
    When user clicks on 'Sign Out' button
    Then user is logged out successfully








