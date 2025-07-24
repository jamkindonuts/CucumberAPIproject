@regression
Feature: Verify Courses functionality

  Background:
    Given User enters username "loginEmail", password "password", clicks login button
    And User clicks Courses button

  @addCourse
  Scenario: Validate add course functionality
    And User clicks Create Course button
    And User clicks cancel creation button
    And User clicks Create Course button
    When User enters 'Cucumber', '12.06.2025', 'Cucumber' and uploads a picture
    Then User clicks final create button




