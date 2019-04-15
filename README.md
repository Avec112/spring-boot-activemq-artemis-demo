# Spring Boot and Apache ActiveMQ Artemis
[//]: # (logo here)

## Table of Contents
* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Clean up](#clean-up)




## About the project
This demo shows how a Spring Boot producer and consumer integrates with Apache ActiveMQ Artemis.  

The purpose of this demo is to show how you can setup Spring Boot by creating two separate micro services and communicate asynchronously via a message broker.

### Built with
* Spring Boot v2.1.4

## Getting started
### Prerequisites
* Docker (I used Docker Desktop 2.0.0.3 on a MacBook Pro)
* Java 11 (I am using [sdkman.io](https://sdkman.io) for easy install and switching between different Java versions)
* Maven. I used v3.6.1 (Same as for Java. I use [sdkman.io](https://sdkman.io))
* Git

### Installation

You will need two separate terminals (shells/prompts).


#### Clone this repo
```
git clone xxx
```

#### Build Consumer-app
In the same terminal build Consumer application. We will call this the Consumer terminal.
```
> cd ./spring-boot-activemq-artemis-demo/consumer
> mvn clean install
```

#### Build Production-app
In a separate terminal build Producer application. We will call this the Producer terminal.
```
> cd ./spring-boot-activemq-artemis-demo/producer
> mvn clean install
```
Start producer application. Messages will be produced and application close down.  
__Watch the consumer shell for messages when running this command!__
```
> mvn spring-boot:run
```

## Usage

* Start Artemis (docker container)
* Start the Consumer application (consumed messages will be printed to stdout)
* Start the Producer application (it will produce messages at startup)

### Start docker container (Artemis)
In either terminal, start the container containing Artemis.  
We are running in detached (-d) mode.  
```
> docker run -it --rm -d \
   -p 8161:8161 \
   -p 61616:61616 \
   vromero/activemq-artemis:latest-alpine
```
Look [here](https://github.com/vromero/activemq-artemis-docker) for further documentation about the Apache ActiveMQ Artemis Docker container.

#### Start Consumer application
Go to Consumer terminal and start the Consumer application.   
It will start listening for new messages. 
```
mvn spring-boot:run
```
Or you can start the application like this.
```
> java -jar ./target/consumer-0.1.0-SNAPSHOT.jar
```

#### Start Producer application
Open the Producer terminal and start Producer application.   
Messages will be produced and the application will then terminate.  
__Watch the consumer shell for messages when running this command!__
```
> mvn spring-boot:run
```
Or you can start the application like this.
```
> java -jar ./target/producer-0.1.0-SNAPSHOT.jar
```

## Clean up
### Stop docker container (Artemis)
List running containers to find the correct ID for Artemis.
```
> docker ps
```
Stop the container by providing ID or NAME.
```
> docker stop [container id or name]
```

### Remove docker image (Artemis)
List images to find the correct ID for Artemis.
```
> docker images
```
Remove the image.
```
> docker rmi [image id]
```
