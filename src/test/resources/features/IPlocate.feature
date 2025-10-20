Feature: IPlocate API testing

  As a user of the IPlocate API
  I want to retrieve geolocation information for a given IP address
  So that I can verify the API returns correct location data

  Scenario: Lookup geolocation for a valid IP address
    Given I have a valid IP address "8.8.8.8"
    When I request geolocation information from the IPlocate API
    Then the response status should be 200
    And the country should be "United States"

  Scenario: Lookup geolocation for an invalid IP address
    Given I have an invalid IP address "999.999.999.999"
    When I request geolocation information from the IPlocate API
    Then the response status should be 400
    And an error message should be returned