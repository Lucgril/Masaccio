# IoT Spark Processor

## Getting Started

IoT Spark Processor is a Maven application for processing IoT Data streams using Apache Spark. Processed data is persisted in to Cassandra Database. This project requires following tools and technologies.

* [JDK - 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven - 3.5.2](https://maven.apache.org/download.cgi)
* [Zookeeper - 3.4.11](https://zookeeper.apache.org)
* [Kafka - 2.12-1.0.0](http://kafka.apache.org/downloads.html) 
* [Cassandra - 3.11.1](http://cassandra.apache.org/download/)

Please refer "IoTData.cql" file to create Keyspace and Tables in Cassandra Database, which are required by this application.

You can build and run this application using below commands. Please check resources/iot-spark.properties for configuration details.

```
mvn clean package
cd target
java -jar spark-streaming-1.0-SNAPSHOT.jar

```
