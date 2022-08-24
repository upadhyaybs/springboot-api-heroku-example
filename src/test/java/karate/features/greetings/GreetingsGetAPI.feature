Feature: Greetings API Test

    Background:
      * url baseUrl
      * def greetingBase = '/rest/api'
      * configure logPrettyRequest = true
      * configure logPrettyResponse = true

    @DefaultGreeting
    Scenario: Get Greetings
      Given path greetingBase + '/greetings'
      When method GET
      Then status 200
      And print response
      And match response == read('greetings-expected.json')

    @SayHello
    Scenario: Say Hello to Passed Name
          Given path greetingBase + '/greetings/hello'
          And param name = 'John Doe'
          When method GET
          Then status 200
          And print response

