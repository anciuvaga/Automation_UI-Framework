Feature: ShoppingCart Functionality

  Background:
    Given user is on HomePage
    And user is logged in successfully
      | EmailAddress | persona4@gmail.com |
      | Password     | VVV123Fa          |

  @priority-2
  Scenario: Add an item to shoppingCart

    When user selects a category
    And clicks on an item
    And user choose necessary attributes
    Then items are added to cart
    When an item is removed from shoppingCart
    Then correct items amount is present in the shoppingCart

  @priority-2
  Scenario: Checkout

    When an item is been added to the shoppingCart
    And user process checkout information
    And 'I confirm my order' btn is pressed
    Then successful confirmation message is displayed
    When user goes back to orders
    Then order reference is present in order history
    When user clicks on order reference
    Then correct item name is present in order details table




