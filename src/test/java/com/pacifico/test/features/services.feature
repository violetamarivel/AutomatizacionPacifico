Feature: API/Services - response validation

  @Tag
  Scenario: Validate auth token service
    Then I validate POST auth service
      | resource                             | expStatus | expAccessToken | expTokentype | comments         |
      | 3335e89d-f67a-4b6e-85e1-f32c5413e512 | 200       | true           | true         | Solo Integracion |
      | 123456                               | 400       |                |              | Solo Integracion |
      | skajdkaskdla                         | 500       |                |              | Solo Integracion |

