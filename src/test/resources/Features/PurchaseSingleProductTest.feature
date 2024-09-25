@SingleOrder
Feature: Full Single Order Purchase

  Scenario: As A user I want to make a purchase of one product from the online shop
    Given I am on the Demo Web Shop Home Page
    And I click on the Log In Link on the main navigation
    Then I enter my user name
    And I enter my password
    And I check the Remember me box
    And I click the Log in Button
    Then I must be logged in
    And I select the Computer Product
    And I click on the Notebooks Link
    Then Select the fourteen inch Laptop
    And I add the number of laptop I want to buy
    And Click the add to cart button
    Then I click on the Shopping cart link



