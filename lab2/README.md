# LAB02 NOTES
nmec: 103341

## Review Questions

### **A. What are the responsibilities/services of a "servlet container"?**
A *servlet container* is a server component responsible for handling the page resquests, allowing for dynamic page generation.  
It also handles concurrency, since it can process multiple requests simultaneously.

### **B. Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)**
Spring Boot uses the MVC pattern in which the application is divided in 3 components:  
After an HTTP request is made, the Controller receives and processes it. The Model is the middleware between the Controller and the View, which is being controlled and updated by the Controller The view is the component that allows the user to see the processed request.  
Exemple of this os the @Controller tag we used in the exercises.

### **C. Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies?**
They ease organization and readability, since Spring Boot starters help reduce the ammount of dependencies you had to manually add.

### **D. Which annotations are transitively included in the @SpringBootApplication?**
The classes @SpringBootApplication imports @EnableAutoConfiguration and @ComponentScan.

### **E. Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices, and briefly explain them in you own words.**

**Use logical nesting on endpoints.**  
When designing endpoints we should group related topics, both to be easier to understand and to avoid giving attackers unnecessary information. Exemple of this would be to append the /tables path to the end of the /furniture path in a online store.

**Handle errors gracefully and return standard error codes**  
We should do this to every type of application we develop but it's very important in API's so that we provide clarity to the clients. IT also helps maintainers understand more quickly the problem that's occurred.  
Some exemples of this would be:
* 403 Forbiden- Meaning the user is authenticated but has no permission to access a resource.
* 404 Not Found - When a resource can't be located.

**Cache data to improve performance**  
We can add caching to return data from local memory instead of queryin the database everytime we want to retrieve data. It also provides users with a more responsive application. Although we should be carefull because caching may give users outdated information.

**Maintain good security practices**  
Pretty much all information between client and server should be private, as people should't be access more information than they requested. We can enforce this privacy by giving users roles that provided them permissions to all the information they need and nothing more.

**Use nouns instead of verbs in endpoint paths**  
Http requests already include verbs like POST, GET, DELETE so we should give our endpoint paths, nouns that represent the entity that we are retrieving or manipulating. Also verbs are often similar and mean the same thing as get and retrieve providing no new information.