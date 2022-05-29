@smokeTest

Feature: Customer Can Login

  Scenario: customer adds two products and complete an order
    Given user navigate to homepage
    And User Login
    Then User add products
    And User complete Order