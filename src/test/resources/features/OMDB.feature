Feature: OMDB API Testing

  As a user of the OMDB API
  I want to retrieve movie details by title or IMDb ID
  So that I can verify the API returns correct and complete information

  Scenario: Retrieve movie details by title
    When I request details for the movie with title "Oppenheimer"
    Then the response status should be 200
    And the response should contain the title "Oppenheimer"
    And the response should contain the year "2023"

  Scenario: Retrieve movie details by IMDb ID
    When I request details for the movie with IMDb ID "tt15398776"
    Then the response status should be 200
    And the response should contain the title "Oppenheimer"
    And the response should contain the director "Christopher Nolan"