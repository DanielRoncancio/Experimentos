Feature: Get Character from the API

  Scenario: Get character using ID
    Given the user can get characters from the rick and morty api
    When he asks for the charater with id "10"
    Then he verifies the status code is "200"
    And he verifies the name is "Alan Rails"

  @MulpiplesIds
  Scenario: Get multiple characters sending multiple id without square brackets
    Given the user can get characters from the rick and morty api
    When he asks for the charater with id
      | 10 | 11 | 12 | 13 |
    Then he verifies the status code is "200"
