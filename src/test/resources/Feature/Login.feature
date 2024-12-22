Feature: Login

    Scenario: Login with valid credentials
        Given I launch browser and navigate to the login page
        When I click on the Log in section
        When I enter valid username "shubhamg2a50" into username field
        And I enter valid password "shubhamg2@50" into password field
        And I click on login button
        Then i successfully login
