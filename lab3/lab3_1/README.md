# Lab 3.1 Notes

### The "QuoteController” class gets an instance of “quoteRepository” through its constructor; how is this new repository instantiated?
The *quoteRepository* instance is instantiated through the *@Autowired* annotation. When used as a Spring Bean, the constructor is autowired.

### List the methods invoked in the “quoteRepository” object by the "QuoteController”. Where are these methods defined?
* *findAll()* - returns all entities
* *findById()* - returns a certain entity specified by id
* *save()* - saves an entity
* *delete()* - deletes an entity

The *QuoteRepository* is an extension of the class *CrudRepository*, which means that it will inherit it's methods and constructors. Thus, the used methods come from it's super class.

### Where is the data being saved?
The data is being saved inside the quoteRepository object.

### Where is the rule for the “not empty” show name defined?
It's defined in the *Quote.java* class file:
```
@NotBlank(message = "Show name is mandatory")
private String showname;
```