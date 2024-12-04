Feature: Login to SafeTrust

  @SuccessfulLogin
  Scenario Outline: Successful login with valid credentials
    Given user on the login page
    When user enter correct Credential "<email>" and "<password>"
    And click the login button
    Then user should be redirected to my account dashboard
    Examples:
      |              email           |        password          |
      |  mbiz.vincent@gmail.com      |      Dothevu270783!      |

  @LoginWithIncorrectCredentials
  Scenario Outline: Unsuccessful login with incorrect credentials
    Given user on the login page
    When user enter incorrect "<email>" and "<password>"
    And click the login button
    Then user should see an error message "S0001629E: The account could not be found or the password did not match. Please try again."
    And stay on the login page
    Examples:
      |              email           |        password         |
      |  mbiz.vincent22@gmail.com      |      Dothevu270783      |
      |  mbiz.vincent11@gmail.com     |      Dothevu270783!     |

  #edge cases and security check
  @LoginWithAbnormalCredentials
  Scenario Outline:Unsuccessful login with abnormal credentials
    Given user on the login page
    When user enter existed "<email>" and abnormal "<password>"
    And click the login button
    Then user should see an error message "S0001629E: The account could not be found or the password did not match. Please try again."
    And stay on the login page
    Examples:
      |              email           |        password         |
      |  mbiz.vincent1@gmail.com      |         lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll            |
      |  mbiz.vincent1@gmail.com      |          NULL            |
      |  mbiz.vincent1@gmail.com      |          \" or \"\"=\"       |
      |  mbiz.vincent1@gmail.com      |          Dothevu270783!; DROP TABLE Suppliers       |

  @LoginIncorrectPasswordMultiple
  Scenario Outline: Account lockout after multiple failed attempts
    Given user on the login page
    When user attempt to enter correct "<email>" and incorrect "<password>" multiple
    And click the login button
    Then user should see the login blocked message
    Examples:
      |              email           |        password         |
      |  rivev84988@merotx.com      |      Dothevu270783      |

  @ForgotPasswordSent
  Scenario Outline: Send a request Forgot password
    Given user on the login page
    When user enter a valid "<email>" and open Forgotten Password popup
    And click OK button to send request
    Then user should see a Request reset password notification message
    Examples:
      |              email           |
      |  mbiz.vincent@gmail.com      |

  @ForgotPasswordCancelled
  Scenario Outline: Cancel Forgot password
    Given user on the login page
    When user enter a valid "<email>" and open Forgotten Password popup
    And click CANCEL button to cancel request
    Then Forgotten Password popup should be closed
    Examples:
      |              email           |
      |  mbiz.vincent@gmail.com      |