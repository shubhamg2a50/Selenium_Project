Feature: Sign Up Functionality

  Scenario: Verify the Sign Up process
    Given I am on the demoBlaze homepage
    When I click on the Sign Up option
    And I enter the username "anilg2ebc" and password "anil200446"
    And I click on the Sign Up button
    Then an alert message should popup with the message "Sign up successful."


 