Feature: IMDb celebrity search

  @multiple
  Scenario: User searches for Scarlett Johansson
    Given user open imdb and put keyword
    When the user enters "Scarlett Johansson" into the search field and presses Enter
    Then the user should see a link to "Scarlett Johansson"
    And the page should contain "Scarlett Johansson"
    And imdb browser is over

  @multiple
  Scenario: User searches for Sandra Bullock
    Given user open imdb and put keyword
    When the user enters "Sandra Bullock" into the search field and presses Enter
    Then the user should see a link to "Sandra Bullock"
    And the page should contain "Sandra Bullock"
    And imdb browser is over

  @multiple
  Scenario: User searches for Victoria Silvstedt
    Given user open imdb and put keyword
    When the user enters "Victoria Silvstedt" into the search field and presses Enter
    Then the user should see a link to "Victoria Silvstedt"
    And the page should contain "Victoria Silvstedt"
    And imdb browser is over

  @multiple
  Scenario: User searches for Jennifer Aniston
    Given user open imdb and put keyword
    When the user enters "Jennifer Aniston" into the search field and presses Enter
    Then the user should see a link to "Jennifer Aniston"
    And the page should contain "Jennifer Aniston"
    And imdb browser is over

  @multiple
  Scenario: User searches for multiple celebrities on IMDb
    Given the user opens the IMDb homepage
    When the user searches for the following celebrities:
      | Eva Longoria       |
      | Reese Witherspoon  |
      | Sandra Bullock     |
      | Scarlett Johansson |
      | Tom Cruise         |
      | Brad Pitt          |
      | Ridley Scott       |
      | Steven Spielberg   |
      | Karen Black        |
      | Chuck Norris       |
      | Michael Dudikoff   |
      | David Bowie        |
      | Alan Alda          |

    Then the browser is closed

