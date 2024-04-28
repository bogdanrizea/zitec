Feature: Checkout overview


  Scenario: Standard User Finishes checkout
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
    And the client clicks Finish button
    Then the Checkout Complete page is displayed
    And the shopping cart is now empty

  Scenario: Problem User Finishes checkout
    Given the client inputs PROBLEM_USER credentials
    When  clicks on the Login button
    And the client adds a product to cart
    And the client adds a product to cart
    And the client clicks the cart icon
    And the client goes to Checkout
    And the client inputs a name
    And the client inputs a last name
    And the client inputs a zip code
    And the client clicks Continue button
    And the client clicks Finish button
    Then the Checkout Complete page is displayed
    And the shopping cart is now empty

  Scenario: Error User Finishes checkout
    Given the client inputs ERROR_USER credentials
    When  clicks on the Login button
    And the client adds a product to cart
    And the client adds a product to cart
    And the client clicks the cart icon
    And the client goes to Checkout
    And the client inputs a name
    And the client inputs a last name
    And the client inputs a zip code
    And the client clicks Continue button
    And the client clicks Finish button
    Then the Checkout Complete page is displayed
    And the shopping cart is now empty

  Scenario: Visual User Finishes checkout
    Given the client inputs VISUAL_USER credentials
    When  clicks on the Login button
    And the client adds a product to cart
    And the client adds a product to cart
    And the client clicks the cart icon
    And the client goes to Checkout
    And the client inputs a name
    And the client inputs a last name
    And the client inputs a zip code
    And the client clicks Continue button
    And the client clicks Finish button
    Then the Checkout Complete page is displayed
    And the shopping cart is now empty