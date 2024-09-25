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
