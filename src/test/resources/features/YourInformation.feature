Feature: YOur Information error messages


  Scenario: Add your info error messages
    Given the client inputs STANDARD_USER credentials
    When  clicks on the Login button
    When the client adds a product to cart
    And the client clicks the cart icon
    And the client goes to Checkout
    Then the Your Information Page should be displayed
    When the client clicks Continue button
    Then a missing first name error message is displayed
    When the client inputs a name
    And the client clicks Continue button
    Then a missing last name error message is displayed
    When the client inputs a last name
    And the client clicks Continue button
    Then a missing zip code error message is displayed


