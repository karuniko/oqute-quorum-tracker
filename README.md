# Online Quorum Tracker
###### This is an event manager application for supporting cases where possibility of a meeting depends on a number of attendees

The following features are included:

* backend
    * spring-boot `1.3.3`
    * spring-web (embedded tomcat)
    * spring-data (hibernate + mysql)
    * flyway
    * quartz-scheduler
    * spring-test (assertj separately)
    * spring-logging
    * spring-security
    * spring-mail
* frontend
    * node.js
    * npm
    * bower
    * gulp
    * karma

- Clone this project first `git clone https://github.com/karuniko/oqute-quorum-tracker.git local-folder`
- `cd local-folder`
- Use `mvn clean install` to build it
- Use `mvn org.apache.tomcat.maven:tomcat7-maven-plugin:2.2:run-war` to run the separate tomcat instance

**P.S:** During development, it's convenient to have the "npm", "bower", "grunt", "gulp" and "karma" commands available on the command line.
[Here are some useful scripts](https://github.com/eirslett/frontend-maven-plugin/tree/master/frontend-maven-plugin/src/it/example%20project/helper-scripts)
