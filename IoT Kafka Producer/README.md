# IoT Kafka Producer

## Getting Started

IoT Kafka Producer is a Maven application for generating IoT Data events using Apache Kafka. This project requires following tools and technologies.

* [JDK - 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven - 3.5.2](https://maven.apache.org/download.cgi)
* [Zookeeper - 3.4.11](https://zookeeper.apache.org)
* [Kafka - 2.12-1.0.0](http://kafka.apache.org/downloads.html) 

The main class IoTDataProducer generates semi-random IoT data in JSON with below format:
{"room": "1", "timestamp":1465471124373, "numberOfPeople": 45}.

For the second service, the method "generateMessages" has been added. So it is retrieved from the server application when a message is send by some user and is used to publish the message on the specific topic. The message will be processed by Spark and stored on the Cassandra database.

For the third service Multithreding capability has been added to our Java application. The main class creates two threads: the first one generates semi-random IoT data for the first service and the second one generates random accessRequest data in JSON with the below format:
{"item": "room1", "carduid": "abcdef12", "timestamp": "2018-01-13 03:26:18"}.

Please run below command to install this project in your local Maven repository so that it can be used by the server application.

```
mvn install
```

You can build and run this project using below commands. Please check resources/iot-kafka.properties for configuration details.

```
mvn clean package
cd target
java -jar kafka-1.0-SNAPSHOT.jar
```

