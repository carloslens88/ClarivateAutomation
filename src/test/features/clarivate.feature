Feature: As a user, I want to navigate across the Clarivate Portal and perform CMC Intelligence Login

  Scenario Outline: Successful navigation to the Clarivate - Cortellis CMC Intelligence Login site
    Given Google search home page
    When Submit the search term <query>
    And Press on the expected search result
    Then Success navigation to the web site
    When Click on Products and Services tab
    And Select option "Generics & Manufacturing" under Biopharma Intelligence
    And Click on "Our solutions"
    And Choose option Cortellis CMC Intelligence
    And Navigate to option "Login"
    And Pick up option "Cortellis CMC Intelligence Login"
    Then Check the expected URL is <expectedResult>
    Examples:
      | query             | expectedResult                                  |
      | "Clarivate"       | "https://access.clarivate.com/login?app=cmc"    |