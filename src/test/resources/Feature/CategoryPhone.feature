Feature: Filter products by category phone

  Scenario: Display only Phones in the Phones category
    Given User launches browser and opens DemoBlaze homepage
    When User clicks on the Phones category
    Then Only products related to Phones are displayed
