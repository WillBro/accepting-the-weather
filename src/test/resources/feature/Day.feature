Feature: Weather Application
  As the weather is changable
  I want to know how the weather changes every 3 hours
  So that I can see more accurate weather details

  Background:
    Given that I have accessed the Weather Application
    And We have requested the correct application URL
    And I have entered my city

  Scenario:
    When When I go to the Weather Application
    Given I click on a day
    Then I should see the 3 hour forecast

  Scenario:
    When I have clicked the 3 hour forecast
    Given I click on that same day
    Then I should not see the 3 hour forecast