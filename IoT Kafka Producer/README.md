# IoT Kafka Producer

## Getting Started

IoT Kafka Producer is a Maven application for generating IoT Data events using Apache Kafka. This project requires following tools and technologies.

* [JDK - 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven - 3.5.2](https://maven.apache.org/download.cgi)
* [Zookeeper - 3.4.11](https://zookeeper.apache.org)
* [Kafka - 2.12-1.0.0](http://kafka.apache.org/downloads.html) 

The main class IoTDataProducer Method generates semi-random IoT data in JSON with below format:
{"room": "1", "timestamp":1465471124373, "numberOfPeople": 45}.

You can build and run this application using below commands. Please check resources/iot-kafka.properties for configuration details.

```
mvn clean package
cd target
java -jar kafka-1.0-SNAPSHOT.jar
```

