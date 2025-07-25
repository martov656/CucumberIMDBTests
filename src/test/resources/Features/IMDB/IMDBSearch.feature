Feature: IMDb celebrity search with multiple movies


  @multiple
  Scenario: User searches for multiple movies on IMDb
    Given user opens movie database home page
    When user is searching for the following movies:
      | Dr. No          |
      | Goldfinger          |
      | Vetřelec          |
      | Vetřelci          |
      | Gravitace          |
      |Ztracené město Z|
      | Match Point - Hra osudu|
      | Šílený Max 2: Bojovník silnic|
      | Sedm               |
      |Expendables: Postradatelní 2|
      |Vetřelec 3|
      |Letiště|
      |Airport 1975|
      |Osvícení|
      |Rocky|

    Then imdb browser is closed

  @multiple
  Scenario: User searches for multiple Reese Witherspoon movies on IMDb
    Given user opens movie database home page
    When user is searching for the following movies:
      |Pravá blondýnka    |
      |Pravá blondýnka 2  |
      |Poznáš, až to přijde?|
      |Voda pro slony|
      |The Morning Show|
      |Tohle je válka!|
      |Který je ten pravý?|
      |Milenec nebo vrah|
      |Jarmark marnosti|
      |Sedmilhářky|
      |Sami v pousti|
      |You're Cordially Invited|


    Then imdb browser is closed

  @multiple
  Scenario: User searches for multiple Sandra Bullock movies on IMDb
    Given user opens movie database home page
    When user is searching for the following movies:
      |Návrh|
      |Ztracené město|
      |Nebezpečná rychlost|
      |Magická posedlost|
      |Predtucha|
      |Demolition Man|
      |Živelná pohroma|
      |Dům u jezera|

    Then imdb browser is closed
