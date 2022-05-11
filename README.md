# Readme: api-missed-periods
RESTful web server developed with Spring & SpringBoot.

This simple service gets a randomly generated list of time periods with intervals of two dates from a REST service and returns the response in JSON format with the received and missing dates.



## Requirements

The fully fledged server uses the following:

* Spring Framework
* SpringBoot 2.6.7

## Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

## Building the project
You will need:

*	Java JDK 8 or higher
*	Maven 3 or higher

Clone the project and use Maven to build the server

	$ mvn clean install
Service packaging in JAR format

	$ mvn package
Finally run the service

	$ java -jar ./target/com-previred-periods-test-0.0.1-SNAPSHOT.jar
	
### Browser URL
Open your browser at the following URL for Swagger UI (giving REST interface details):
Please, before testing locally, you must have the gdd service initialized for it to work properly.


[http://localhost:8081](http://localhost:8081) or just click here -> [https://api-missed-periods.herokuapp.com](https://api-missed-periods.herokuapp.com)