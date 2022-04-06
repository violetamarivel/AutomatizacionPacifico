Feature: API/Services - Create Booking

  @TestCreateBoooking
  Scenario: Validate booking creation
    Then I validate POST create booking
      | file              | expStatus |
      | Booking1.json     |  200      |
      | Booking1.json     |  200      | 

