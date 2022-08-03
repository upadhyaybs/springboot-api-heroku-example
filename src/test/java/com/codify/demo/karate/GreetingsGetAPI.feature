@tag
Feature: Greetings API Test

    Background:
      * url baseUrl
      * def greetingBase = '/spring-boot-api-heroku-demo'

    @getRestaurantList
    Scenario: Get Greetings
      Given path greetingBase + '/greetings'
      When method GET
      Then status 200
      And print response

