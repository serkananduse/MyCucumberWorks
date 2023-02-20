@ben
Feature:User tests the searching results

  Scenario Outline:TC001 User makes different searchings and tests the results
    Given User goes to "AmazonUrl" home page.
    Then  User makes searching for "<product>".
    Then  User waits 2 minutes
    And   User tests whether the results contains "<product>".
    And   User closes driver

    Examples:
    |product|
    |iphone |
    |citizen|







