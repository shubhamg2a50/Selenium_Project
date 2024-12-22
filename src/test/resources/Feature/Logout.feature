Feature: Logout

    Scenario: Verify logout after login validation
        Given user launch browser and navigate to the login page
        When user click on the Log in section
        When User enter valid username "shubhamg2a50" into username field
        And User enter valid password "shubhamg2@50" into password field
        And User click on login button
        Then User successfully login
        Then I click on logout option
