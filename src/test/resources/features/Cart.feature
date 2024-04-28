Feature: Cart

  Background:
    Given the client inputs STANDARD_USER credentials
    When  clicks on the Login button

  Scenario: Add items to cart
    When the client adds a product to cart
    Then the cart icon shows 1 products
    And the Add to cart button changes to Remove for 1 products
    When the client adds a product to cart
    Then the cart icon shows 2 products
    And the Add to cart button changes to Remove for 2 products
    When the client Removes 2 products
    Then the cart icon shows 0 products
    And there are no Remove buttons

  Scenario: Go to Cart and go back to shopping
    When the client adds a product to cart
    And the client clicks the cart icon
    Then the Cart page is loaded
    When the client Continues Shopping
    Then the Inventory Page should be loaded

  Scenario: On Inventory page add products and on Cart page same number or products are displayed
    When the client adds a product to cart
    And  the client adds a product to cart
    And the client clicks the cart icon
    Then the Cart page is loaded
    And there are 2 products on the Your Cart page