Feature: Weather Application
  As a weather conscious person
  I want to know the weather for the next 5 days
  So that I know if I'll be walking on sunshine or dancing in the rain

  Background:
    Given that I have accessed the Weather Application
    And We have requested the correct application URL

  Scenario:
    When When I go to the Weather Application
    Then I should see weather for the city Glasgow
    And 5 days should be displayed