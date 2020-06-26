Feature: Create user via API and search in Google and Facebook

  @Smoke
  @Test
  Scenario: Create user via API and search in Google and Facebook
    When Create new user via User API
    Then Status code from response is 200
    And First amd Last name are present in response
    When Open Google page
    And Search User in Google
    Then Check user facebook account is present in Google Search
