Feature: Nombre del feature

  @test
  Scenario: Testing name one
    Given paso uno
    When paso dos
      | col uno   | col dos     |
      | dato uno  | dato dos    |
      | dato tres | dato cuatro |
    Then paso tres

  @Tag
  Scenario Outline: Testing name two
    Given paso uno
    When paso dos "<col uno>"
    Then paso tres "<col dos>"
    Examples:
      | col uno   | col dos     |
      | dato uno  | dato dos    |
      | dato tres | dato cuatro |
