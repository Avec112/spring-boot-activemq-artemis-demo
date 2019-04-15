#Spring Boot and Apache ActiveMQ Artemis
[//]: # (logo here)

## Table of Contents
* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)




##About the project
This demo shows how a Spring Boot producer and consumer integrates with Apache ActiveMQ Artemis.  

The purpose of this demo is to show how you can setup Spring Boot by creating two separate micro services and communicate asynchronously via a message broker.

###Built with
* Spring Boot v2.1.4

##Getting started
###Prerequisites
* Docker (I used Docker Desktop 2.0.0.3 on a MacBook Pro)
* Java 11 (I am using [sdkman.io](https://sdkman.io) for easy install and switching between different Java versions)
* Maven. I used v3.6.1 (Same for Maven. I use [sdkman.io](https://sdkman.io) also here)
* Git

###Installation
#### Pull Artemis
We are using a [Docker image for Artemis](https://hub.docker.com/r/vromero/activemq-artemis)
```
> docker pull vromero/activemq-artemis
```
#### Start Artemis
Look [here](https://github.com/vromero/activemq-artemis-docker) for documentation
```
> docker run -it --rm \
   -p 8161:8161 \
   -p 61616:61616 \
   vromero/activemq-artemis
```

#### Clone this repo
```

```