Feature: Login

  Scenario: Try to login without Username
    Given the client does not input a username
    When  clicks on the Login button
    Then an Username required error message should be displayed

  Scenario: Try to login without Password
    Given the client does not input a password
    When  clicks on the Login button
    Then a Password required error message should be displayed

  Scenario: Client logs in as standard user
    Given the client inputs STANDARD_USER credentials
    When  clicks on the Login button
    Then the Inventory Page should be loaded

  Scenario: Client logs in as standard user
    Given the client inputs LOCKED_OUT_USER credentials
    When  clicks on the Login button
    Then an User locked out error message should be displayed


