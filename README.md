# Toktive Web

## About
Toktive Web is a REST project that utilizes the [Toktive API](../../../toktive).

## Motivation
I wanted to create a separate project for the Web layer, so that the API can be reused by other platforms (smartphone app, smartwatch, Nintendo Switch, console client, etc.). There is enough code in the API now, so I thought why not start this? 

Please see the general motivation at the [API project](../../../toktive).

## Setup
I made this application in Eclipse 2020-06 (4.16.0), with full support for Java EE. Initial Spring classes and Maven config files are generated via Spring Initializr.

To set this up in Eclipse, all you need to do is simply:
1. [Setup Toktive on your workspace](../../../toktive/README.md). Remember to build the Toktive API first before having the web project built.
2. Import the project via Git.
3. Run an `mvnw install` (or `mvn` if you have it installed on your machine) and update the project.

While this is created using Eclipse, it's not necessary to stick with it. Also while not required, it helps to start having the project build with Maven and allow Git to be used. Please look up for the equivalent steps for your preferred IDE.

## Usage
Simply run the project with Spring Boot, and it automatically creates all you need such as the web server already configured with a port together with the project deployed on it. You can do this at the console with the command:

`mvnw spring-boot:run`

Or simply run the Main class `io.github.jmgloria07.toktive.web.ToktiveWebApplication` as a Java Application once the setup is done.

## Future Plans
- Frontend files on this project are simple barebones HTML that calls the REST counterparts. I'm planning to create a separate front-end project that utilizes React or Angular.
- Make it such that the client handles the authentication.
- Exception handling/mapping, logging, better request-response objects, miscellaneous stuffs