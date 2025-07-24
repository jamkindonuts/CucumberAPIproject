@regression

Feature: Verify Login functionality

  @forgotPassword
  Scenario Outline: Validate the forgot password message in both languages
    When User chooses '<language>'
    And User clicks forgot password button, enters 'loginEmail' and clicks submit button
    Then User validates the '<message>'
    Examples:
      | language | message |
      | russian  | Письмо для сброса пароля отправлено на этот адрес электронной почты |
      | english  | Password reset email sent to this email                             |

  @loginHappyPath
  Scenario: Verify happy path, valid login
    Given User enters username "loginEmail", password "password", clicks login button
    Then verify User us logged in by validating URL


