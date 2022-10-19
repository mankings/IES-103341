# Lab 3 Notes

## **Review Questions**

## A. Explain the differences between the RestController and Controller components used in different parts of this lab.

***@Controller***
* it's a common annotation use to mark a class as a *Spring MVC Controller*
* it's a *@Component* annotation's specialization

***@RestController***
* é um controlador especial usado em serviços web RESTFul e o equivalente de @Controller + @ResponseBody.
* it's a special controller used in *RESTful* web services and the equivalent to a *@Controller* + *@ResponseBody*
* indicates that the class is a controller where the *@RequestMapping* methods assume *@ResponseBody*'s semantics by default
* it's a *@Controller* annotation's specialization

## B. Create a visualization of the Spring Boot layers (UML diagramor similar), displaying the key abstractions in the solution of 3.3, in particular: entities, repositories, services and REST controllers.

![Layer Diagram](lab3_3/assets/quoteapp_diagram.png?raw=true "Layer Diagram")

## C) Explain the annotations @Table, @Colum, @Id foundin the Employee entity.

**@Table** - each class of an entity maps a table in the default schema of the database with the given name

**@Column** - an optional annotation that allows you to costumize the mapping between the entity and the column of the database

**Id** - specifies at least a primary key attribute for each entity


## D) Explain the use of the annotation @AutoWired (in the Rest Controller class).
The *@Autowired* annotation provides more fine-grained control over where and how autowiring should be accomplished. The *@Autowired* annotation can be used to autowire bean on the setter method just like *@Required* annotation, constructor, a property or methods with arbitrary names and/or multiple arguments.