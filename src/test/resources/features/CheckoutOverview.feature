Feature: Checkout overview


  Scenario: Checkout overview checks
    Given the client inputs STANDARD_USER credentials
    When  clicks on the Login button
    And the client adds a product to cart
    And the client adds a product to cart
    And the client clicks the cart icon
    And the client goes to Checkout
    And the client inputs a name
    And the client inputs a last name
    And the client inputs a zip code
    And the client clicks Continue button
    Then the checkout overview page is loaded
    And there are 2 products on the Overview page
    And the Item total is the sum of the products prices
    And the Total is the sum of Item Total plus Tax