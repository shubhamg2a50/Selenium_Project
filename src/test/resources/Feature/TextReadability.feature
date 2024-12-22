Feature: Text Readability and Visibility

    Scenario: Verify text visibility and readability on the demoBlaze website
        Given I launch the demoBlaze website
        When I verify the visibility of all card text elements
        Then all card text elements should be visible and readable
