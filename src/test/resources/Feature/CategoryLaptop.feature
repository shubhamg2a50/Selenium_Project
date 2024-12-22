Feature: Filter products by category laptop

  Scenario: Display only Laptop in the Laptop category
    Given I launch browser and opens DemoBlaze homepage
    When User clicks on the Laptop category
    Then Only products related to Laptop are displayed
