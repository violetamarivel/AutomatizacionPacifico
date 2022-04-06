Feature: API/Services - response validation

  @Testtoken
  Scenario: Validate auth token service
    Then I validate POST auth service
      | resource                             | expStatus | expAccessToken| expTokentype | comments         |
      | fc3220d2-0bcf-4bd4-8ffa-03f7837d61aa | 200       | true          |   true      | Solo Integracion |
      | 123456                               | 400       |               |         | Solo Integracion |
