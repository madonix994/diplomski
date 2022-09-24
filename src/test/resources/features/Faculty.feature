Feature: Faculty website test feature


  @smoke
  Scenario: Home page validations - Serbian Language
    Given User navigates to Faculty website
    When User selects Serbian language
    Then All elements are present on the page
    And All navbar elements are present

  @smoke
  Scenario: Home page validations - English Language
    Given User navigates to Faculty website
    When User selects English language
    Then All elements are present on the page
    And All navbar elements are present