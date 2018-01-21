web-crawler
=====================

Demonstrates a simple web crawler with depth.

# Assumption

This demo project assumes there is Internet Connection available for Unit testing.
The max depth is default to 3,and can be overridden in the method.

Jsoup is used as the  HTML parser, more features could be used to improve this project.
 
Swagger was planned for API documents, but didn't get chance to add it.

# Camel Components 
Apache Camel was planned to be used for split/aggregate, throttling, circuit break and caching; but I didn't get a chance to implement it.

# Prerequisites

* Java 8+
* Maven
* jsoup 1.11.2

# Configuration

This section describes the components which can be configured within the application
	
## Spring Boot

External configurations can be provided to Spring Boot in the `application.properties` file located in `src/main/resources`. These can be referenced by Spring Boot itself or as an external properties within Camel;

# Build and Deployment

Since the project is leveraging Spring Boot, it can be deployed in a number of different ways. The following sections describe these options

## Command Line

Use the Spring Boot Maven Plugin to launch the application. Run the following command in the project directory

    mvn clean spring-boot:run 

### Build and deploy

Build and package the project using the following command

    mvn clean install 

# Running the Application

Once successfully deployed, the application will be available at:

[http://localhost:8080/node-tree?url=http://www.qantasloyalty.com](http://localhost:8080/node-tree?url=http://www.qantasloyalty.com)

