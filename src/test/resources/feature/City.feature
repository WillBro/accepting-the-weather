Feature: Weather Application
  As I am interested in my local weather
  I want to know the specify my city
  So that I know the weather for my city

  Background:
    Given that I have accessed the Weather Application
    And We have requested the correct application URL
    When I have entered my city
    Then I should see weather for the city <string>