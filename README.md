# Masaccio - Monitoring for urbAn SAfety with the IoT

## Getting Started

Traffic Monitor application uses following tools and technologies.

* [JDK - 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven - 3.5.2](https://maven.apache.org/download.cgi)
* [Zookeeper - 3.4.11](https://zookeeper.apache.org)
* [Kafka - 2.12-1.0.0](http://kafka.apache.org/downloads.html) 
* [Cassandra - 3.11.1](http://cassandra.apache.org/download/)
* [Spark - 2.2.1 Pre-built forhadoop2.7](http://spark.apache.org/downloads.html)
* [Spring Boot - 1.5.3](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/1.3.5.RELEASE)
* jQuery.js
* Chart.js

IoT Traffic Monitor is a Maven Aggregator project. It includes following four projects.

* IoT Kafka Producer
* IoT Spark Processor
* IoT Spring Server
* Administrator Dashboard

For building these projects it requires following tools. Please refer README.md files of individual projects for more details.

Use below command to build all projects.

```
mvn clean package
```
