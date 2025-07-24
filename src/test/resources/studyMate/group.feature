@regression
Feature: Verify Students functionality

  Background:
    When User enters username "loginEmail", password "password", clicks login button
    And User clicks Students button

  Scenario Outline: Create and delete group

    When I go to groups page
    And I create group with name "<name>", description "<description>", date "<date>", and upload file "<image>"
    And I edit the group name to "<New name>"
    And I delete group
    Then The group should be deleted

    Examples:
      | name     | description  | date      | image      | New name     |
      | Batch C1 | Group A test | 06/1/2025 | groupA.png | Batch A1 +++ |
      | Batch D1 | Group B test | 06/1/2025 | groupA.png | Batch A1 +++ |
