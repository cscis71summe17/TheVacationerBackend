Feature: Should be possible to receive restaurants per country/city
  Scenario: Ensure Cucumber is working properly.
    Given I have a scenario
    When I run the tests
    Then all the tests go green

  Scenario: Determine that five local restaurants are available
    Given A specific location
    When I chose to locate available restaurants
    Then They're are 5 available restaurants