# Toktive Web

## About
Toktive Web is a REST service/web application that utilizes the [Toktive API](../../../toktive).

## Motivation
I wanted to create a separate project for the Web layer, so that the API can be reused by other platforms (smartphone app, smartwatch, Nintendo Switch, console client, etc.). There is enough code in the API now, so I thought why not start this? 

Please see the general motivation at the [API project](../../../toktive).

## Setup
I made this application in Eclipse 2020-06 (4.16.0), with full support for Java EE. Initial Spring classes and Maven config files are generated via Spring Initializr.

To set this up in Eclipse, all you need to do is simply:
1. [Setup Toktive on your workspace](../../../toktive/blob/master/README.md). 
    - Remember to build the Toktive API first before having the web project built. 
    - And make sure the maven versions at pom.xml are consistent at both projects
2. Import the project via Git.
3. Run an `mvnw install` (or `mvn` if you prefer your own maven instance installed on your machine) and update the project.

While this is created using Eclipse, it's not necessary to actually use the same IDE. It helps to start having the project build with Maven and allow Git to be used. Please look up for the equivalent steps for your preferred IDE.

## Usage
Simply run the project with Spring Boot, and it automatically creates all you need such as the web server already configured with a port together with the project deployed on it. You can do this at the console with the command:

`mvnw spring-boot:run`

Or simply run the Main class `io.github.jmgloria07.toktive.web.ToktiveWebApplication` as a Java Application (through Eclipse) once the setup is done.

With this you can then run your server instance (usually localhost:8080) on your web browser and, post your thoughts to your social media accounts. 

### REST methods
GET /toktive returns all social networks supported in a list of `SocialNetworkResponse` format.

GET /toktive/{social-network} returns a `SocialNetworkWeb` response as defined by the `{social-network}` path variable.

POST /toktive will post the parameter status and return a `ToktiveWebResponse` object.

## Future Plans
- Utilize spring-boot's exception handling/mapping.
- Improve tests.
- Implement proper logging.
- Apply basic security on the application.
- Make it such that the client, rather than the API, handles the authentication.
- Frontend files on this project are simple barebones HTML that calls the REST counterparts. I'm planning to create a separate front-end project that utilizes React or Angular.
