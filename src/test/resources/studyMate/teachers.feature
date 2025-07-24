@regression
Feature: Verify Teachers functionality

  Background:
    When User enters username "loginEmail", password "password", clicks login button
    And User clicks Teachers button

  @addTeacher
  Scenario: Validate add teacher functionality
    When User clicks AddTeacher button
    And User enters 'Bena', 'Bai', '123441144', 'hah@gmail.com', 'teacher' and User clicks procceed button User validates 'Instructor successfully saved'


  @deleteTeacher
  Scenario: Validate delete teacher functionality
    Then User deletes the First Teacher and validates deletion 'Instructor successfully deleted'



