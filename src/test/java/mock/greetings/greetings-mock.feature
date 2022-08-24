Feature: stateful mock server

Background:

Scenario: pathMatches('/rest/api/greetings')
    * def response = { 'Hello ! This is Spring Boot API Demo App.' }