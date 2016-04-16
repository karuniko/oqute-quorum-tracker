# Online Quorum Tracker
###### This is an event manager application for supporting cases where possibility of a meeting depends on a number of attendees

The following features are included:

* backend
	* spring-core 4.2.5.RELEASE
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
- Use `mvn tomcat7:run-war` to deploy application to separate tomcat instance and run it there

**P.S:** During development, it's convenient to have the "npm", "bower", "grunt", "gulp" and "karma" commands available on the command line.
[Here are some useful scripts](https://github.com/eirslett/frontend-maven-plugin/tree/master/frontend-maven-plugin/src/it/example%20project/helper-scripts)
