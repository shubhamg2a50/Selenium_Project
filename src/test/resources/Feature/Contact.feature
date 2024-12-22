Feature: Contact Section Functionality

Scenario: Submit the Contact Us form with valid inputs
    Given I am on the Demoblaze homepage
    When I click on the "Contact" option
    And I enter "test@example.com" in the contact email field
    And I enter "John Doe" in the contact name field
    And I enter "This is a test message." in the message field
    And I click on the "Send Message" button
    Then I should see an alert with the message "Thanks for the message!!"