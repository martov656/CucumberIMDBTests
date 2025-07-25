Feature: IMDb celebrity search

  @scarlett
  Scenario: User searches for Scarlett Johansson
    Given user open imdb and put keyword
    When the user enters "Scarlett Johansson" into the search field and presses Enter
    Then the user should see a link to "Scarlett Johansson"
    And the page should contain "Scarlett Johansson"
    And imdb browser is over

  @sandra
  Scenario: User searches for Sandra Bullock
    Given user open imdb and put keyword
    When the user enters "Sandra Bullock" into the search field and presses Enter
    Then the user should see a link to "Sandra Bullock"
    And the page should contain "Sandra Bullock"
    And imdb browser is over

  @victoria
  Scenario: User searches for Victoria Silvstedt
    Given user open imdb and put keyword
    When the user enters "Victoria Silvstedt" into the search field and presses Enter
    Then the user should see a link to "Victoria Silvstedt"
    And the page should contain "Victoria Silvstedt"
    And imdb browser is over

  @jennifer
  Scenario: User searches for Jennifer Aniston
    Given user open imdb and put keyword
    When the user enters "Jennifer Aniston" into the search field and presses Enter
    Then the user should see a link to "Jennifer Aniston"
    And the page should contain "Jennifer Aniston"
    And imdb browser is over

