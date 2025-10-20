Feature: Weather API testing

  As a user of the Weather API
  I want to retrieve weather information for a given city
  So that I can verify the API returns correct weather data

  Scenario: Lookup weather
    Given I have a latitude "37.7749" and longitude "-122.4194"
    When I request weather information from the Weather API
    Then the response status should be 200
    And the temperature should be returned