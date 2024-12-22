Feature: Add product to cart

  Scenario: Verify product is added to cart
    When User selects a product and adds it to the cart
    Then The product "Iphone 6 32gb" priced at 790 is displayed in the cart
