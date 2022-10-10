# Lab 2.1 Notes

## Start or Stop Tomcat
```
$ ./catalina.sh [start|stop]
```

## Acess Tomcat
```
localhost:8080
```
```
localhost:8080/manager
```
User: *admin*  
Password: *admin*  
Configured in ***conf/tomcat-users.xml***  

## Deplying a web app into Tomcat
You can make a sample Java web app using Maven:
```
archetypeGroupId = org.codehaus.mojo.archetypes  
archetypeArtifactId = webapp-javaee7  
archetypeVersion = 1.1  
```

First, build the project with:
```
$ mvn install
```

This creates a **.war** file, which is your application packaged as a Web Archive.  

To deploy it into the application server, either use the Tomcat Manager (*localhost:8080*) or copy the **.war** file into the */webapps* folder located in the Tomcat root folder.

If your app was succesfully deployed, it should be listed in the Manager app and available on:
```
localhost:8080/your-web-app-name/
```

## Servlets
Servlets are not static; they are dynamic. You can take content from the server, a database, or even another webpage, and display it on your servlet.

Servlets make it easy to create web applications that adhere to a request and response life cycle. They can provide HTTP responses and process business logic within the same body of code.

### Servlet Parameters
You can pass parameters on your HTTP request that your servlet will handle, and publish a response accordingly. To get a specific parameter, you use the *getParameter()* method:
```
String value1 = request.getParameter("param1");
String value2 = request.getParameter("param2");
```