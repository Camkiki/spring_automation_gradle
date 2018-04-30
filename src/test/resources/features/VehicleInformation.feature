Feature: Get Vehicle Information from DVLA

  Scenario: Check Vehicle Information
    Given GOV DVLA Platform
    When User Trigger Vehicle Enquiry with Registration Number
    Then Vehicle Details is returned in Confirm Vehicle Page
    And Returned Vehicle Details match Expected Result for Vehicle