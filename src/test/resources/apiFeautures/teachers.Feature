@regression
Feature: Teachers API functionality

  Background:
    Given User has valid authentication token

  @addTeacherAPI
  Scenario: Validate Add Teacher API
    When User sends POST request to "/teachers" with:
      | firstName | lastName | ssn       | email          | role     |
      | Benaq     | Bali     | 123423144 | hahaq@gmail.com  | teacher  |
    Then The response status should be 201
    And The response body should contain message "Instructor successfully saved"

  @deleteTeacherAPI
  Scenario: Validate Delete Teacher API
    Given User retrieves first teacher ID
    When User sends DELETE request to "/teachers/{id}"
    Then The response status should be 200
    And The response body should contain message "Instructor successfully deleted"

 @getTeacherAPI
  Feature: Validate Get Teacher API

  Scenario: Validate retrieving a teacher by email
    When User sends a GET request to retrieve all teachers
    Then User finds teacher with email "hah@gmail.com"
    And User extracts and saves the instructorId for deletion
