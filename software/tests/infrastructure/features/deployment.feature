Feature: Scripted provisioning of target environment
    As a developer
    I would like a scripted deployment
    so that I can assume the deployment will work the same way everytime

    Background:
        Given I am sshed into the environment

    Scenario: Is Tomcat Running?
        When I run "ps -ef | grep tomcat6"
        Then I should see "tomcat"
        
    Scenario: The application is up and running
        When I run "/usr/bin/wget -qO- http://target.devopscloud.com"
        Then I should see "Brewery Manager"
        
    
