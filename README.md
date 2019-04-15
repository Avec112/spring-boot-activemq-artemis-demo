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
We are running the container with in [detached](https://docs.docker.com/engine/reference/run/#detached--d) (-d) mode.  
```
> docker run -it --rm -d \
   -e ARTEMIS_USERNAME=admin \
   -e ARTEMIS_PASSWORD=admin \
   -p 8161:8161 \
   -p 61616:61616 \
   vromero/activemq-artemis:latest-alpine
```
See [documentation](https://github.com/vromero/activemq-artemis-docker) for further information about the Apache ActiveMQ Artemis Docker container configuration.

You can verify that Artemis is up by accessing the url http://localhost:8161 (admin/admin)

#### Start Producer application
Open the Producer terminal and start Producer application.   
Messages will be produced and the application will then terminate.  
__Watch the consumer shell for messages when running this command!__
```
> mvn spring-boot:run
```
Or you can start the application like this.

But first package jar with dependencies.  
```          
> mvn package
```
Then
```
> java -jar target/producer-0.1.0-SNAPSHOT.jar
```
The application will produce messages and print to output like this.
```
Produced 100 messages.
Produced 200 messages.
Produced 300 messages.
Produced 400 messages.
Produced 500 messages.
Produced 600 messages.
Produced 700 messages.
Produced 800 messages.
Produced 900 messages.
Produced 1000 messages.
Finished creating messages.
```
#### Start Consumer application
Go to Consumer terminal and start the Consumer application.   
It will start listening for new messages. 
```
mvn spring-boot:run
```
Or you can start the application like this.  

But first package jar with dependencies.
```
> mvn package
```
Then
```
> java -jar target/consumer-0.1.0-SNAPSHOT.jar
```
The application will consume messages and print to output like this.
```
Listening for messages. CTRL + C to quit.
100 messages processed.
200 messages processed.
300 messages processed.
400 messages processed.
500 messages processed.
600 messages processed.
700 messages processed.
800 messages processed.
900 messages processed.
1000 messages processed.
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
