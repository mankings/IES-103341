# Lab 2.3 Notes

## Spring Boot
Spring Boot is an application development platform that assumes opionated choices by default, thus allowing you to get started with minumum effort and create stand-alone, production-grade applications. It's serves it's purpose prioritizing convention over configuration.

### Spring Initializr
Spring Initializr templates contain a collection of all
the relevant transitive dependencies that are needed to start a particular functionality and will
simplify the setup of the POM.

### Change the app port
Change this setting in the *src/main/resources/application.preferences* file:
```
server.port=8080            #default port
```

### Web Controllers
In Spring’s approach to building web sites, HTTP requests are handled by a controller.