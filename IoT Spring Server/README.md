# IoT Spring Server

## Getting Started

IoT Spring Boot Dashboard is a Maven project and it represents a comprehensive and reusable REST API back-end built with Spring Boot which queries Cassandra Database.
This project requires following tools and technologies.

* [JDK - 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven - 3.5.2](https://maven.apache.org/download.cgi)
* [Cassandra - 3.11.1](http://cassandra.apache.org/download/)
* [Spring Boot - 1.5.3](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/1.3.5.RELEASE)

Please refer "IoTData.cql" file to create Keyspace and Tables in Cassandra Database, which are required by this application. This is the same file which is available in "iot-spark-processor" project.

You can build and run this application using below commands. Please check resources/cassandra.properties for configuration details.

```
mvn clean package
cd target
java -jar masaccio-server-1.0-SNAPSHOT.jar
```
