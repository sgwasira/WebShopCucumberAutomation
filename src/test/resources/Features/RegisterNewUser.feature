@RegisterNewUser
Feature: Register a new system user

  Scenario: As A user I want to be able to register on the shopping website
    Given I am on the Demo Web Shop Home Page before register
    And I click on the Register Link on the main navigation
    And I verify the I am on the register page
    And I select my gender
    Then I enter my first name
    And I enter my last name
    And I enter my email account
    And I enter my registration password
    And I confirm my registration password
    And I click the register Button
    Then I must be registered and logged in
