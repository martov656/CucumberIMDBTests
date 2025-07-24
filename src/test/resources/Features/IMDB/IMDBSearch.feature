Feature: IMDb celebrity search with multiple names

  @multiple
  Scenario: User searches for multiple celebrities on IMDb
    Given the user opens the IMDb homepage
    When the user searches for the following celebrities:
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

  @multiple2
  Scenario: User searches for multiple movies on IMDb
    Given user opens movie database home page
    When user is searching for the following movies:
      | Dr. No             |
      | Gravitace          |
      | Match Point        |
      | Šílený Max 2: Bojovník silnic|
      | Sedm               |
      |Expendables: Postradatelní 2|
      |Vetřelec 3|
      |Letiště|
      |Airport 1975|
      |Osvícení|
      |Rocky|

    Then imdb browser is closed

  @multiple3
  Scenario: User searches for multiple Reese Witherspoon movies on IMDb
    Given user opens movie database home page
    When user is searching for the following movies:
      | Pravá blondýnka    |
      |Poznáš, až to přijde?|
      |Voda pro slony|
      |The Morning Show|
      |Tohle je válka!|
      |Který je ten pravý?|
      |Sedmilhářky|
      |Jarmark marnosti|
      |Sedmilhářky|

    Then imdb browser is closed

  @multiple4
  Scenario: User searches for multiple Reese movies on IMDb
    Given user opens movie database home page
    When user is searching for the following movies:
      |Poznáš, až to přijde?|
      |Voda pro slony|
      |The Morning Show|
      |Tohle je válka!|
      |Který je ten pravý?|
      |Sedmilhářky|
      |Jarmark marnosti|
      |Sedmilhářky|

    Then imdb browser is closed
