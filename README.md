# Spring Cloud Task

This repository is an example of how we can create a simple Spring Cloud Task.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java JDK 8
* MySQL
* Maven

### Installing

* Clone repo
* Import the project in any IDE

### Build and Start the project

* mvn clean package
* java -jar "JARNAME.jar"

## Built With

* [Spring Cloud Task](https://spring.io/projects/spring-cloud-task)
* [Maven](https://maven.apache.org/) - Dependency Management
* MySQL

## Configuration

The task's job is to read from a file and insert into the database.
For the database there is a docker command provided. (look in the docker folder)
In application properties change the file location that will correspond to some file, and also adjust the database connection.
To be able to start it via REST API deploy it on Spring Cloud DataFlow
The steps are : 
1. Package it into jar
2. Install it in the local/cloud maven repository
3. Register the application in Spring Cloud DataFlow
4. Create the task in Spring Cloud DataFlow
5. Launch it via REST api,or via the UI.

To install the jar in the local maven repository use this command :
mvn install:install-file \
-Dfile=<path-to-file> \
-DgroupId=<group-id> \
-DartifactId=<artifact-id> \
-Dversion=<version> \
-Dpackaging=<packaging> \
-DgeneratePom=true

