Feature: Scripted provisioning of target environment
    As a developer
    I would like a scripted installation of my target environment
    so that I can assume the environment will be the same everytime and my deployments will be predictable

    Background:
        Given I am sshed into the environment
    
    Scenario: Is Tomcat Running?
        When I run "ps -ef | grep tomcat6"
        Then I should see "tomcat"
        
    Scenario: Is Java installed?
        When I run "java"
        Then I should see "Usage: java"
        
    
