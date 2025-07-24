@regression
Feature: Verify Students functionality

  Background:
  When User enters username "loginEmail", password "password", clicks login button
  And User clicks Students button

  @addStudent
  Scenario Outline: Validate add student functionality
    And User clicks AddStudent button
    And User clicks cancel button
    And User clicks AddStudent button
    When User enters '<firstname>', '<lastname>', '<phoneNumber>', '<email>', chooses group and '<studyFormat>'
    And User clicks final add button
    Then User validates '<message>'
    Examples:
      | firstname | lastname | phoneNumber | email           | studyFormat | message                                  |
      | Helen     | Smith    | 1111111111  | helen@gmail.com | online      | New student successfully saved           |
      | John      | Doe      | 1234567890  | johny@gmail.com | offline     | New student successfully saved           |
      | Liam      | Anderson | 1234589011  | johny@gmail.com | offline     | User with the same email already exists  |

  @editStudent
  Scenario: Validate edit student functionality
    And User checks the number of students
    And User clicks on threeDots button, clicks on Edit button, clicks on Cancel button

  @blockUnblockStudent
  Scenario: Validate block/unblock student functionalities
    Then User clicks on threeDots button for the first student, blocks a Student and validates blocking message
    Then User clicks on threeDots button for the second student, blocks a Student and validates blocking message
    Then User Unblocks the First Student and validates unblocking message
    Then User Unblocks the Second Student and validates unblocking message

  @deleteStudent
  Scenario: Validate delete student functionality
    Then User deletes the First Student and validates deletion message
    Then User deletes the Second student and validates deletion message

