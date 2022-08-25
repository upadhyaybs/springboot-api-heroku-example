Feature: Testing our demo mock server with a feature that startes the demo mock server in first

Background:

Scenario: pathMatches('/rest/api/greetings') && methodIs('get')
    * def response = 'Hello ! This is Spring Boot API Demo App.'

Scenario: pathMatches('/rest/api/greetings/hello') && methodIs('get')
    * def response = 'Hello ' + paramValue('name')