@tag
Feature: Error validation 
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce Page
  

  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given I landed on Ecommerce Page
    When I logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      | name            | password  |
      | affu@gmail.com | Afnan@13 	|
