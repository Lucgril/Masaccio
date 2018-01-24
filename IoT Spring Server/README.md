# IoT Spring Server

## Getting Started

IoT Spring Boot Dashboard is a Maven project and it represents a comprehensive and reusable REST API back-end built with Spring Boot which queries Cassandra Database.

For the realization of the second service we have also used Spring Security. It is used for authentication and authorization purposes in our application. We added role based access to our pages, aka Authorization, so that a user, after logging in, can only browse the pages that he or she is allowed to browse. We have secured our Rest back-end with it.
We have used a relational database (MySQL) for store all the information about the registered users and their permissions.

The view part has been moved on this project as well. In additional to the login page there are two jsp pages connected by a menu¹: IoTRoomData.jsp and firstResponderCommunication.jps. The first one is the administrator dashboard that shows the number of people in each room and it is the one we realized for the first service. The second one is the platform for the first responder communication: there the people allowed to use the platform, can send a new message and see the list of messages already sent. When a message is written down, it is sent to the server by a Rest Api and published on Kafka in a specific topic. Then it will be processed and stored in the Cassandra database. 
It is possible to logging out as well.

This project requires following tools and technologies.

* [JDK - 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven - 3.5.2](https://maven.apache.org/download.cgi)
* [Cassandra - 3.11.1](http://cassandra.apache.org/download/)
* [Spring Boot - 1.5.3](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/1.3.5.RELEASE)
* [Spring Security - 5.0.1](https://projects.spring.io/spring-security/)
* bootstrap
* jQuery.js
* Chart.js


Please refer "IoTData.cql" file to create Keyspace and Tables in Cassandra Database, which are required by this application. This is the same file which is available in "IoT Spark Processor" project.

Please refer "UserRules.cql" file to craete Database and Tables in MySQL, which are required by this application.

You can build and run this application using below commands. Please check resources/cassandra.properties and resources/application.properties for configuration details.

```
mvn clean package
cd target
java -jar masaccio-server-1.0-SNAPSHOT.jar
```
